package jason_li_project1.model;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class represents the operation of ordering pizza
 *
 * @author Jason Li
 */
public class OrderingMethods {
    /**
     * this method asks the user to enter a number from the option (1 or 2)
     *
     * @param option the number from the user input
     * @return the number of option (1 or 2)
     */
    public static int optionInput(int option) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                option = input.nextInt();
                // clear the carriage return from the input buffer
                input.nextLine();
                if (option == 1 || option == 2) {
                    return option;
                } else {
                    System.out.println("Please enter a valid number. (1 or 2)");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number of option.");
                // clear the incorrect datatype of input from the input buffer
                input.nextLine();
            }
        } while (true);
    }

    /**
     * this method asks the user for their name or the name of the topping
     *
     * @param letters the name of the user or topping
     * @return the string with at least three letters and it contains no numbers
     */
    public static String moreThanTwoLetters(String letters) {
        Scanner input = new Scanner(System.in);
        do {
            int i; // this is for checking if all the characters are letters
            letters = input.nextLine();
            if (letters.length() > 2) {
                char[] arrChar = letters.toCharArray(); // method from tutorialspoint.com
                for (i = 0; i < arrChar.length; i++) {
                    // this shows that the user enter a full name
                    if (arrChar[i] == ' ') {
                    } // check if each character contains a number
                    else if (!Character.isLetter(arrChar[i])) { // method from tutorialspoint.com
                        System.out.println("Only letters are allowed, please try again.");
                        break;
                    }
                }
                // this shows that the string contains no numbers since it checked all the characters
                if (i == arrChar.length) {
                    return letters;
                }
            } else {
                System.out.println("Must be more than two characters, please try again.");
            }
        } while (true);
    }

    /**
     * this method asks the user for a valid phone number
     *
     * @param digits the form of a phone number as a string
     * @return the string of the form of a phone number
     */
    public static String checkPhoneNumber(String digits) {
        Scanner input = new Scanner(System.in);
        do {
            int i; // this is for checking if the string is a phone number
            digits = input.nextLine();
            if (digits.length() == 12) {
                char[] arrChar = digits.toCharArray(); // method from tutorialspoint.com
                for (i = 0; i < arrChar.length; i++) {
                    // check if each character contains a number
                    if (Character.isLetter(arrChar[i])) { // method from tutorialspoint.com
                        System.out.println("No letters are allowed, please enter your phone number again.");
                        break;
                    } else if (i == 3) {
                        if (arrChar[i] != ' ') {
                            System.out.println("Invalid phone number, please try again.");
                            break;
                        }
                    } else if (i == 7) {
                        if (!(arrChar[i] == '-' || arrChar[i] == ' ')) {
                            System.out.println("Invalid phone number, please try again.");
                            break;
                        }
                    }
                }
                // this shows that the string is a valid phone number since it checked all the characters
                if (i == arrChar.length) {
                    return digits;
                }
            } else {
                System.out.println("Invalid phone number, please try again.");
            }
        } while (true);
    }

    /**
     * this method asks the user for the number of pizza or topping
     *
     * @param numberFood the number of pizza or topping
     * @return the number of pizza or topping
     */
    public static int quantityOfFood(int numberFood) {
        Scanner input = new Scanner(System.in);
        do {
            try {
                numberFood = input.nextInt();
                // clear the carriage return from the input buffer
                input.nextLine();
                if (numberFood > 0) {
                    return numberFood;
                } else {
                    System.out.println("Please enter a valid number. (Minimum: 1)");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Please enter a valid number.");
                // clear the incorrect datatype of input from the input buffer
                input.nextLine();
            }
        } while (true);
    }
}
