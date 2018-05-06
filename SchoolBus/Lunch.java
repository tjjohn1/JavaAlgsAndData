package SchoolBus;

public abstract class Lunch {

    public String[] contents;

    public String[] getContents() {
        return contents;
    }

    public void setContents(String[] contents) {
        this.contents = contents;
    }

    @Override
    public String toString(){
        String returnString = "Lunch contents:\n";
        for(String element:this.contents){
            returnString += element + " ";
        }
        returnString += "\n";
        return returnString;
    }
}
