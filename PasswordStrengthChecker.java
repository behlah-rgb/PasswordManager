//len = 8-12
//categories:  weak medium strong veryStrong
//variety: lower upper special digits
//penalise: sequential repeated keyboardPattern commonPassword
//score: 0-10 10/4 for each

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class PasswordStrengthChecker {
    PasswordStrengthChecker(String password) {
        
    }

    static boolean isSequential(String password) {
        int len = password.length();
        char[] ch = password.toCharArray();

        int fault = 0;
        for (int i = 1; i < len; i++) {
            if (ch[i] == 1 + ch[i - 1] || ch[i - 1] == 1 + ch[i]) {
                fault++;
                if (fault >= 3)
                    return false;
            }
        }

        return true;
    }

    static boolean isRepeated(String password) {
        int len = password.length();
        char[] ch = password.toCharArray();

        int fault = 0;
        for (int i = 1; i < len; i++) {
            if (ch[i] == ch[i - 1]) {
                fault++;
                if (fault >= 3)
                    return false;
            }
        }

        return true;
    }

    static boolean isKeyboardPattern(String password) {
        File kp = new File("KeyboardPatterns.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(kp))) {
            while (br.readLine() != null) {
                if (password.equalsIgnoreCase(br.readLine()))
                    return false;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }

    static boolean isCommonPassword(String password) {
        File cp = new File("CommonPasswords.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(cp))) {
            while (br.readLine() != null) {
                if (password.equalsIgnoreCase(br.readLine()))
                    return false;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return true;
    }
}