package com.example.mongodb.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Setter
@Getter

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "User")
public class User {

    @Id
    private ObjectId id;

    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String password;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$", message = "Phone number is invalid")
    private String phoneNumber;

    @Past
    private Date dateOfBirth;

    @NotBlank
    private String address;

    @NotBlank
    private String role;

    @NotEmpty
    private List<String> permissions;

    private boolean isActive;

    /**
     * Returns a string representation of the User object.
     *
     * @return a string representation of the User object, including all its fields
     */
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                ", permissions=" + permissions +
                ", isActive=" + isActive +
                '}';
    }
}