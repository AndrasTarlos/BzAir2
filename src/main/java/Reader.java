import java.util.InputMismatchException;
import java.util.Scanner;
public class Reader {

    public static Scanner sc;

    public Reader() {
        sc = new Scanner(System.in);
    }

    public String readString(String text) {
        System.out.print(text);
        return sc.nextLine();
    }

    public int readInteger(String text) {
        System.out.print(text);
        while (!sc.hasNextInt()) {
            System.out.print("Not an integer!");
            System.out.print(text);
            sc.next();
        }
        return sc.nextInt();
    }

    public double readDouble(String text) {
        System.out.print(text);
        while (!sc.hasNextDouble()) {
            System.out.print("Not a double!");
            System.out.print(text);
            sc.next();
        }
        return sc.nextDouble();
    }

    public char readChar(String text) {
        char input = ' ';
        boolean error = false;
        do {
            try {
                System.out.print(text);
                input = sc.next().charAt(0);
            } catch (InputMismatchException i) {
                error = true;
                sc.nextLine();
            }
        } while (error);
        return input;
    }
}
