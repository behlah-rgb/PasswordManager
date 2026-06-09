import java.util.Random;

public class PasswordGenerator {
    static String generatePass(String symbol, String digit, int length){
        String passList = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if(symbol.equalsIgnoreCase("y"))
            passList += "!@#$%^&*";
        if(digit.equalsIgnoreCase("y"))
            passList += "0123456789";
        
        Random r = new Random();
        String password = "";
        while(length !=0){
            password += passList.charAt(r.nextInt(passList.length()));
            length--;
        }
        
        return password;
    }
}
