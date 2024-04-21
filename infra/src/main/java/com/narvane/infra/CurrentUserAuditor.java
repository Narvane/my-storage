package com.narvane.infra;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CurrentUserAuditor implements AuditorAware<String> {

    private String currentAuditor;

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.ofNullable(currentAuditor);
    }

    public void setCurrentAuditor(String currentAuditor) {
        this.currentAuditor = currentAuditor;
    }
}
