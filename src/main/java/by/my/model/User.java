package by.my.model;

import java.util.Objects;

public class User {
    private String name;
    private String login;
    private String password;
    private int id;

    public User(){}

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(login, user.login) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, login, password);
    }

    @Override
    public String toString() {
        return "User{" +
                " +id=" + id+ '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ",name='" + name+
                "}";
    }
}

