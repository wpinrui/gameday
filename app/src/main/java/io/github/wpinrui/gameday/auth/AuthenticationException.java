package io.github.wpinrui.gameday.auth;

public class AuthenticationException extends RuntimeException {
    private final AuthenticationFailureType type;

    public AuthenticationException(AuthenticationFailureType type) {
        this.type = type;
    }

    public AuthenticationFailureType getType() {
        return type;
    }
}
