import java.util.ArrayList;

public class User extends Account {
    ArrayList<Product> shoppingCart;
    ArrayList<Product> orderList;
    ArrayList<Product> boughtList;
    private double wallet;
    String username;
    private String password;
    private String emailAddress;
    private String phoneNumber;
    private String address;
    Roles role;


    User(String username, String password, String emailAddress, String phoneNumber, String address) {
        super(username,password,emailAddress,phoneNumber,address,Roles.USER);
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.role = Roles.USER;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }


    public double getWallet() {
        return wallet;
    }
    public void setWallet(double wallet) {
        this.wallet = wallet;
    }

}
