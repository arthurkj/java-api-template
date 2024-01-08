package br.com.akj.template.dto;

import jakarta.validation.constraints.NotBlank;

public record HelloUserRequest(@NotBlank String name) {

}
