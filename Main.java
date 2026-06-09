import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // username and masterpassword
        // System.out.println("Username:");
        // String mainUser = sc.nextLine().trim();
        // System.out.println("Password:");
        // String mainPass = sc.nextLine().trim();

        FileManager.createCredentials();
        ArrayList<Credentials> credentials = new ArrayList<Credentials>();
        FileManager.loadCredentials(credentials);

        boolean running = true;
        while (running) {

            System.out.println("""
                    \nMenu:
                    1] View Credentials
                    2] Store Credentials
                    3] Delete Credentials
                    4] Search Credentials
                    5] Update Credentials
                    6] Generate Password
                    7] Exit
                    """);

            int choice = sc.nextInt();
            sc.nextLine().trim();

            switch (choice) {
                case 1:
                    if (credentials.isEmpty())
                        System.out.println("Password Manager is Empty!");
                    else {
                        for (Credentials c : credentials) {
                            System.out.println(c);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter Credentials:");

                    System.out.print("Service: ");
                    String service = sc.nextLine().trim();

                    System.out.print("Username: ");
                    String username = sc.nextLine().trim();

                    System.out.print("Password: ");
                    String password = sc.nextLine().trim();

                    Credentials cred = new Credentials(service, username, password);
                    credentials.add(cred);

                    break;
                case 3:
                    if (credentials.isEmpty())
                        System.out.println("Password Manager is Empty!");
                    else {
                        System.out.print("Enter Service name: ");
                        String delService = sc.nextLine().trim();
                        credentials.removeIf(c -> c.service.equalsIgnoreCase(delService));
                    }
                    break;
                case 4:
                    System.out.print("Enter service name: ");
                    String searchKey = sc.nextLine().trim();
                    boolean searchFound = false;
                    for (Credentials c : credentials) {
                        if (searchKey.equalsIgnoreCase(c.service)) {
                            System.out.println(c.toString());
                            searchFound = true;
                        }
                    }
                    if (!searchFound)
                        System.out.println("No credentials found for service: " + searchKey);
                    break;
                case 5:
                    System.out.println("""
                            1] Update Username
                            2] Update Password
                            3] Update Username & Password
                            """);
                    int updateChoice = sc.nextInt();
                    sc.nextLine().trim();

                    Set<Integer> validChoices = Set.of(1, 2, 3);
                    if (!validChoices.contains(updateChoice)) {
                        System.out.println("Invalid Choice. Try Again!");
                        break;
                    }
                    System.out.print("Enter service name: ");
                    String updateServiceKey = sc.nextLine().trim();
                    System.out.print("Enter username: ");
                    String updateUsernameKey = sc.nextLine().trim();

                    boolean updateFound = false;
                    for (Credentials c : credentials) {
                        if (updateServiceKey.equalsIgnoreCase(c.service)
                                && updateUsernameKey.equalsIgnoreCase(c.username)) {
                            if (updateChoice == 1) {
                                System.out.print("Enter new username: ");
                                String newUsername = sc.nextLine().trim();
                                if (newUsername.equalsIgnoreCase(c.username))
                                    System.out.println("New username can't be the old username!");
                                else {
                                    c.username = newUsername;
                                    System.out.println("Username Updated.");
                                }
                            } else if (updateChoice == 2) {
                                System.out.print("Enter new password: ");
                                String newPass = sc.nextLine().trim();
                                if (newPass.equalsIgnoreCase(c.password))
                                    System.out.println("New password can't be the old password!");
                                else {
                                    c.password = newPass;
                                    System.out.println("Password Updated.");
                                }
                            } else {
                                System.out.print("Enter new username: ");
                                String newUsername = sc.nextLine().trim();
                                if (newUsername.equalsIgnoreCase(c.username))
                                    System.out.println("New username can't be the old username!");
                                else {
                                    c.username = newUsername;
                                    System.out.println("Username Updated.");
                                }

                                System.out.print("Enter new password: ");
                                String newPass = sc.nextLine().trim();
                                if (newPass.equalsIgnoreCase(c.password))
                                    System.out.println("New password can't be the old password!");
                                else {
                                    c.password = newPass;
                                    System.out.println("Password Updated.");
                                }
                            }
                            updateFound = true;
                            break;
                        }
                    }
                    if (!updateFound)
                        System.out.println("No credentials found for service: " + updateServiceKey + "and username: "
                                + updateUsernameKey);
                    break;
                case 6:
                    System.out.print("Enter password length: ");
                    int passLength = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Include symbols (y/n): ");
                    String symbol = sc.nextLine().trim();
                    System.out.print("Include digits (y/n): ");
                    String digit = sc.nextLine().trim();

                    String passGenerated = PasswordGenerator.generatePass(symbol, digit, passLength);
                    System.out.println("Password: " + passGenerated);
                    break;
                case 7:
                    running = false;
                    FileManager.saveCredentials(credentials);
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}