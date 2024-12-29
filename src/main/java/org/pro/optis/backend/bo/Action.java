package org.pro.optis.backend.bo;

import jakarta.persistence.*;

@Entity
@Table(name = "action")
public class Action {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String type;
}
