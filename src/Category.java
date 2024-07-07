import java.util.ArrayList;

public class Category {
    String name;
    Category category;
    ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Category> categories = new ArrayList<>();

    Category(String name) {
        this.name = name;
        this.category = this;
        if (categories.size() < 5) {
            Category.categories.add(this);
        }
    }

    public static void showCategory() {
        int i = 1;
        System.out.println("Categories: ");
        for (Category category : categories) {
            System.out.print(i + "." + category.name +" \t");
            i++;
        }
    }

}
