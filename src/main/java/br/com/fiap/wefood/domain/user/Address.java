package br.com.fiap.wefood.domain.user;

import java.util.UUID;

public class Address {
    private UUID id;
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;

    public Address() {
    }

    public Address(UUID id, String street, String number, String complement, String city, String state) {
        this.id = id == null ? UUID.randomUUID() : id;
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
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
}