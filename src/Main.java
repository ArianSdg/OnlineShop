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


        return new Account(username,password,emailAddress,phoneNumber,address,Roles.USER);
    }
    public static Account register(String username, String password, String emailAddress) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Username: ");
        username = scan.next();
        System.out.print("Password: ");
        password = scan.next();
        System.out.print("Email: ");
        emailAddress = scan.next();


        return new Account(username,password,emailAddress,Roles.ADMIN);
    }
    public static Account register(String companyName, String password) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Company name: ");
        companyName = scan.next();
        System.out.print("Password: ");
        password = scan.next();

        return new Account(companyName,password,Roles.SELLER);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Shop shop1 = new Shop("ArianKala","www.ariankala.com","09906431994");
        Shop shop2 = new Shop("ZohaKala","www.zohakala.com","09906431995");
        System.out.println("Enter your desired website Address.");

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

                String logOut;
                String confirmation;


                System.out.println("Choose your role: \n{ USER } \n{ SELLER }\n{ ADMIN }");
                String role = scan.next();
                if (role.equals(Roles.USER.toString())) { // your role as a User
                    Account userAccount = register(username, password, emailAddress, phoneNumber, userAddress);
                    Shop.accountList.add(userAccount);

                    System.out.println("== Login ==");

                    String loginUsername;
                    String loginPassword;

                    do { // user's login
                        System.out.print("Username: ");
                        loginUsername = scan.next();
                        System.out.print("Password: ");
                        loginPassword = scan.next();
                        AccountManagement.login(loginUsername, loginPassword, userAccount);
                    } while (!loginUsername.equals(userAccount.username) || !loginPassword.equals(userAccount.getPassword()));


                    System.out.println("Welcome " + userAccount.username + ".");


                    do { // getting the options of the shop

                        System.out.println("Select a page of your choice! \n1.Edit Profile");
                        int choice = scan.nextInt();
                        String finishChanging;
                        AccountManagement accountEditing = new AccountManagement();
                        switch (choice) { // selecting profile editing
                            case 1 :
                                do {
                                    System.out.println("1.Change username.\n2.Change password.\n3.Change email address.\n4.Change Phone number.\n5.Change address.");
                                    int changeChoice = scan.nextInt();

                                    switch (changeChoice) {
                                        case 1:
                                            System.out.print("Enter new username: ");
                                            String newUsername = scan.next();
                                            accountEditing.editUsername(newUsername, userAccount);
                                            break;
                                        case 2:
                                            System.out.print("Enter new password: ");
                                            String newPassword = scan.next();
                                            accountEditing.editPassword(newPassword, userAccount);
                                            break;
                                        case 3:
                                            System.out.print("Enter new email address: ");
                                            String newEmailAddress = scan.next();
                                            accountEditing.editEmail(newEmailAddress, userAccount);
                                            break;
                                        case 4:
                                            System.out.println("Enter new phone number: ");
                                            String newPhoneNumber = scan.next();
                                            accountEditing.editPhoneNumber(newPhoneNumber, userAccount);
                                            break;
                                        case 5:
                                            System.out.println("Enter new address: ");
                                            String newAddress = scan.next();
                                            accountEditing.editAddress(newAddress, userAccount);
                                            break;
                                        default:
                                            System.out.println("Failed to change your info!");
                                    }
                                    System.out.println("If you no longer want to change your info type \"finish\"");
                                    finishChanging = scan.next();

                                } while (!finishChanging.equals("finish")); // finishing the editing of profile
                            }
                            System.out.println("If you want to logout, type \"logout\" and your password."); // logout option
                            logOut = scan.next();
                            confirmation = scan.next();
                        } while (!logOut.equals("logout") && !confirmation.equals(userAccount.getPassword())); // boolean for logout option




                } else if (role.equals(Roles.SELLER.toString())) { // your role as a seller





                } else if (role.equals(Roles.ADMIN.toString())) { // your role as an admin
                    Account adminAccount = register(username, password, emailAddress);
                    Shop.accountList.add(adminAccount);

                    System.out.println("== Login ==");
                    String loginUsername;
                    String loginPassword;
                    do { // user's login
                        System.out.print("Username: ");
                        loginUsername = scan.next();
                        System.out.print("Password: ");
                        loginPassword = scan.next();
                        AccountManagement.login(loginUsername, loginPassword, adminAccount);
                    } while (!loginUsername.equals(adminAccount.username) || !loginPassword.equals(adminAccount.getPassword()));

                    System.out.println("Welcome " + adminAccount.username + ".");



                    do {
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
                                            accountEditing.editUsername(newUsername, adminAccount);
                                            break;
                                        case 2:
                                            System.out.print("Enter new password: ");
                                            String newPassword = scan.next();
                                            accountEditing.editPassword(newPassword, adminAccount);
                                            break;
                                        case 3:
                                            System.out.print("Enter new email address: ");
                                            String newEmailAddress = scan.next();
                                            accountEditing.editEmail(newEmailAddress, adminAccount);
                                            break;
                                    }System.out.println("If you no longer want to change your info type \"finish\"");
                                    finishChanging = scan.next();

                                } while (!finishChanging.equals("finish"));
                                break;
                        }
                        System.out.println("If you want to logout, type \"logout\" and your password."); // logout option
                        logOut = scan.next();
                        confirmation = scan.next();
                    } while (!logOut.equals("logout") && !confirmation.equals(adminAccount.getPassword())); // boolean for logout option
                }
            }
        }
    }
}