package SchoolBus;

public class BusDriver extends Person{

    public BusDriver(String name){
        super();
        this.name = name;
    }

    @Override
    public String toString(){
        String returnString = super.toString();
        returnString += "Person Type: Bus Driver\n";
        returnString += " \n";
        return returnString;
    }

}
