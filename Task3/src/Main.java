import Model.*;

import java.util.Scanner;
import Exception.*;

public class Main {

    public static void main(String []argv){

        String firstName = "";
        String lastName = "";
        int response = 0;
        float amount = 0.0F;

        User user1 = new User(1,"" , "", new ATM(1, 0F));

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter youre fullName ");
            firstName = scanner.next();
            lastName = scanner.next();

            user1.setFirstName(firstName);
            user1.setLastName(lastName);

            displayMenue(user1);

            while (true) {
                System.out.print("enter your operation : ");
                response = scanner.nextInt();

                try {
                    if (response <= 0 || response >= 5)
                        throw new InvalidInput("enter a valid option ");
                }catch (InvalidInput e){
                    System.out.println(e.getMessage());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }

               choice(scanner, amount, user1, response);
            }
        }

    }

    public  static void displayMenue (User user1){
        System.out.println("--------- Welcome " + user1.getFirstName().concat(" ").concat(user1.getLastName()) + " to your bank Account services ---------\n- 1) check your balance\n- 2) Deposit your money\n- 3) Withdraw your money\n- 4) Quit the program");
    }

    public static void endProgram() {
        System.out.println("------ The Program Ended ------ ");
        System.exit(0);
    }

    public static void choice (Scanner scanner, float amount, User user1,  int respone){
        switch (respone) {
            case 1:
                user1.checkAccount();
                break;
            case 2:
                System.out.print("enter your money that you wanna deposit : ");
                amount = scanner.nextFloat();
                user1.depositMoney(amount);
                break;
            case 3:
                System.out.print("enter your money that you wanna withdraw : ");
                amount = scanner.nextFloat();
                user1.withDrawMoney(amount);
                break;
            default:
                endProgram();
                break;
        }
    }



}