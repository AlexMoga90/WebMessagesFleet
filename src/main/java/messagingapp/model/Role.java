package messagingapp.model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public enum Role {
        DISPATCHER,
        DRIVER;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
