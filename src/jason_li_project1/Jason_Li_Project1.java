package jason_li_project1;

import jason_li_project1.model.Pizza;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class is going to create and display your order of pizza
 *
 * @author Jason Li
 */
public class Jason_Li_Project1 {

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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("***Pizza Ordering Application***\n");

        do {
            System.out.println("What do you want to do?\n1. Create a new Order" + "\n2. Exit Application");

            Scanner input = new Scanner(System.in);

            int option = -1;
            // want to keep asking the user until they enter a valid number of option (1 or 2)
            option = optionInput(option);

            if (option == 1) {

                System.out.println("\nEnter your name:");

                String name = "";
                // want to keep asking the user until they enter at least three character and no numbers
                name = moreThanTwoLetters(name);

                System.out.println("Enter your phone number:");

                String phoneNumber = "";
                // want to keep asking the user until they enter a valid phone number
                phoneNumber = checkPhoneNumber(phoneNumber);

                System.out.println("\nHow many pizza(s) will you be ordering?");

                int numberPizza = -1;

                // want to keep asking the user until they enter a valid number of pizzas
                numberPizza = quantityOfFood(numberPizza);

                // create an array of instances
                Pizza[] order = new Pizza[numberPizza];

                // create a loop that will go for each element of the array
                // creating an instance and adding to the array.
                for (int i = 0; i < order.length; i++) {

                    String format = "\nPizza %d of %d. Enter size:\n1 - for small" + "\n2 - for medium" + "\n3 - for large\n";
                    System.out.printf(format, i + 1, numberPizza);

                    int size = -1;

                    // want to keep asking the user until they enter a valid number of sizes (1, 2, or 3)
                    do {
                        try {
                            size = input.nextInt();
                            // clear the carriage return from the input buffer
                            input.nextLine();
                            if (size >= 1 && size <= 3) {
                                break;
                            } else {
                                System.out.println("Please enter size number from 1 to 3:\n1 - for small\n2 - for medium\n3 - for large");
                            }
                        } catch (InputMismatchException ex) {
                            System.out.println("Please enter a valid size number.");
                            // clear the incorrect datatype of input from the input buffer
                            input.nextLine();
                        }
                    } while (true);

                    System.out.println("\nHow many toppings?");

                    int numberTopping = -1;

                    // want to keep asking the user until they enter a valid number of toppings
                    numberTopping = quantityOfFood(numberTopping);

                    System.out.println();

                    String[] arrTopping = new String[numberTopping];

                    for (int j = 0; j < numberTopping; j++) {

                        System.out.print("Enter topping " + (j + 1) + ":");
                        String topping = "";

                        // want to keep asking the user until they enter at least three character and no numbers
                        topping = moreThanTwoLetters(topping);
                        arrTopping[j] = topping;
                    }

                    // now that we have the size and toppings, we can create an instance of pizza
                    Pizza pizza = new Pizza(size, arrTopping);

                    // now add it to the array
                    order[i] = pizza;
                }

                // want to keep displaying the options until the user enter option 2 to complete their order
                do {
                    System.out.println("\n1. View your Order" + "\n2. Complete your order");

                    int option2 = -1;

                    // want to keep asking the user until they enter a valid number of option (1 or 2)
                    option2 = optionInput(option2);

                    if (option2 == 1) {
                        // display the order
                        String display = "\nHere is your order:\n\nName: %s\nPhone: %s\n\nThere are %d pizza(s) in your order.\n";
                        System.out.printf(display, name, phoneNumber, numberPizza);

                        for (int i = 0; i < numberPizza; i++) {
                            // display the pizza with the right size and toppings
                            String format = "\n%s pizza with %d topping(s)\n";
                            System.out.printf(format, order[i].getSizeString(), order[i].getToppings().length);

                            for (String topping : order[i].getToppings()) {
                                String format2 = " - %s\n";
                                System.out.printf(format2, topping);
                            }
                        }

                    } else {
                        break;
                    }

                } while (true);

                // display the result
                // randomize the number of minutes between 10 and 30
                int time = (int) (Math.random() * 21) + 10;
                System.out.printf("\nHi %s, your order of %d pizza(s) will be ready for pickup in %d minutes. Thank you and have a nice day!\n\n", name, numberPizza, time);

            } else {
                // exit the application
                System.exit(0);
            }
        } while (true);
    }
}
