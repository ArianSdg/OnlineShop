import java.util.ArrayList;

public class Product {
    String name;
    double price;
    double balance;
    ArrayList<String> comments;
    String itemData;

    Product(String name, double price, double balance, ArrayList<String> comments, String itemData) {
        this.name = name;
        this.price = price;
        this.balance = balance;
        this.comments = comments;
        this.itemData = itemData;
    }
}
