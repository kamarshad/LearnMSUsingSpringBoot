package com.KSTech.learnmicroserviceswithspringboot;

import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class LocalizationViewController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping ("/hello-world/internationalization")
    //@RequestHeader(value = "Accept-Language", required = false) Locale locale
    // Instead of putting the locale and accessing it from request header is quite redundant work.
    // Instead of that we can access it from LocaleContxtHolder as mentioned below
    public String helloWorld() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }
}
