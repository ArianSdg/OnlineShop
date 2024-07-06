import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    public String name;
    double price;
    double amount;
    ArrayList<String> comments = new ArrayList<>();
    String itemData;
    Category category;

    Product(String name, double price, double amount, String itemData, Category category) {
        this.name = name;
        this.price = price;
        this.amount = amount;
        this.itemData = itemData;
        this.category = category;
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
}
