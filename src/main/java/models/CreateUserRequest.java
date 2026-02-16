package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.jackson.Jacksonized;

@Data                          // Generates Getters, Setters, toString, equals, and hashCode
@Builder                       // Enables User.builder().username("5555").build()
@Jacksonized                   // Links Jackson deserialization with the Builder
@NoArgsConstructor             // Required by Jackson for creating the object
@AllArgsConstructor            // Required by the Builder pattern
@JsonIgnoreProperties(ignoreUnknown = true) // Prevents crashes if the API adds new fields later
public class CreateUserRequest {



    @JsonProperty("id")
    private String id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("userStatus")
    private String userStatus;
}