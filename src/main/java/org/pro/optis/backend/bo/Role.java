package org.pro.optis.backend.bo;

import jakarta.persistence.*;
import lombok.Setter;
import lombok.Getter;
import org.pro.optis.backend.TypeRole;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TypeRole role;

    private String description;

    public Long getId() {
        return id;
    }


    public TypeRole getRole() {
        return role;
    }

    public void setRole(TypeRole role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}


