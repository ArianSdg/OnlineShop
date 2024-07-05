import java.util.ArrayList;

public class Seller extends Account {
    private String companyName;
    private String password;
    private ArrayList<Product> products;

    Seller(String companyName, String password) {
        this.companyName = companyName;
        this.password = password;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }


    public void addProduct(Product product) {
        products.add(product);
    }
    public void removeProduct(Product product) {
        products.remove(product);
    }
}
