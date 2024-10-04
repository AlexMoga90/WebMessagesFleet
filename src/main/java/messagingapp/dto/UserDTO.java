package messagingapp.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import messagingapp.model.Role;

public class UserDTO {

    @NotBlank
    @Pattern(regexp = "^\\+?[0-9]{10,13}$", message = "Invalid phone number")
    private String phoneNumber;

    @NotBlank
    @Size(min = 5, message = "Password must be at least 5 characters long")
    private String password;

    private Role role;

    // Constructors
    public UserDTO() {}

    public UserDTO(String phoneNumber, String password, Role role) {
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
    }

    // Getters and Setters
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }
}

