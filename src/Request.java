import java.util.ArrayList;

public class Request {
    Seller seller;
    User user;
    double fund;
    static ArrayList<Request> fundRequests = new ArrayList<>();
    static ArrayList<Request> sellerRequest = new ArrayList<>();

    Request (User user, double fund) {
        this.user = user;
        this.fund = fund;
        fundRequests.add(this);
    }
    Request(Seller seller) {
        this.seller = seller;
        sellerRequest.add(this);
    }

    public static void fundRequest() {
        int i = 1;
        for (Request request : fundRequests) {
            System.out.println(i + ".Username: " + request.user.username + "\tFund request : " + request.fund +"$");
            i++;
        }
    }

    public static void sellerRequest() {
        int i = 1;
        for (Request request : sellerRequest) {
            System.out.println(i + ".Seller's company name: " + request.seller.getCompanyName());
            i++;
        }
    }
}
