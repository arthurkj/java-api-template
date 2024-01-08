package br.com.akj.template.helper;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import br.com.akj.template.errors.Error;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MessageHelper {

    private final MessageSource messageSource;

    private MessageSourceAccessor accessor;

    @PostConstruct
    public void init() {
        accessor = new MessageSourceAccessor(messageSource, Locale.getDefault());
    }

    public String get(final String code, final Object... args) {
        return accessor.getMessage(code, args);
    }

    public String get(final Error code, final Object... args) {
        return accessor.getMessage(code.getMessageKey(), args);
    }
}
