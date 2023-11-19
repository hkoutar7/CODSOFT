package Model;
import Exception.*;

public class User {

    private int id;
    private String firstName;
    private  String lastName;
    private ATM atm;

    public User() {
    }

    public User(int id, String firstName, String lastName, ATM atm) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.atm = atm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public ATM getAtm() {
        return atm;
    }

    public void setAtm(ATM atm) {
        this.atm = atm;
    }

    public void withDrawMoney (float money){

        try {
            float result = (float) (this.atm.getAmount() - money);
            if (money < 0)
                throw new InvalidTransaction("please enter a valid some of money ");
            if (result < 0)
                throw new InvalidTransaction("The amount you wanna withdraw is less than yours by "+ (-result));
            this.atm.withDraw(money);
            System.out.println("SUCCESS you have been withdrawing " + money  + " in your account .");
        }catch (InvalidTransaction e){
            System.out.println("FAILURE " + e.getMessage());
        }catch (InvalidInput e){
            System.out.println("FAILURE " + e.getMessage());
        }catch (Exception e){
            System.out.println("FAILURE " + e.getMessage());
        }
    }

    public void depositMoney (float money){

        try {
            if (money < 0)
                throw new InvalidTransaction("please enter a valid some of money ");
            this.atm.deposit(money);
            System.out.println("SUCCESS , you've been successfully depoisting " + money + " in your account .");
        }catch (InvalidTransaction e){
            System.out.println("FAILURE " + e.getMessage());
        } catch (Exception e){
            System.out.println("FAILURE " + e.getMessage());
        }
    }

    public void checkAccount(){
        this.atm.checkBalance();
    }

}
