package net.sf.gazpachosurvey.jpa;

import javax.persistence.PrePersist;

public class AuditingEntityListener {
    
    @PrePersist
    public void touchForCreate(Object target) {
        System.out.println("antes de crear");
    }
}
