package SchoolBus;

public class Child extends Person{

    private Lunch lunch;

    private double money = 0.00;

    public Child(String name, Lunch lunch){
        super();
        this.name = name;
        this.lunch = lunch;
    }

    public Child(String name, double money){
        super();
        this.name = name;
        this.money = money;
    }

    public Lunch getLunch() {
        return lunch;
    }

    public void setLunch(Lunch lunch) {
        this.lunch = lunch;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString(){
        String returnString = "";
        returnString += super.toString();
        returnString += "Person Type: Child\n";
        if(this.lunch != null){
            returnString += this.lunch.toString();
        } else {
            returnString += super.toString();
            returnString += "Lunch Money: " + this.money + "\n";
        }
        return returnString;
    }
}
