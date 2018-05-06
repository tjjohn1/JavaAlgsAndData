package SchoolBus;

public abstract class Person {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        String returnString = "Name: " + name + "\n";
        return returnString;
    }

}
