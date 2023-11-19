package Model;

public class ATM {

    private int id;
    private float amount;

    public ATM(int id, float amount) {
        this.id = id;
        this.amount = amount;
    }

    public ATM() {
        this.id = 0;
        this.amount = 0.0F;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "The amount of the account is : " + amount + " .";
    }

    public void withDraw(float amount){
        this.amount -= amount;
    }

    public void deposit(float amount){
        this.amount += amount;
    }

    public void checkBalance(){
        System.out.println(this.toString());
    }

}
