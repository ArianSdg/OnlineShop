import java.util.ArrayList;

public class Shop {
    String shopName;
    String address;
    String shopNumber;

    static ArrayList<Account> accountList = new ArrayList<>();
    static ArrayList<String> productList; // changeable
    static ArrayList<String> ordersList; // changeable
    private double profit;

    Shop (String shopName, String address, String shopNumber) { // constructor for shop
        this.shopName = shopName;
        this.shopNumber = shopNumber;
        this.address = address;


    }
}
