package org.pro.optis.backend.bo;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "historic")
public class Historic {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_p_action")
    @OneToOne(cascade = CascadeType.ALL)
    private Action action;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private User user;

    private Instant date;

}
