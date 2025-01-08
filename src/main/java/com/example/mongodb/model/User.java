package com.example.mongodb.model;

import jakarta.validation.constraints.*;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
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
}