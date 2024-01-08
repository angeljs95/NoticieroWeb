package com.elobservador.noticiero.entidades;

import com.elobservador.noticiero.enumerations.Role;
import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Usuarios")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    protected String id;

    protected String name;
    protected Integer document;

    protected Integer age;
    protected String email;
    protected String password;
    protected String nickName;

    protected String address;
    @Enumerated(EnumType.STRING)
    protected Role role;

    protected boolean active;

    @OneToOne
    protected Imagen photo;


    //-------------------------Empiezan constructores, getters and setters ---------------------

    public Usuario(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Imagen getPhoto() {
        return photo;
    }

    public void setPhoto(Imagen photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", document=" + document +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", nickName='" + nickName + '\'' +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", active=" + active +
                ", photo=" + photo +
                '}';
    }
}
