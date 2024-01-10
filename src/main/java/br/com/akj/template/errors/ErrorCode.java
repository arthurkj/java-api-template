package br.com.akj.template.errors;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public enum ErrorCode {

    CODE_0001("TEMPLATE_API-0001"),
    CODE_0002("TEMPLATE_API-0002"),
    CODE_0003("TEMPLATE_API-0003");

    private final String code;
}
