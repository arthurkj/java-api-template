package br.com.akj.template.service.user;

import org.springframework.stereotype.Service;

import br.com.akj.template.dto.HelloUserResponse;
import br.com.akj.template.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class HelloUserService {

    public static final String HELLO_USER_MESSAGE = "Hello %s!";
    private final UserRepository userRepository;

    public HelloUserResponse hello(final String name) {
        log.info("Say hi to {}!", name);

        return new HelloUserResponse(String.format(HELLO_USER_MESSAGE, name));
    }
}
