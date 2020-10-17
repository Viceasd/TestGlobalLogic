package com.example.testgloballogic.entity;


import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name="userglobal")
public class EntityUser implements Serializable {


    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_id")
    private long userId;
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

    public EntityUser(long userId, String name, String email, String password, Timestamp creado, Timestamp modificado, Timestamp last_login, boolean active, String token, List<EntityPhone> phones) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.password = password;
        this.creado = creado;
        this.modificado = modificado;
        this.last_login = last_login;
        this.active = active;
        this.token = token;
        this.phones = phones;
    }

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

    public long getUserId() {
        return userId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntityUser that = (EntityUser) o;
        return userId == that.userId &&
                active == that.active &&
                name.equals(that.name) &&
                email.equals(that.email) &&
                Objects.equals(password, that.password) &&
                Objects.equals(creado, that.creado) &&
                Objects.equals(modificado, that.modificado) &&
                Objects.equals(last_login, that.last_login) &&
                Objects.equals(token, that.token) &&
                phones.equals(that.phones);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, email, password, creado, modificado, last_login, active, token, phones);
    }

    @Override
    public String toString() {
        return "EntityUser{" +
                "userId=" + userId +
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
}
