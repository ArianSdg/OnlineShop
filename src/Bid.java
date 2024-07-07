import java.util.ArrayList;

public class Bid {
    double totalPrice;
    User user;

    Bid (User user, double totalPrice) {
        this.user = user;
        this.totalPrice = totalPrice;
        Shop.bidsList.add(this);
    }

    public static void showBids() {
        int i = 1;
        for (Bid bid : Shop.bidsList) {
            System.out.println(i + ".Username: " + bid.user.username + "\tTotal price : " + bid.totalPrice);
            i++;
        }
    }
}
