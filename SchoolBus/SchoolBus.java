package SchoolBus;

import java.util.List;

public class SchoolBus {

    private Person driver;
    private List<Child> children;

    public SchoolBus(Person driver, List<Child> children){
        this.driver = driver;
        this.children = children;
    }

    public SchoolBus(BusDriver driver){
        this.driver = driver;
    }

    public SchoolBus(BusDriver driver, List<Child> children){
        this.driver = driver;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(BusDriver driver) {
        this.driver = driver;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString(){
        String returnString = this.driver.toString();
        for(Child element:children){
            returnString += element.toString() + "\n";
        }
        return returnString;
    }
}
