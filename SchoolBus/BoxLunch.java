package SchoolBus;

public class BoxLunch extends Lunch{

    public BoxLunch(String[] contents){
        super();
        this.contents = contents;
    }

    @Override
    public String toString(){
        String returnString = "Lunch type: Box Lunch\n";
        returnString += super.toString();
        return returnString;
    }
}
