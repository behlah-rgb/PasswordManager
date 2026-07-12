import java.io.*;
import java.util.ArrayList;

public class MasterPasswordManager {
    String masterUser;
    String masterPass;

    MasterPasswordManager(String masterUser, String masterPass) {
        this.masterPass = masterPass;
        this.masterUser = masterUser;
    }

    @Override
    public String toString() {
        return "Username: " + masterUser +
                "\nPassword: " + masterPass;
    }

    String forFile() {
        return masterUser + ", " + masterPass + "\n";
    }

    static void loadMasterFile(ArrayList<MasterPasswordManager> masterPasswordManager) {
        File masterFile = new File("MasterPasswordManager.txt");

        if (!masterFile.exists())
            System.out.println("First Run!");
        else {
            try (BufferedReader br = new BufferedReader(new FileReader(masterFile))) {
                String masterLine;
                while ((masterLine = br.readLine()) != null) {
                    String[] parts = masterLine.split(", ");
                    MasterPasswordManager c = new MasterPasswordManager(parts[0], parts[1]);
                    masterPasswordManager.add(c);
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static void saveMasterPasswordManager(ArrayList<MasterPasswordManager> masterPasswordManager) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("MasterPasswordManager.txt"))) {
            for (MasterPasswordManager mp : masterPasswordManager) {
                bw.write(mp.forFile());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static boolean authenticate(ArrayList<MasterPasswordManager> masterPasswordManager, String masterUser,
            String masterPass, String newUser) {
        if (newUser.equalsIgnoreCase("y")) {
            MasterPasswordManager mp = new MasterPasswordManager(masterUser, masterPass);
            masterPasswordManager.add(mp);
            return true;
        } else {
            for (MasterPasswordManager mp : masterPasswordManager) {
                if (mp.masterUser.equals(masterUser) && mp.masterPass.equals(masterPass)) {
                    return true;
                }
            }
            return false;
        }
    }

}
