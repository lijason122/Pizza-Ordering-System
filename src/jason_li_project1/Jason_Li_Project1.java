package jason_li_project1;

import jason_li_project1.model.OrderingMethods;
import jason_li_project1.model.Pizza;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * This class creates and displays the order of pizza
 *
 * @author Jason Li
 */
public class Jason_Li_Project1 {

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
            option = OrderingMethods.optionInput(option);

            if (option == 1) {

                System.out.println("\nEnter your name:");

                String name = "";
                // want to keep asking the user until they enter at least three character and no numbers
                name = OrderingMethods.moreThanTwoLetters(name);

                System.out.println("Enter your phone number:");

                String phoneNumber = "";
                // want to keep asking the user until they enter a valid phone number
                phoneNumber = OrderingMethods.checkPhoneNumber(phoneNumber);

                System.out.println("\nHow many pizza(s) will you be ordering?");

                int numberPizza = -1;

                // want to keep asking the user until they enter a valid number of pizzas
                numberPizza = OrderingMethods.quantityOfFood(numberPizza);

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
                    numberTopping = OrderingMethods.quantityOfFood(numberTopping);

                    System.out.println();

                    String[] arrTopping = new String[numberTopping];

                    for (int j = 0; j < numberTopping; j++) {

                        System.out.print("Enter topping " + (j + 1) + ":");
                        String topping = "";

                        // want to keep asking the user until they enter at least three character and no numbers
                        topping = OrderingMethods.moreThanTwoLetters(topping);
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
                    option2 = OrderingMethods.optionInput(option2);

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
