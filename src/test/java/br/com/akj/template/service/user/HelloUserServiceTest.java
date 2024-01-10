package br.com.akj.template.service.user;

import static br.com.akj.template.service.user.HelloUserService.HELLO_USER_MESSAGE;
import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.akj.template.dto.HelloUserResponse;
import br.com.akj.template.entity.UserEntity;
import br.com.akj.template.exception.BusinessErrorException;
import br.com.akj.template.fixture.Fixture;
import br.com.akj.template.helper.MessageHelper;
import br.com.akj.template.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class HelloUserServiceTest {

    @InjectMocks
    private HelloUserService service;

    @Mock
    private UserRepository userRepository;

    @Mock
    private MessageHelper messageHelper;

    @Test
    void hello_ok() {
        final String name = random(10);

        final UserEntity user = Fixture.make(UserEntity.class);

        when(userRepository.findByName(name.toUpperCase())).thenReturn(Optional.of(user));

        final HelloUserResponse result = service.hello(name);

        assertNotNull(result);
        assertEquals(String.format(HELLO_USER_MESSAGE, name), result.message());
    }

    @Test
    void hello_not_found() {
        final String name = random(10);

        when(userRepository.findByName(name.toUpperCase())).thenReturn(Optional.empty());

        assertThrows(BusinessErrorException.class, () -> service.hello(name));
    }
}