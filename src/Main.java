import java.util.ArrayList;
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

        User user = new User(username, password, emailAddress, phoneNumber, address);
        Shop.accountList.add(user);
    }

    public static void register(String username, String password, String emailAddress) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Username: ");
        username = scan.next();
        System.out.print("Password: ");
        password = scan.next();
        System.out.print("Email: ");
        emailAddress = scan.next();


        Admin admin = new Admin(username, password, emailAddress);
        Shop.accountList.add(admin);
    }

    public static void register(String companyName, String password) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Company name: ");
        companyName = scan.next();
        System.out.print("Password: ");
        password = scan.next();

        Seller seller = new Seller(companyName,password);
        Shop.accountList.add(seller);
    }

    public static Account myAcc;

    public static void main(String[] args) {
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
                                myAcc = AccountManagement.login(loginUsername, loginPassword, Shop.accountList);
                            } while (!loginUsername.equals(myAcc.username) || !loginPassword.equals(myAcc.getPassword()));
                        } else {
                            System.out.println("No " + role + " exist!");
                        }
                    }


                    if (role.equals(Roles.USER.toString())) {
                        System.out.println("Welcome " + myAcc.username + ".");



                        // getting the menu of the shop

                        System.out.println("Select a page of your choice! \n1.Edit Profile");
                        int choice = scan.nextInt();
                        String finishChanging;
                        AccountManagement accountEditing = new AccountManagement();
                        switch (choice) { // selecting profile editing
                            case 1:
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
                        }


                    } else if (role.equals(Roles.SELLER.toString())) {

                        System.out.println("Welcome, Mr.Seller in " + myAcc.getCompanyName()+" company!");


                    } else if (role.equals(Roles.ADMIN.toString())) {
                        System.out.println("Welcome " + myAcc.username + ".");


                        System.out.println("Select a page of your choice! \n1.Edit Profile");
                        int choice = scan.nextInt();
                        String finishChanging;
                        AccountManagement accountEditing = new AccountManagement();
                        switch (choice) {
                            case 1:
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
                        }
                    }
                }
            }
        }
    }
}