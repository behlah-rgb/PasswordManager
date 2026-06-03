import java.util.*;

public class Main {
    public static void main(String[] args) {
        FileManager.createCredentials();
        // username and masterpassword
        Scanner sc = new Scanner(System.in);
        System.out.println("Username:");
        String mainUser = sc.nextLine();
        System.out.println("Password:");
        String mainPass = sc.nextLine();

        ArrayList<Credentials> credentials = new ArrayList<Credentials>();
        // ask to store credentials
        boolean running = true;
        while (running) {

            System.out.println("""
                    \nMenu:
                    1] View Credentials
                    2] Store Credentials
                    3] Delete Credentials
                    4] Exit
                    """);

            int choice = sc.nextInt();
            sc.nextLine();

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

                    System.out.println("Service:");
                    String service = sc.nextLine();

                    System.out.println("Username:");
                    String username = sc.nextLine();

                    System.out.println("Password:");
                    String password = sc.nextLine();

                    Credentials cred = new Credentials(service, username, password);
                    credentials.add(cred);

                    break;
                case 3:
                    if (credentials.isEmpty())
                        System.out.println("Password Manager is Empty!");
                    else {
                        System.out.println("Enter Service name:");
                        String delService = sc.nextLine();
                        credentials.removeIf(c -> c.service.equalsIgnoreCase(delService));
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }
}