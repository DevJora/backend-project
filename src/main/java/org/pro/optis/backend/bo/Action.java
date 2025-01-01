package org.pro.optis.backend.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "action")
public class Action {
    @Id
    @Column
    private String type;
}
