import java.io.*;
import java.util.ArrayList;

public class FileManager {

    static void loadCredentials(ArrayList<Credentials> credentials, String masterUser) {
        File credFile = new File(masterUser + "Credentials.txt");

        if (!credFile.exists())
            System.out.println("First Run!");
        else {
            try (BufferedReader br = new BufferedReader(new FileReader(credFile))) {
                String credLine;
                while ((credLine = br.readLine()) != null) {
                    String[] parts = credLine.split(", ");
                    Credentials c = new Credentials(parts[0], parts[1], parts[2]);
                    credentials.add(c);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void saveCredentials(ArrayList<Credentials> credentials, String masterUser) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(masterUser + "Credentials.txt"))) {
            for (Credentials c : credentials) {
                bw.write(c.forFile());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
