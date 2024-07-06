import java.util.ArrayList;

public class Bid {
    double totalPrice;
    User user;
    static ArrayList<Bid> bids = new ArrayList<>();

    Bid (User user, double totalPrice) {
        this.user = user;
        this.totalPrice = totalPrice;
        bids.add(this);
    }

    public static void showBids() {
        int i = 1;
        for (Bid bid : Bid.bids) {
            System.out.println(i + ".Username: " + bid.user.username + "\tTotal price : " + bid.totalPrice);
            i++;
        }
    }
}
