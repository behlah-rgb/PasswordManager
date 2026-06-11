import java.util.ArrayList;
import java.util.Scanner;

public class PasswordManager {
    static void viewCredentials(ArrayList<Credentials> credentials) {
        if (credentials.isEmpty())
            System.out.println("Password Manager is Empty!");
        else {
            for (Credentials c : credentials) {
                System.out.println(c);
            }
        }
    }

    static void storeCredentials(ArrayList<Credentials> credentials, String service, String username, String password) {
        Credentials cred = new Credentials(service, username, password);
        credentials.add(cred);

    }

    static void deleteCredentials(ArrayList<Credentials> credentials, Scanner sc) {
        if (credentials.isEmpty())
            System.out.println("Password Manager is Empty!");
        else {
            System.out.print("Enter Service name: ");
            String delService = sc.nextLine().trim();
            credentials.removeIf(c -> c.service.equalsIgnoreCase(delService));
        }
    }

    static void searchCredentials(ArrayList<Credentials> credentials, String searchKey) {
        boolean searchFound = false;
        for (Credentials c : credentials) {
            if (searchKey.equalsIgnoreCase(c.service)) {
                System.out.println(c.toString());
                searchFound = true;
            }
        }
        if (!searchFound)
            System.out.println("No credentials found for service: " + searchKey);
    }

    static void updateCredentials(ArrayList<Credentials> credentials, String updateServiceKey, String updateUsernameKey,
            int updateChoice, Scanner sc) {
        boolean updateFound = false;
        for (Credentials c : credentials) {
            if (updateServiceKey.equalsIgnoreCase(c.service)
                    && updateUsernameKey.equalsIgnoreCase(c.username)) {
                if (updateChoice == 1) {
                    System.out.print("Enter new username: ");
                    String newUsername = sc.nextLine().trim();
                    updateUsername(newUsername, c);
                } else if (updateChoice == 2) {
                    System.out.print("Enter new password: ");
                    String newPass = sc.nextLine().trim();
                    updatePassword(newPass, c);
                } else {
                    System.out.print("Enter new username: ");
                    String newUsername = sc.nextLine().trim();
                    updateUsername(newUsername, c);

                    System.out.print("Enter new password: ");
                    String newPass = sc.nextLine().trim();
                    updatePassword(newPass, c);
                }
                updateFound = true;
                break;
            }
        }
        if (!updateFound)
            System.out.println("No credentials found for service: " + updateServiceKey + "and username: "
                    + updateUsernameKey);
    }

    static void updateUsername(String newUsername, Credentials c) {
        if (newUsername.equalsIgnoreCase(c.username))
            System.out.println("New username can't be the old username!");
        else {
            c.username = newUsername;
            System.out.println("Username Updated.");
        }
    }

    static void updatePassword(String newPass, Credentials c) {
        if (newPass.equalsIgnoreCase(c.password))
            System.out.println("New password can't be the old password!");
        else {
            c.password = newPass;
            System.out.println("Password Updated.");
        }
    }
}
