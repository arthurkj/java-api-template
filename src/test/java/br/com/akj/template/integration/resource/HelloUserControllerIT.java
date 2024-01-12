package br.com.akj.template.integration.resource;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Objects;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.akj.template.dto.HelloUserResponse;
import br.com.akj.template.entity.UserEntity;
import br.com.akj.template.errors.dto.ErrorDTO;
import br.com.akj.template.fixture.Fixture;
import br.com.akj.template.integration.BaseIntegrationTest;
import br.com.akj.template.repository.UserRepository;

public class HelloUserControllerIT extends BaseIntegrationTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Autowired
    UserRepository userRepository;

    @Test
    public void hello_should_have_success() {
        final String name = "name";
        final UserEntity user = Fixture.make(UserEntity.class);
        user.setName(name.toUpperCase());

        userRepository.save(user);

        final UriComponentsBuilder uriBuilder = UriComponentsBuilder
            .fromUriString("/v1/hello-user")
            .queryParam("name", name);

        final ResponseEntity<HelloUserResponse> result = restTemplate.getForEntity(uriBuilder.toUriString(), HelloUserResponse.class);

        assertNotNull(result);
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertTrue(Objects.requireNonNull(result.getBody()).message().contains(name));
    }

    @Test
    public void hello_should_return_404_when_user_not_found() {
        final String name = "name";

        final UriComponentsBuilder uriBuilder = UriComponentsBuilder
            .fromUriString("/v1/hello-user")
            .queryParam("name", name);

        final ResponseEntity<ErrorDTO> result = restTemplate.getForEntity(uriBuilder.toUriString(), ErrorDTO.class);

        assertNotNull(result);
        assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());
    }

}
