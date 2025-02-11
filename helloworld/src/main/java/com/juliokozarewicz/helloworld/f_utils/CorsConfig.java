package com.juliokozarewicz.helloworld.f_utils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.*;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    // locale
    private final MessageSource messageSource;
    public CorsConfig(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    // Allowed IPs
    @Value("${ALLOWED_DOMAINS}")
    private String allowedDomains;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HandlerInterceptor() {
            @Override
            public boolean preHandle(
                HttpServletRequest request,
                HttpServletResponse response,
                Object handler
            ) throws Exception {

                // language
                Locale locale = LocaleContextHolder.getLocale();

                String ipRemote = request.getRemoteAddr();

                List<String> allowedDomainsList = Arrays.asList(
                    allowedDomains.split(",\\s*")
                );

                if (!allowedDomains.contains(ipRemote)) {
                    Map<String, Object> errorDetails = new LinkedHashMap<>();
                    errorDetails.put("errorCode", 400);
                    errorDetails.put(
                        "message",
                        messageSource.getMessage(
                                "unauthorized_access", null, locale
                        )
                    );
                    throw new RuntimeException(errorDetails.toString());
                }

                return true;
            }
        }).addPathPatterns("/**");
    }
}
