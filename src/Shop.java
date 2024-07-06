import java.util.ArrayList;

public class Shop {
    String shopName;
    String address;
    String shopNumber;

    static ArrayList<Account> accountList = new ArrayList<>();
    static ArrayList<Product> productList = new ArrayList<>(); // changeable
    static ArrayList<String> ordersList = new ArrayList<>(); // changeable
    private static double profit;

    Shop (String shopName, String address, String shopNumber) { // constructor for shop
        this.shopName = shopName;
        this.shopNumber = shopNumber;
        this.address = address;
    }

    public static Account searchAccount(String username) {
        for (Account acc : accountList) {
            if (username.equals(acc.username)) {
                return acc;
            }
        }
        return null;
    }
    public static Product searchProduct(String searchedProduct) {
        for (Product product : productList) {
            if (product.name.equals(searchedProduct)) {
                return product;
            }
        }
        return null;
    }
}
