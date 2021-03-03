package com.techshard.graphql;

import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import io.micrometer.core.instrument.util.IOUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static java.lang.String.format;
import static org.assertj.core.api.Assertions.assertThat;
import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = TestApplication.class)
public class BankAccountQueryTest {

    private static final String GRAPHQL_QUERY_CREATE_REQUEST_PATH = "graphql/resolver/query/request/create_bank_account.graphql";
    private static final String GRAPHQL_QUERY_REQUEST_PATH = "graphql/resolver/query/request/bank_account.graphql";
    private static final String GRAPHQL_QUERY_RESPONSE_PATH = "graphql/resolver/query/response/%s.json";

    @Autowired
    GraphQLTestTemplate graphQLTestTemplate;

    @Test
    void bank_accounts_are_returned() throws IOException, JSONException {
        String testName = "bank_account";

        graphQLTestTemplate
                .postForResource(format(GRAPHQL_QUERY_CREATE_REQUEST_PATH, testName));

        final GraphQLResponse graphQLResponse = graphQLTestTemplate
                .postForResource(format(GRAPHQL_QUERY_REQUEST_PATH, testName));

        final String expectedResponseBody = read(format(GRAPHQL_QUERY_RESPONSE_PATH, testName));

        assertThat(graphQLResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
        final String body = graphQLResponse.getRawResponse().getBody();
        System.out.println("expectedResponseBody=" + expectedResponseBody);
        System.out.println("body=" + body);
        assertEquals(expectedResponseBody, body, true);
    }

    private String read(String location) throws IOException {
        return IOUtils.toString(
                new ClassPathResource(location).getInputStream(), StandardCharsets.UTF_8);
    }
}
