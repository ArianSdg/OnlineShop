import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class User extends Account {
    HashMap<Product, Integer> shoppingCart = new HashMap<>(); // the integer/value is the amount of product
    ArrayList<Bid> userBidList = new ArrayList<>();
    HashMap<Product, Integer> boughtList = new HashMap<>();
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
        Shop.accountList.add(this);
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

    public void addToShoppingCart(Product product, int amount) {
        if (this.shoppingCart.containsKey(product)) {
            this.shoppingCart.put(product, this.shoppingCart.get(product) + amount);

        } else {
            this.shoppingCart.put(product, amount);
        }
    }

    public void removeFromShoppingCart(Product product, int amount) {
        if (this.shoppingCart.get(product) > amount) {
            this.shoppingCart.put(product, this.shoppingCart.get(product) - amount);
        } else {
            this.shoppingCart.remove(product);
        }
    }
}
