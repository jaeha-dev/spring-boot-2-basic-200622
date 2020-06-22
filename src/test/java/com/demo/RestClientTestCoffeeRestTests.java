package com.demo;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.HttpServerErrorException;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RunWith(SpringRunner.class)
@RestClientTest(CoffeeRestService.class) // 테스트 대상이 되는 빈을 주입한다.
public class RestClientTestCoffeeRestTests {

    @Rule
    // @Rule로 지정한 필드 값은 @Before, @After 상관없이 하나의 테스트 메소드가 끝날 때마다 정의한 값으로 초기화한다.
    public ExpectedException thrown = ExpectedException.none();

    @Autowired
    private CoffeeRestService coffeeRestService;

    @Autowired
    // 클라이언트와 서버 사이의 REST 테스트를 위한 객체
    private MockRestServiceServer server;

    @Test
    public void rest_테스트() {
        // /rest/test 요청에 대해 test.json 파일의 데이터를 응답으로 주도록 지정한다.
        // (테스트 코드의 리소스 루트 경로는 /test/resources이다.)
        this.server.expect(requestTo("/rest/test"))
                   .andRespond(withSuccess(new ClassPathResource("/test.json", getClass()), MediaType.APPLICATION_JSON));

        // 서버가 위에서 지정한 응답을 보낸다는 가정 하에 데이터를 받아온 후, 확인한다.
        Coffee coffee = this.coffeeRestService.getRestCoffee();
        assertThat(coffee.getName()).isEqualTo("테스트");
    }

    @Test
    public void rest_에러_테스트() {
        // /rest/test 요청에 대해 서버 에러를 발생한다고 가정한다.
        this.server.expect(requestTo("/rest/test"))
                   .andRespond(withServerError());

        // 에러 객체의 expect() 메소드로 어떤 에러가 발생하는지 지정한다.
        this.thrown.expect(HttpServerErrorException.class);

        this.coffeeRestService.getRestCoffee();
    }
}