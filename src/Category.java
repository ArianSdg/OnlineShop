import java.util.ArrayList;

public class Category {
    String name;
    Category category;
    ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Category> categories = new ArrayList<>();

    Category (String name) {
        this.name = name;
        this.category = this;
        Category.categories.add(this);
    }
    Category () {}

    public static Category findCategory(String name) {
        for (Category category : categories) {
            if (category.name.equals(name)) {
                return new Category(name);
            }
        }
        return null;
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
