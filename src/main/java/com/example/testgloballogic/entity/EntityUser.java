package com.example.testgloballogic.entity;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;


@Entity
@Table(name="userglobal")
public class EntityUser implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "user_id", updatable = false, nullable = false)
    private UUID id;
    @Column(name="name",unique = true)
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="password", unique = true)
    private String password;
    @Column(name="creado")
    private java.sql.Timestamp creado;
    @Column(name="modificado")
    private java.sql.Timestamp modificado;
    @Column(name="last_login")
    private java.sql.Timestamp last_login;
    @Column(name="active")
    private boolean active;
    @Column(name="token")
    private String token;



    public EntityUser() {

    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public java.sql.Timestamp getCreado() {
        return creado;
    }

    public void setCreado(java.sql.Timestamp creado) {
        this.creado = creado;
    }

    public java.sql.Timestamp getModificado() {
        return modificado;
    }

    public void setModificado(java.sql.Timestamp modificado) {
        this.modificado = modificado;
    }

    public java.sql.Timestamp getLast_login() {
        return last_login;
    }

    public void setLast_login(java.sql.Timestamp last_login) {
        this.last_login = last_login;
    }

    @OneToMany(mappedBy="entityUser", cascade=CascadeType.PERSIST)
    private List<EntityPhone> phones;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<EntityPhone> getPhones() {
        return phones;
    }

    public void setPhones(List<EntityPhone> phones) {
        this.phones = phones;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityUser that = (EntityUser) o;
        return active == that.active &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(creado, that.creado) &&
                Objects.equals(modificado, that.modificado) &&
                Objects.equals(last_login, that.last_login) &&
                Objects.equals(token, that.token) &&
                Objects.equals(phones, that.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, password, creado, modificado, last_login, active, token, phones);
    }

    @Override
    public String toString() {
        return "EntityUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", creado=" + creado +
                ", modificado=" + modificado +
                ", last_login=" + last_login +
                ", active=" + active +
                ", token='" + token + '\'' +
                ", phones=" + phones +
                '}';
    }

    public UUID getId() {
        return id;
    }
}
