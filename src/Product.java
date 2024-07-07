import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Product extends Category {
    public String name;
    double price;
    double amount;
    ArrayList<String> comments = new ArrayList<>();
    String itemData;
    Seller seller;

    Product(String name, double price, double amount, String itemData, Seller seller) {
        super();
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.itemData = itemData;
        this.seller = seller;
        Shop.productList.add(this);
    }

//    public static void searchProduct(String searchInput) {
//        if (searchInput.equals())
//    }



    public void showProduct() {
        System.out.println("Product Name: " + name);
        System.out.println("Price: " + "$" + price);
        System.out.println("Amount: " + amount);
        System.out.println("Comments: " + comments);
        System.out.println("Category: " + category.name);
    }

    public void showComments() {
        for (String s : comments) {
            System.out.println(s);
        }
    }

    public void addComment(String s) {
        this.comments.add(s);
    }
}
