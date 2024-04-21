package com.narvane.infra.entity;

import com.narvane.infra.CurrentUserAuditor;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class EntityListener {

    private CurrentUserAuditor currentUserAuditor;

    @PrePersist
    public void prePersist(Object entity) {
        if (entity instanceof AbstractEntity<?> baseEntity) {
            var currentUserLogin = currentUserAuditor.getCurrentAuditor();
            if (currentUserLogin.isPresent()) {
                baseEntity.setUserLogin(currentUserLogin.get());
            } else {
                baseEntity.setUserLogin("userAdmin");
            }
        }
    }

    @PreUpdate
    public void preUpdate(Object entity) {
        if (entity instanceof AbstractEntity<?> baseEntity) {
            var currentUserLogin = currentUserAuditor.getCurrentAuditor();
            if (currentUserLogin.isPresent()) {
                baseEntity.setUserLogin(currentUserLogin.get());
            } else {
                baseEntity.setUserLogin("userAdmin");
            }
        }
    }

}
