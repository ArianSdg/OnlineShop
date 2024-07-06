import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

    public static void register(String username, String password, String emailAddress, String phoneNumber, String address) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Username: ");
        username = scan.next();
        System.out.print("Password: ");
        password = scan.next();
        System.out.print("Email: ");
        emailAddress = scan.next();
        System.out.print("Phone number: ");
        phoneNumber = scan.next();
        System.out.print("Address: ");
        address = scan.next();

        new User(username, password, emailAddress, phoneNumber, address);
    }

    public static void register(String username, String password, String emailAddress) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Username: ");
        username = scan.next();
        System.out.print("Password: ");
        password = scan.next();
        System.out.print("Email: ");
        emailAddress = scan.next();


        new Admin(username, password, emailAddress);
    }

    public static void register(String companyName, String password) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Company name: ");
        companyName = scan.next();
        System.out.print("Password: ");
        password = scan.next();

        new Seller(companyName,password);
    }

    public static Account myAcc;

    public static <i> void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Shop shop1 = new Shop("ArianKala", "www.ariankala.com", "09906431994");
        Shop shop2 = new Shop("ZohaKala", "www.zohakala.com", "09906431995");
        System.out.println("Enter your desired website Address.");

        // first admin of online shop
        Account firstAdmin = new Account("Arian", "12345", "Arian@gmail.com", Roles.ADMIN);
        Shop.accountList.add(firstAdmin);


        while (true) {
            String address = scan.next();
            if (!address.equals(shop1.address)) {
                System.out.println("Invalid Address!");
            } else {
                System.out.println("== Register ==");

                String username = "";
                String password = "";
                String emailAddress = "";
                String phoneNumber = "";
                String userAddress = "";




                int enter;
                while (myAcc == null) {
                    String role;
                    do {
                        System.out.println("Choose your role: \n{ USER } \n{ SELLER }\n{ ADMIN }");
                        role = scan.next();
                        System.out.println("Type 1 to register and type 2 to login!"); // asking whether you have an account or not
                        enter = scan.nextInt();
                        if (enter == 1) { // registering process
                            if (role.equals(Roles.USER.toString())) { // your role as a User
                                register(username, password, emailAddress, phoneNumber, userAddress); // registration


                            } else if (role.equals(Roles.SELLER.toString())) { // your role as a seller
                                register(username, password);


                            } else if (role.equals(Roles.ADMIN.toString())) { // your role as an admin
                                register(username, password, emailAddress);

                            }
                        }
                    } while (enter == 1);
                    if (enter == 2) { // login process
                        String loginUsername;
                        String loginCompanyName;
                        String loginPassword;
                        if (role.equals(Roles.USER.toString())) { // login as a User
                            do {
                                System.out.println("== Login ==");
                                System.out.print("Username: ");
                                loginUsername = scan.next();
                                System.out.print("Password: ");
                                loginPassword = scan.next();
                                myAcc = AccountManagement.login(loginUsername, loginPassword, Shop.accountList);
                            } while (!loginUsername.equals(myAcc.username) || !loginPassword.equals(myAcc.getPassword()));
                        } else if (role.equals(Roles.SELLER.toString())) {
                            do {
                                System.out.println("== Login ==");
                                System.out.print("Company name: ");
                                loginCompanyName = scan.next();
                                System.out.print("Password: ");
                                loginPassword = scan.next();
                                myAcc = AccountManagement.login(loginCompanyName, loginPassword, Shop.accountList);
                            } while (!loginCompanyName.equals(myAcc.username) || !loginPassword.equals(myAcc.getPassword()));
                        } else if (role.equals(Roles.ADMIN.toString())) {
                            System.out.println("== Login ==");
                            do { // user's login
                                System.out.print("Username: ");
                                loginUsername = scan.next();
                                System.out.print("Password: ");
                                loginPassword = scan.next();
                                if (firstAdmin.username.equals(loginUsername) && firstAdmin.getPassword().equals(loginPassword)) {
                                    myAcc = firstAdmin;
                                }
                                myAcc = AccountManagement.login(loginUsername, loginPassword, Shop.accountList);
                            } while (!loginUsername.equals(myAcc.username) || !loginPassword.equals(myAcc.getPassword()));
                        } else {
                            System.out.println("No " + role + " exist!");
                        }
                    }

                    // default categories for the shop
                    Category book = new Category("Book");
                    Category computer = new Category("Computer");
                    Category console = new Category("Console");
                    Category kitchen = new Category("Kitchen");
                    Category headphone = new Category("Headphone");

                    AccountManagement accountEditing = new AccountManagement();
                    while (myAcc instanceof User) {
                        System.out.println("Welcome " + myAcc.username + ".");


                        // getting the menu of the shop


                        System.out.println("Select a page of your choice! \n1.Edit Profile\n2.Request funds\n3.Show products\n4.Search a product\n5.Shopping Cart\n6.Logout");
                        int choice = scan.nextInt();
                        String finishChanging;
                        switch (choice) {
                            case 1: // selecting profile editing
                                do {
                                    System.out.println("1.Change username.\n2.Change password.\n3.Change email address.\n4.Change Phone number.\n5.Change address.");
                                    int changeChoice = scan.nextInt();

                                    switch (changeChoice) {
                                        case 1:
                                            System.out.print("Enter new username: ");
                                            String newUsername = scan.next();
                                            accountEditing.editUsername(newUsername, myAcc);
                                            break;
                                        case 2:
                                            System.out.print("Enter new password: ");
                                            String newPassword = scan.next();
                                            accountEditing.editPassword(newPassword, myAcc);
                                            break;
                                        case 3:
                                            System.out.print("Enter new email address: ");
                                            String newEmailAddress = scan.next();
                                            accountEditing.editEmail(newEmailAddress, myAcc);
                                            break;
                                        case 4:
                                            System.out.println("Enter new phone number: ");
                                            String newPhoneNumber = scan.next();
                                            accountEditing.editPhoneNumber(newPhoneNumber, myAcc);
                                            break;
                                        case 5:
                                            System.out.println("Enter new address: ");
                                            String newAddress = scan.next();
                                            accountEditing.editAddress(newAddress, myAcc);
                                            break;
                                        default:
                                            System.out.println("Failed to change your info!");
                                    }
                                    System.out.println("If you no longer want to change your info type \"finish\"");
                                    finishChanging = scan.next();

                                } while (!finishChanging.equals("finish")); // finishing the editing of profile
                                break;
                            case 2 :
                                System.out.print("Type the amount you want to request: ");
                                double requestForFund = scan.nextDouble();
                                new Request(((User)myAcc), requestForFund);
                                break;
                            case 3 :
                                int i = 1;
                                System.out.println("Categories:");
                                for (Category category : Category.categories) {
                                    System.out.print((i) + category.name + "\t");
                                    i++;
                                }

                                System.out.print("Select category: ");
                                int myChoice = scan.nextInt();

                                i = 1;
                                System.out.println("Products: ");
                                for (Product product : Category.categories.get(myChoice - 1).products) {
                                    System.out.print((i) + product.name + "\t");
                                }
                                int myChoice2 = scan.nextInt();
                                Category.categories.get(myChoice - 1).products.get(myChoice2 - 1).showProduct();
                                Category.categories.get(myChoice - 1).products.get(myChoice2 - 1).showComments();

                                System.out.println("1.Buy\n2.Back");
                                int myChoice3 = scan.nextInt();
                                if (myChoice3 == 1) {
                                    ((User)myAcc).addToShoppingCart(Category.categories.get(myChoice - 1).products.get(myChoice2 - 1));
                                }
                                if (myChoice3 == 2) {
                                    // BACK
                                }
                                break;
                            case 4 :
                                System.out.print("Enter the product name you want: ");
                                String search = scan.next();
                                Product searchedProduct = Shop.searchProduct(search);
                                searchedProduct.showProduct();
                                searchedProduct.showComments();

                                System.out.println("1.Buy \t2.Back");
                                myChoice = scan.nextInt();
                                if (myChoice == 1) {
                                    ((User)myAcc).addToShoppingCart(searchedProduct);
                                }
                                if (myChoice == 2) {
                                    // BACK
                                }
                                break;
                            case 5 :
                                i = 0;
                                int totalPrice = 0;
                                for (Product product : ((User)myAcc).shoppingCart.keySet()) {
                                    System.out.println(i + "." + product.name + "\tAmount: "+ ((User)myAcc).shoppingCart.get(product));
                                    totalPrice += ((User)myAcc).shoppingCart.get(product) * product.price;
                                    i += 1;
                                }
                                System.out.println("Total price is " + totalPrice);

                                System.out.println("1.Buy \t2.Back");
                                myChoice = scan.nextInt();
                                if (myChoice == 1) {
                                    // buy all shopping cart
                                }
                                if (myChoice == 2) {
                                    // back
                                }
                                break;
                            case 6 :
                                myAcc = null;
                                break;
                        }


                    } while (myAcc instanceof Seller) {

                        new Request((Seller)myAcc);

                        System.out.println("Welcome, Mr.Seller in " + myAcc.getCompanyName()+" company!");

                        System.out.println("Select a page of your choice! \n1.Edit profile\n2.Add and Remove products\n3.Logout");
                        int choice = scan.nextInt();
                        switch (choice) {
                            case 1 :
                                System.out.println("Which one do you want to change? 1.Company name 2.Password");
                                enter = scan.nextInt();
                                switch (enter) {
                                    case 1:
                                        System.out.print("Enter new Company name: ");
                                        String newCompanyName = scan.next();
                                        accountEditing.editCompanyName(newCompanyName, myAcc);
                                        break;
                                    case 2:
                                        System.out.println("Enter new password: ");
                                        String newPassword = scan.next();
                                        accountEditing.editPassword(newPassword, myAcc);
                                        break;
                                }
                            case 2 :
                                System.out.print("Search your desired category: ");
                                String category = scan.next();

                                System.out.println("Add your product.");
                                System.out.print("1.Product name: ");
                                String productName = scan.next();
                                System.out.print("2.Product price: ");
                                double productPrice = scan.nextDouble();
                                System.out.print("3.Product amount: ");
                                double productAmount = scan.nextDouble();
                                System.out.print("4.Product info: ");
                                String productInfo = scan.next();

                                Product newProduct = new Product(productName, productPrice, productAmount, productInfo, Category.findCategory(category));
                                ((Seller)myAcc).products.add(newProduct);
                                break;
                            case 3 :
                                myAcc = null;
                                break;
                        }


                    } while (myAcc instanceof Admin) {
                        System.out.println("Welcome " + myAcc.username + ".");


                        System.out.println("Select a page of your choice! \n1.Edit Profile\n2.Seller's Request\n3.Fund requests from user\n4.Add fund to someone\n5.Promote to admin\n6.");
                        int choice = scan.nextInt();
                        String finishChanging;
                        switch (choice) {
                            case 1:
                                do {
                                    System.out.println("1.Change username.\n2.Change password.\n3.Change email address.\n4.Change Phone number.\n5.Change address.\n6.Logout");
                                    int changeChoice = scan.nextInt();
                                    switch (changeChoice) {
                                        case 1:
                                            System.out.print("Enter new username: ");
                                            String newUsername = scan.next();
                                            accountEditing.editUsername(newUsername, myAcc);
                                            break;
                                        case 2:
                                            System.out.print("Enter new password: ");
                                            String newPassword = scan.next();
                                            accountEditing.editPassword(newPassword, myAcc);
                                            break;
                                        case 3:
                                            System.out.print("Enter new email address: ");
                                            String newEmailAddress = scan.next();
                                            accountEditing.editEmail(newEmailAddress, myAcc);
                                            break;
                                    }
                                    System.out.println("If you no longer want to change your info type \"finish\"");
                                    finishChanging = scan.next();

                                } while (!finishChanging.equals("finish"));
                                break;
                            case 2 :
                                Request.sellerRequest();
                                int myChoice = scan.nextInt();
                                ((Admin)myAcc).acceptSellerRequest(Request.sellerRequest.get(myChoice - 1));
                                Request.sellerRequest.remove(myChoice - 1);
                                break;
                            case 3 :
                                Request.fundRequest();
                                System.out.println("Select the number of fund request of your choice: ");
                                myChoice = scan.nextInt();
                                ((Admin)myAcc).acceptFundRequest(Request.fundRequests.get(myChoice - 1));
                                Request.fundRequests.remove(myChoice - 1);
                                System.out.println("Fund request accepted!");
                                break;
                            case 4 :
                                System.out.print("Search the username you want: ");
                                String searchUsername = scan.next();
                                System.out.println("Type the amount of fund you want to add: ");
                                double addFund = scan.nextDouble();
                                Shop.searchAccount(searchUsername).wallet += addFund;
                                System.out.println("New balance: "+Shop.searchAccount(searchUsername).wallet);
                                break;
                            case 5 :
                                System.out.print("Search the username you want to promote: ");
                                searchUsername = scan.next();
                                Account newAdmin = Shop.searchAccount(searchUsername);
                                new Admin(newAdmin.username,newAdmin.getPassword(),newAdmin.getEmailAddress());
                                Shop.accountList.remove(newAdmin);
                                System.out.println(newAdmin.username+ " has promoted to Admin :D");
                                break;
                            case 6 :
                                myAcc = null;
                                break;
                        }

                    }
                }
            }
        }
    }
}