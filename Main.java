import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<MasterPasswordManager> masterPasswordManager = new ArrayList<>();
        MasterPasswordManager.loadMasterFile(masterPasswordManager);

        System.out.println("Username:");
        String masterUser = sc.nextLine().trim();
        System.out.println("Password:");
        String masterPass = sc.nextLine().trim();

        boolean verdict = MasterPasswordManager.authenticate(masterPasswordManager, masterUser, masterPass);
        MasterPasswordManager.saveMasterPasswordManager(masterPasswordManager);

        if (verdict) {
            ArrayList<Credentials> credentials = new ArrayList<>();
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
                        PasswordManager.viewCredentials(credentials);
                        break;
                    case 2:
                        System.out.println("Enter Credentials:");

                        System.out.print("Service: ");
                        String service = sc.nextLine().trim();

                        System.out.print("Username: ");
                        String username = sc.nextLine().trim();

                        System.out.print("Password: ");
                        String password = sc.nextLine().trim();

                        PasswordManager.storeCredentials(credentials, service, username, password);
                        break;
                    case 3:
                        PasswordManager.deleteCredentials(credentials, sc);
                        break;
                    case 4:
                        System.out.print("Enter service name: ");
                        String searchKey = sc.nextLine().trim();
                        PasswordManager.searchCredentials(credentials, searchKey);
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

                        PasswordManager.updateCredentials(credentials, updateServiceKey, updateUsernameKey,
                                updateChoice,
                                sc);
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
        } else {
            System.out.println("Incorrect Password!");
        }
    }
}