package SchoolBus;

public class SackLunch extends Lunch{

    public SackLunch(String[] contents){
        super();
        this.contents = contents;
    }

    @Override
    public String toString(){
        String returnString = "Lunch type: Sack Lunch\n";
        returnString += super.toString();
        return returnString;
    }
}
