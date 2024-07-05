import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static Account register(String username, String password, String emailAddress, String phoneNumber, String address) {
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


        return new Account(username, password, emailAddress, phoneNumber, address, Roles.USER);
    }

    public static Account register(String username, String password, String emailAddress) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Username: ");
        username = scan.next();
        System.out.print("Password: ");
        password = scan.next();
        System.out.print("Email: ");
        emailAddress = scan.next();


        return new Account(username, password, emailAddress, Roles.ADMIN);
    }

    public static Account register(String companyName, String password) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Company name: ");
        companyName = scan.next();
        System.out.print("Password: ");
        password = scan.next();

        return new Account(companyName, password, Roles.SELLER);
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


                System.out.println("Choose your role: \n{ USER } \n{ SELLER }\n{ ADMIN }");
                String role = scan.next();

                while (myAcc == null) {
                    System.out.println("Type 1 to login and type 2 to register!"); // asking whether you have an account or not
                    int enter = scan.nextInt();
                    if (enter == 1) { // login process
                        for (Account acc : Shop.accountList) {
                            if (acc.role.toString().equals(role)) {
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
                                        AccountManagement.login(loginUsername, loginPassword, Shop.accountList.getLast());
                                    } while (!loginUsername.equals(acc.username) || !loginPassword.equals(acc.getPassword()));
                                } else if (role.equals(Roles.SELLER.toString())) {
                                    do {
                                        System.out.println("== Login ==");
                                        System.out.print("Company name: ");
                                        loginCompanyName = scan.next();
                                        System.out.print("Password: ");
                                        loginPassword = scan.next();
                                        AccountManagement.login(loginCompanyName, loginPassword, Shop.accountList.getLast());
                                    } while (!loginCompanyName.equals(acc.username) || !loginPassword.equals(acc.getPassword()));
                                } else if (role.equals(Roles.ADMIN.toString())) {
                                    System.out.println("== Login ==");
                                    do { // user's login
                                        System.out.print("Username: ");
                                        loginUsername = scan.next();
                                        System.out.print("Password: ");
                                        loginPassword = scan.next();
                                        AccountManagement.login(loginUsername, loginPassword, Shop.accountList.getLast());
                                    } while (!loginUsername.equals(acc.username) || !loginPassword.equals(acc.getPassword()));
                                }
                            } else {
                                System.out.println("No " + role + " exist!");
                            }
                        }
                    } else if (enter == 2) { // registering process
                        if (role.equals(Roles.USER.toString())) { // your role as a User
                            myAcc = register(username, password, emailAddress, phoneNumber, userAddress); // registration
                            Shop.accountList.add(myAcc);

                            System.out.println("== Login ==");
                            String loginUsername;
                            String loginPassword;
                            do { // user's login
                                System.out.print("Username: ");
                                loginUsername = scan.next();
                                System.out.print("Password: ");
                                loginPassword = scan.next();
                                AccountManagement.login(loginUsername, loginPassword, myAcc);
                            } while (!loginUsername.equals(myAcc.username) || !loginPassword.equals(myAcc.getPassword()));


                        } else if (role.equals(Roles.SELLER.toString())) { // your role as a seller
                            myAcc = register(username, password);
                            Shop.accountList.add(myAcc);

                            System.out.println("== Login ==");
                            String loginUsername;
                            String loginPassword;
                            do { // user's login
                                System.out.print("Username: ");
                                loginUsername = scan.next();
                                System.out.print("Password: ");
                                loginPassword = scan.next();
                                AccountManagement.login(loginUsername, loginPassword, myAcc);
                            } while (!loginUsername.equals(myAcc.username) || !loginPassword.equals(myAcc.getPassword()));


                        } else if (role.equals(Roles.ADMIN.toString())) { // your role as an admin
                            myAcc = register(username, password, emailAddress);
                            Shop.accountList.add(myAcc);

                            System.out.println("== Login ==");
                            String loginUsername;
                            String loginPassword;
                            do { // user's login
                                System.out.print("Username: ");
                                loginUsername = scan.next();
                                System.out.print("Password: ");
                                loginPassword = scan.next();
                                AccountManagement.login(loginUsername, loginPassword, myAcc);
                            } while (!loginUsername.equals(myAcc.username) || !loginPassword.equals(myAcc.getPassword()));
                        }
                    }


                    if (role.equals(Roles.USER.toString())) {
                        System.out.println("Welcome " + Shop.accountList.getLast().username + ".");


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

                        System.out.println("Welcome, Mr.Seller in " + Shop.accountList.getLast().getCompanyName()+" company!");


                    } else if (role.equals(Roles.ADMIN.toString())) {
                        System.out.println("Welcome " + Shop.accountList.getLast().username + ".");


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