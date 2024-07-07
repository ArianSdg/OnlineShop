import java.util.ArrayList;
import java.util.HashMap;
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

        new Seller(companyName, password);
    }

    public static Account myAcc;

    public static <i> void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Shop shop1 = new Shop("ArianKala", "www.ariankala.com", "09906431994");
        Shop shop2 = new Shop("ZohaKala", "www.zohakala.com", "09906431995");
        System.out.println("Enter your desired website Address.");

        // first admin of online shop
        Admin firstAdmin = new Admin("Arian", "12345", "Arian@gmail.com");

        // default categories for the shop
        Category book = new Category("Book");
        Category computer = new Category("Computer");
        Category console = new Category("Console");
        Category kitchen = new Category("Kitchen");
        Category headphone = new Category("Headphone");



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
                                System.out.println("You cannot register as an Admin!");

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
                            } while (!loginCompanyName.equals(myAcc.getCompanyName()) || !loginPassword.equals(myAcc.getPassword()));


                        } else if (role.equals(Roles.ADMIN.toString())) {
                            do { // user's login
                                System.out.println("== Login ==");
                                System.out.print("Username: ");
                                loginUsername = scan.next();
                                System.out.print("Password: ");
                                loginPassword = scan.next();
                                myAcc = AccountManagement.login(loginUsername, loginPassword, Shop.accountList);
                            } while (!loginUsername.equals(myAcc.username) || !loginPassword.equals(myAcc.getPassword()));
                        } else {
                            System.out.println("No " + role + " exist!");
                        }
                    }



                    System.out.println("-----------------------");

                    AccountManagement accountEditing = new AccountManagement();
                    while (myAcc instanceof User) {
                        System.out.println("Welcome " + myAcc.username + ".");

                        System.out.println("Wallet : " + "$" + myAcc.wallet);

                        System.out.println("List of the items " + myAcc.username + " has bought: ");
                        int j = 1;
                        for (Product pr : ((User) myAcc).boughtList.keySet()) {
                            System.out.print(j + "." + pr.name + " \t");
                            j++;
                        }

                        System.out.println("-----------------------------");

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

                                            myAcc.log.add("User, " + myAcc.username + ", has edited his profile.");
                                    }
                                    System.out.println("If you no longer want to change your info type \"finish\"");
                                    finishChanging = scan.next();

                                } while (!finishChanging.equals("finish")); // finishing the editing of profile
                                break;
                            case 2: // add fund
                                System.out.print("Type the amount you want to request: ");
                                double requestForFund = scan.nextDouble();
                                new Request(((User) myAcc), requestForFund);

                                myAcc.log.add("User, " + myAcc.username + ", has requested to add " + requestForFund + " in their account.");
                                break;
                            case 3: // show products
                                Category.showCategory();

                                System.out.println("Select category: ");
                                int myCategoryChoice = scan.nextInt();

                                int i = 1;
                                System.out.println("Products: ");
                                for (Product product : Category.categories.get(myCategoryChoice - 1).products) {
                                    System.out.print((i) + "." + product.name + "\t");
                                    i++;
                                }
                                System.out.println();

                                System.out.print("Select the product you want: ");
                                int myProductChoice = scan.nextInt();

                                System.out.println(Category.categories.get(myCategoryChoice - 1).products.get(myProductChoice - 1).name + " information:");
                                Category.categories.get(myCategoryChoice - 1).products.get(myProductChoice - 1).showProduct();


                                System.out.println("If you want to see the comments about this product type 1\nIf you want to proceed, type another number!");
                                int seeComments = scan.nextInt();

                                if (seeComments == 1) {
                                    Category.categories.get(myCategoryChoice - 1).products.get(myProductChoice - 1).showComments();
                                } else {

                                    System.out.println("1.Add to shopping cart \t2.Add a comment \t3.Back");
                                    int myChoice3 = scan.nextInt();

                                    if (myChoice3 == 1) { // add to shopping cart
                                        System.out.print("Type how many product you want to add: ");
                                        int productAmount = scan.nextInt();
                                        ((User) myAcc).addToShoppingCart(Category.categories.get(myCategoryChoice - 1).products.get(myProductChoice - 1), productAmount);
                                        myAcc.log.add("User, " + myAcc.username + ", has added " + Category.categories.get(myCategoryChoice - 1).products.get(myProductChoice - 1).name + " to their Shopping Cart.");
                                    }
                                    if (myChoice3 == 2) { // add comment
                                        scan.nextLine();
                                        String comment = scan.nextLine();
                                        Category.categories.get(myCategoryChoice - 1).products.get(myProductChoice - 1).addComment(comment);
                                    }

                                    if (myChoice3 == 3) { // back to menu
                                        // BACK
                                        continue;
                                    }
                                }


                                break;
                            case 4: // search product
                                System.out.print("Enter the product name you want: ");
                                String search = scan.next();
                                Product searchedProduct = Shop.searchProduct(search);
                                searchedProduct.showProduct();
                                searchedProduct.showComments();

                                System.out.println("1.Add to shopping cart \t2.Add a comment \t3.Back");
                                int myChoice = scan.nextInt();
                                if (myChoice == 1) {
                                    System.out.print("Type how many product you want to add: ");
                                    int productAmount = scan.nextInt();
                                    ((User) myAcc).addToShoppingCart(searchedProduct, productAmount);
                                    myAcc.log.add("User, " + myAcc.username + ", has added " + searchedProduct.name + " to their Shopping Cart.");
                                }
                                if (myChoice == 2) {
                                    String comment = scan.next();
                                    searchedProduct.addComment(comment);
                                }
                                if (myChoice == 3) {
                                    // BACK
                                    continue;
                                }
                                break;
                            case 5: // shopping cart
                                i = 1;
                                int totalPrice = 0;
                                for (Product product : ((User) myAcc).shoppingCart.keySet()) {
                                    System.out.println(i + "." + product.name + "\tAmount: " + ((User) myAcc).shoppingCart.get(product));
                                    totalPrice += ((User) myAcc).shoppingCart.get(product) * product.price; // calculating total price (amount * price)
                                    i += 1;
                                }
                                System.out.println("Total price is " + totalPrice);

                                System.out.println("1.Buy \t2.Remove from Shopping Cart \t3.Back");
                                myChoice = scan.nextInt();
                                if (myChoice == 1) {
                                    if (myAcc.wallet > totalPrice) { // CHECKING IF YOU HAVE ENOUGH MONEY IN YOUR ACCOUNT
                                        ((User) myAcc).userBidList.add(new Bid((User) myAcc, totalPrice));
                                        myAcc.log.add("User, " + myAcc.username + ", has bought all of the products in the Shopping Cart.");
                                    } else {
                                        System.out.println("Not enough fund!");
                                    }
                                }
                                if (myChoice == 2) {
                                    System.out.print("Enter the name of product you want to remove: ");
                                    String searchProduct = scan.next();
                                    searchedProduct = Shop.searchProduct(searchProduct);
                                    System.out.print("Enter the amount of product you want to remove: ");
                                    int productAmount = scan.nextInt();
                                    ((User) myAcc).removeFromShoppingCart(searchedProduct, productAmount);
                                }
                                if (myChoice == 3) {
                                    // back
                                    continue;
                                }
                                break;
                            case 6:
                                myAcc.log.add("User, " + myAcc.username + ", logged out.");
                                myAcc = null;
                                break;
                        }


                    }
                    while (myAcc instanceof Seller) {


                        System.out.println("Welcome, Mr.Seller in " + myAcc.getCompanyName() + " company!");

                        System.out.println("Wallet : " + "$" + myAcc.wallet);
                        System.out.println("-----------------------------");
                        System.out.println("Select a page of your choice! \n1.Edit profile\n2.Add and Remove products\n3.Logout");
                        int choice = scan.nextInt();

                        if (choice == 1) { // editing profile
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
                            myAcc.log.add("Seller, " + myAcc.username + ", has edited their profile");
                        }

                        if (choice == 2 && ((Seller) myAcc).sellerRequest) { // add or remove product
                            System.out.println("1.Add product \t2.Remove product");
                            int myChoice = scan.nextInt();
                            if (myChoice == 1) { // Adding product


                                System.out.println("Type your product info.");
                                System.out.print("1.Product name: ");
                                String productName = scan.next();
                                System.out.print("2.Product price: ");
                                double productPrice = scan.nextDouble();
                                System.out.print("3.Product amount: ");
                                double productAmount = scan.nextDouble();
                                System.out.print("4.Product information: ");
                                String productInfo = scan.next();

                                Category.showCategory(); // showing categories
                                System.out.println("\nSelect the category number you want to add item to: ");
                                int categoryNumber = scan.nextInt();

                                Product newProduct = new Product(productName, productPrice, productAmount, productInfo, (Seller) myAcc, Category.categories.get(categoryNumber - 1));
                                ((Seller) myAcc).products.add(newProduct);


                                System.out.println(newProduct.name + " added successfully in --" + Category.categories.get(categoryNumber - 1).name + "-- category.");

                                myAcc.log.add("Seller, " + myAcc.username + " , has added " + newProduct.name + " to" + Category.categories.get(categoryNumber - 1).name + " category.");
                            }
                            if (myChoice == 2) { // Removing product

                                Category.showCategory(); // showing categories
                                System.out.println("\nSelect the category number you want to remove product from: ");
                                int categoryNumber = scan.nextInt();

                                int i = 1;
                                System.out.println("Products in --" + Category.categories.get(categoryNumber - 1).name + "-- category");
                                for (Product product : Category.categories.get(categoryNumber - 1).products) {
                                    System.out.println(i + ".Product name: " + product.name + "\tProduct price " + product.price + "\tProduct amount: " + product.amount + "\tProduct info: " + product.itemData);
                                    i++;
                                }
                                System.out.print("Which of the products above do you want to remove? ");
                                int productChoice = scan.nextInt();


                                Product selectedProduct = Category.categories.get(categoryNumber - 1).products.get(productChoice - 1);

                                System.out.print("Select the amount you want to remove: ");
                                int removeAmount = scan.nextInt();
                                if (selectedProduct.amount > removeAmount) {
                                    selectedProduct.amount -= removeAmount;
                                    ((Seller)myAcc).products.get(productChoice - 1).amount -= removeAmount;
                                    System.out.println(removeAmount + " of " + selectedProduct.name + " was removed from" + Category.categories.get(categoryNumber).name + " category.");
                                    selectedProduct.amount -= removeAmount;
                                    myAcc.log.add("Seller, " + myAcc.username + ", removed " + removeAmount + " " + selectedProduct.name + " from the Shop.");
                                } else {
                                    ((Seller) myAcc).products.remove(selectedProduct);
                                    Shop.productList.remove(selectedProduct);
                                    Category.categories.get(categoryNumber - 1).products.remove(selectedProduct);

                                    System.out.println(selectedProduct.name + " removed successfully from " + Category.categories.get(categoryNumber - 1).name + " category.");
                                    myAcc.log.add("Seller, " + myAcc.username + " , has removed " + selectedProduct.name + " to" + Category.categories.get(categoryNumber - 1).name + " category.");

                                }
                            }
                        } else if (!((Seller) myAcc).sellerRequest) {
                            System.out.println("Request has been set to the Admin.");
                        }
                        if (choice == 3) {
                            myAcc.log.add("Seller, " + myAcc.username + ", logged out.");
                            myAcc = null;
                            break;
                        }
                    }
                    while (myAcc instanceof Admin) {
                        System.out.println("Welcome " + myAcc.username + ".");

                        System.out.println("Total Profit: " + Shop.profit);

                        System.out.println("Select a page of your choice! \n1.Edit Profile\n2.Seller's Request\n3.Fund requests from user\n4.Add fund to someone\n5.Promote to admin\n6.Bids\n7.User/Seller log\n8.Logout");
                        int choice = scan.nextInt();
                        String finishChanging;
                        switch (choice) {
                            case 1: // editing profile
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
                                    }
                                    System.out.println("If you no longer want to change your info type \"finish\"");
                                    finishChanging = scan.next();

                                } while (!finishChanging.equals("finish"));
                                break;
                            case 2: // seller's request
                                Request.showSellerRequest();
                                System.out.println("Select a request to accept: ");
                                int myChoice = scan.nextInt();
                                ((Admin) myAcc).acceptSellerRequest(Request.sellerRequest.get(myChoice - 1));
                                Request.sellerRequest.remove(myChoice - 1);
                                System.out.println("request accepted!");
                                break;
                            case 3: // fund requests
                                Request.fundRequest();
                                System.out.println("Select the number of fund request of your choice: ");
                                myChoice = scan.nextInt();
                                ((Admin) myAcc).acceptFundRequest(Request.fundRequests.get(myChoice - 1));
                                Request.fundRequests.remove(myChoice - 1);
                                System.out.println("Fund request accepted!");
                                break;
                            case 4: // adding fund to someone
                                int i = 1;
                                for (Account acc : Shop.accountList) {
                                    if (role.equals(Roles.SELLER.toString())) {
                                        System.out.println(i + "." + acc.getCompanyName());
                                    } else {
                                        System.out.println(i + "." + acc.username);
                                    }
                                    i++;
                                }

                                System.out.print("Search the username you want: ");
                                String searchUsername = scan.next();
                                System.out.println("Type the amount of fund you want to add: ");
                                double addFund = scan.nextDouble();
                                Shop.searchAccount(searchUsername).wallet += addFund;
                                System.out.println("New balance: " + Shop.searchAccount(searchUsername).wallet);
                                break;
                            case 5: // promote to admin
                                System.out.println("1.Promote an existing account to an Admin  \t2.Register a new account as an Admin");
                                int promoteChoice = scan.nextInt();
                                if (promoteChoice == 1) {
                                    System.out.print("Search the username you want to promote: ");
                                    searchUsername = scan.next();
                                    Account newAdmin = Shop.searchAccount(searchUsername);
                                    new Admin(newAdmin.username, newAdmin.getPassword(), newAdmin.getEmailAddress());
                                    Shop.accountList.remove(newAdmin);
                                    System.out.println(newAdmin.username + " has promoted to Admin :D");
                                }
                                if (promoteChoice == 2) { // register as a new admin
                                    System.out.println("== Register as an Admin ==");
                                    String adminUsername = "";
                                    String adminPassword = "";
                                    String adminEmail = "";

                                    register(adminUsername, adminPassword, adminEmail);
                                    System.out.println("Registration completed.");
                                }
                                break;
                            case 6: // User's bids
                                Bid.showBids();
                                choice = scan.nextInt();
                                Bid currentBid = Shop.bidsList.get(choice - 1);
                                ((Admin) myAcc).acceptBid(currentBid);
                                // removing from both User's Bid list and Admins' Bid list
                                Shop.bidsList.remove(choice - 1);
                                currentBid.user.userBidList.remove(currentBid);
                                break;
                            case 7: // User's/Seller's log
                                i = 1;
                                for (Account acc : Shop.accountList) {
                                    if (role.equals(Roles.SELLER.toString())) {
                                        System.out.println(i + "." + acc.getCompanyName());
                                    } else {
                                        System.out.println(i + "." + acc.username);
                                    }
                                    i++;
                                }

                                System.out.print("Enter the username which you want to see the log from: ");
                                searchUsername = scan.next();
                                Account acc = Shop.searchAccount(searchUsername);
                                i = 1;
                                for (String s : acc.log) {
                                    System.out.println(i + "." + s);
                                    i++;
                                }
                                break;
                            case 8: // logout
                                myAcc = null;
                                break;
                        }
                    }
                }
            }
        }
    }
}