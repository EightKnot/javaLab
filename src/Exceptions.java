import java.util.Scanner;

public class Exceptions {
    public static void main(String[] args) {

        /**
         * Throw custom exception
         * + finally block
         */
        if (true) {
            try {
                throw new CustomException(17, "True value in If-block!");
            } catch (CustomException e) {
                System.out.println("CustomException block:\n" + e.getSomeInt() + " " + e.getSomeStr());
                System.out.println(e.getMessage());
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println(e.getMessage());
                System.out.println(e.getMessage());
                System.err.println(e.getMessage());   // Priority???
            } finally {
                System.out.println("Finally block");
                System.err.println("Finally block");  // Print text in the head or in the end of console output
            }
        }

        /**
         * Catching RuntimeException
         */
        Scanner scanner = new Scanner(System.in);
        int input = 1;
        while (input != 7) {
            try {
                int i = 6 / input;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.err.println(e.getMessage());         // WTF?!?
                e.printStackTrace();
            }
            System.out.println(input);
            input = scanner.nextInt();
        }

        System.out.println("Finishing the application...");
    }
}
