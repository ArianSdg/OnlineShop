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
}
