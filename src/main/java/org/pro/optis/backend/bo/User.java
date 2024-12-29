package org.pro.optis.backend.bo;


import jakarta.persistence.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "member")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Instant date_created;
    private Instant date_updated;
    private Boolean active = false;
    private String type;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_role")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_company")
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private List<Historic> historics = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Instant getDate_created() {
        return date_created;
    }

    public void setDate_created(Instant date_created) {
        this.date_created = date_created;
    }

    public Instant getDate_updated() {
        return date_updated;
    }

    public void setDate_updated(Instant date_updated) {
        this.date_updated = date_updated;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Historic> getHistorics() {
        return historics;
    }

    public void setHistorics(List<Historic> historics) {
        this.historics = historics;
    }
}
