package br.com.fiap.wefood.domain.user;

public enum Role {
    ADMIN,
    RESTAURANT_OWNER,
    CUSTOMER;

    public String toAuthority() {
        return "ROLE_" + this.name();
    }
}
