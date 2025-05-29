package br.com.fiap.wefood.domain.address;

import br.com.fiap.wefood.domain.user.User;
import java.util.UUID;

public class Address {
    private UUID id;
    private String city;
    private String state;
    private User user;

    public Address() {
    }

    public Address(UUID id, String city, String state, User user) {
        this.id = id;
        this.city = city;
        this.state = state;
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}