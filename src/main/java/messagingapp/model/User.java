package messagingapp.model;

import javax.persistence.Id;

public class User {
    @Id
    private String phoneNumber;
    private String password;
    private boolean isDispacher;

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

    public boolean isDispacher() {
        return isDispacher;
    }

    public void setDispacher(boolean dispacher) {
        isDispacher = dispacher;
    }
}
