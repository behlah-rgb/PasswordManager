import java.io.*;
//import java.util.Scanner;
import java.util.ArrayList;

public class FileManager {
    static void createCredentials() {
        try {
            // String name = sc.nextLine();
            File credFile = new File("Credentials.txt");
            if (credFile.createNewFile()) {
                System.out.println("File created: " + credFile.getName());
            } else {
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void loadCredentials(ArrayList<Credentials> credentials) {
        try (BufferedReader br = new BufferedReader(new FileReader("Credentials.txt"))) {
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

    static void saveCredentials(ArrayList<Credentials> credentials){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Credentials.txt"))){
            for(Credentials c : credentials){
                String credLine = c.forFile();
                bw.write(credLine);
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
