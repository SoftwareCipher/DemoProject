package com.demo.project.Stream.JavaProStream;

import java.util.Objects;

public class UserDB {
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String city;
    private String country;
    private int birthdayYear;

    public UserDB() {
    }

    public UserDB(String username, String firstName, String lastName, String password,
                  String email, String city, String country, int birthdayYear) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.city = city;
        this.country = country;
        this.birthdayYear = birthdayYear;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getBirthdayYear() {
        return birthdayYear;
    }

    public void setBirthdayYear(int birthdayYear) {
        this.birthdayYear = birthdayYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDB userDB = (UserDB) o;

        if (!Objects.equals(username, userDB.username)) return false;
        if (!Objects.equals(firstName, userDB.firstName)) return false;
        if (!Objects.equals(lastName, userDB.lastName)) return false;
        if (!Objects.equals(password, userDB.password)) return false;
        if (!Objects.equals(email, userDB.email)) return false;
        if (!Objects.equals(city, userDB.city)) return false;
        if (!Objects.equals(country, userDB.country)) return false;
        return Objects.equals(birthdayYear, userDB.birthdayYear);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + birthdayYear;
        return result;
    }

    @Override
    public String toString() {
        return "UserDB{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", birthdayYear=" + birthdayYear +
                '}';
    }
}
