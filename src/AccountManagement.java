public class AccountManagement implements ProfileEdit {


    public static void login(String username, String password,Account account) {
        if (account.role.equals(Roles.USER)) {
            if (account.username.equals(username) && account.getPassword().equals(password)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Failed to login!");
            }
        } else if (account.role.equals(Roles.SELLER)) {
            if (account.getCompanyName().equals(username) && account.getPassword().equals(password)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Failed to login!");
            }
        } else if (account.role.equals(Roles.ADMIN)) {
            if (account.username.equals(username) && account.getPassword().equals(password)) {
                System.out.println("Login successful!");
            } else {
                System.out.println("Failed to login!");
            }
        }
    }


    public void editUsername(String username, Account acc) {
        acc.username = username;
        System.out.println("New username is "+ acc.username);
    }

    public void editPassword(String password, Account acc) {
        acc.setPassword(password);
        System.out.println("New password is "+ acc.getPassword());
    }

    public void editEmail(String email, Account acc) {
        acc.setEmailAddress(email);
        System.out.println("New email is "+ acc.getEmailAddress());
    }

    public void editPhoneNumber(String phoneNumber, Account acc) {
        acc.setPhoneNumber(phoneNumber);
        System.out.println("New phone number is "+ acc.getPhoneNumber());
    }

    public void editAddress(String address, Account acc) {
        acc.setAddress(address);
        System.out.println("New address is "+acc.getAddress());
    }

    public void editCompanyName(String companyName, Account acc) {
        acc.setCompanyName(companyName);
        System.out.println("New company name is "+ acc.getCompanyName());
    }
}
