package br.com.akj.template.resource.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.akj.template.dto.HelloUserResponse;
import br.com.akj.template.service.user.HelloUserService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/hello-user")
@RequiredArgsConstructor
public class HelloUserController {

    private final HelloUserService helloUserService;

    @GetMapping
    public ResponseEntity<HelloUserResponse> hello(@RequestParam final String name) {
        return ResponseEntity.ok(helloUserService.hello(name));
    }
}
