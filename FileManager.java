import java.io.*;
//import java.util.Scanner;

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

    static void loadCredentials() {
        try (BufferedReader br = new BufferedReader(new FileReader("Credentials.txt"))) {
            String credLine;
            while ((credLine = br.readLine()) != null) {
                System.out.println(credLine);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static void writeCredentials(Credentials c){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Credentials.txt"))){
            String credLine = c.toString();
            bw.write(credLine);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
