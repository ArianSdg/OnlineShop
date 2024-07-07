public class Admin extends Account {
    String username;
    private String password;
    private String emailAddress;
    Roles role;

    Admin (String username, String password, String emailAddress) {
        super(username,password,emailAddress,Roles.ADMIN);
        this.username = username;
        this.password = password;
        this.emailAddress = emailAddress;
        this.role = Roles.ADMIN;
        Shop.accountList.add(this);
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
    public String getEmailAddress() {
        return emailAddress;
    }


    public void acceptFundRequest(Request request) {
        request.user.wallet += request.fund;
    }
    public void acceptSellerRequest(Request request) {
        request.seller.sellerRequest = true;
    }

    public boolean acceptBid(Bid bid) {
        for (Product product : bid.user.shoppingCart.keySet()) {
            if (product.amount >= bid.user.shoppingCart.get(product)) {
                product.amount -= bid.user.shoppingCart.get(product);
            } else {
                System.out.println("Not enough product exists in the shop!");
                return false;
            }
        }
        bid.user.wallet -= bid.totalPrice;
        // extra exercise
        for (Product product : bid.user.shoppingCart.keySet()) {
            product.seller.wallet += bid.user.shoppingCart.get(product) * product.price * 0.9;
            Shop.profit += bid.user.shoppingCart.get(product) * product.price * 0.1;
        }
        bid.user.boughtList.putAll(bid.user.shoppingCart);
        bid.user.shoppingCart.clear();
        return true;
    }
}
