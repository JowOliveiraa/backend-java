package io.example.authapi.models.enums;

public enum USerRole {

    ADMIN("admin"),
    USER("user");

    private String role;
    USerRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
