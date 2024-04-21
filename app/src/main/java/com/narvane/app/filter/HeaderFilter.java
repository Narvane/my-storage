package com.narvane.app.filter;

import com.narvane.infra.CurrentUserAuditor;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class HeaderFilter extends GenericFilterBean {

    private final CurrentUserAuditor currentUserAuditor;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        String login = httpRequest.getHeader("login");

        currentUserAuditor.setCurrentAuditor(login);

        filterChain.doFilter(request, response);
    }

}
