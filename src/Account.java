public class Account {
    String username;
    private String companyName;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    Roles role;


    Account(String username, String password, String emailAddress, String phoneNumber, String address,Roles role) { // constructor for User
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = role;
    }
    Account(String companyName, String password,Roles role) { // constructor for Seller
        this.companyName = companyName;
        this.password = password;
        this.role = role;
    }
    Account(String username, String password, String emailAddress,Roles role) { // constructor for Admin
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.role = role;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
