package com.epam.transporter.entity;

public class Customer extends User {
    private boolean logged;

    public String getPassword() {
        return super.getPassword();
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setPassword(String password) {
        super.setPassword(password);
    }
}
