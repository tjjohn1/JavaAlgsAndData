package SchoolBus;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[]args) {
        Person driver = new BusDriver("Dan Driver");
        Child child1 = new Child("Child 1", 7.50);
        String[] contents2 = new String[]{"Juice", "Sandwich", "Chips"};
        Child child2 = new Child("Child 2", new BoxLunch(contents2));
        String[] contents3 = new String[]{"Water", "Sandwich", "Cookie"};
        Child child3 = new Child("Child 3", new SackLunch(contents3));
        List<Child> children = new ArrayList<Child>();
        children.add(child1);
        children.add(child2);
        children.add(child3);
        SchoolBus bus = new SchoolBus(driver, children);
        System.out.println(bus.toString());
    }
}
