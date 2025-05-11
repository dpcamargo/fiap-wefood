package br.com.fiap.wefood.domain.model;

public enum Role {
    ADMIN,
    RESTAURANT_OWNER,
    CUSTOMER;

    public String toAuthority() {
        return "ROLE_" + this.name();
    }
}
