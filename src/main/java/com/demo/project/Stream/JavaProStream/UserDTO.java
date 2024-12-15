package com.demo.project.Stream.JavaProStream;

import java.util.Objects;

public class UserDTO {
    private String username;
    private String firstName;
    private String lastName;
    private String city;
    private String country;
    private int birthdayYear;

    public UserDTO() {
    }

    public UserDTO(String username, String firstName, String lastName,
                   String city, String country, int birthdayYear) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
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

        UserDTO userDTO = (UserDTO) o;

        if (!Objects.equals(username, userDTO.username)) return false;
        if (!Objects.equals(firstName, userDTO.firstName)) return false;
        if (!Objects.equals(lastName, userDTO.lastName)) return false;
        if (!Objects.equals(city, userDTO.city)) return false;
        if (!Objects.equals(country, userDTO.country)) return false;
        return Objects.equals(birthdayYear, userDTO.birthdayYear);
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + birthdayYear;
        return result;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", birthdayYear=" + birthdayYear +
                '}';
    }
}
