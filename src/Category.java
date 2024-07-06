import java.util.ArrayList;

public class Category {
    String name;
    ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Category> categories = new ArrayList<>();

    Category (String name) {
        this.name = name;
        Category.categories.add(this);
    }

    public static Category findCategory(String name) {
        for (Category category : categories) {
            if (category.name.equals(name)) {
                return new Category(name);
            }
        }
        return null;
    }
}
