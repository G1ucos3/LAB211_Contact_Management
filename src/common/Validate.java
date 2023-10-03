package common;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author ASUS
 */
public class Validate {

    private final static String[] phoneMatch = {"\\d{10}", "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}",
        "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}\\sx[0-9]{4}",
        "[0-9]{3}\\-[0-9]{3}\\-[0-9]{4}\\sext[0-9]{4}",
        "\\([0-9]{3}\\)\\-[0-9]{3}\\-[0-9]{4}",
        "[0-9]{3}\\.[0-9]{3}\\.[0-9]{4}",
        "[0-9]{3}\\s[0-9]{3}\\s[0-9]{4}"};

    public String checkString(String s) {
        String str = "";
        while (str.isBlank() || str.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print(s + ": ");
            str = sc.nextLine();
        }
        return str;
    }

    public int checkID() {
        int id;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter ID: ");
                id = sc.nextInt();
                if (id < 1) {
                    System.err.println("ID must be greater than or equal to 1.");
                    continue;
                }
                return id;
            } catch (InputMismatchException E) {
                System.err.println("ID is digit");
            }
        }
    }

    public String checkName(String s) {
        String name;
        while (true) {
            name = checkString(s);
            name = name.trim();
            name = name.replaceAll("\\s+", " ");
            String[] list = name.split(" ");
            if (list.length >= 2) {
                return name;
            }
            System.err.println("FirstName LastName");
        }
    }

    public String checkPhone(String s) {
        String phone;
        while (true) {
            try {
                phone = checkString(s);
                for (String check : phoneMatch) {
                    if (phone.matches(check)) {
                        return phone;
                    }
                }
            } catch (PatternSyntaxException E) {
                System.err.println("""
                               Please input Phone flow
                               - 1234567890
                               - 123-456-7890 
                               - 123-456-7890 x1234
                               - 123-456-7890 ext1234
                               - (123)-456-7890
                               - 123.456.7890
                               - 123 456 7890""");
            }
        }

    }
}
