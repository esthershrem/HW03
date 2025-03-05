package HW03;

/**
 * Class to test Car and Bus implementations.
 * @version 1.0
 * @author Esther Shrem
 */
public class Driver {
    public static void main(String[] args) {
        // Create two Car objects
        Car car1 = new Car("Car1", 50, 300);
        Car car2 = new Car("Car2");

        // Use addPassengers on car1
        String[] passengers = {"Alice", "Bob"};
        car1.addPassengers(100, passengers);

        // Print car1 and car2 details
        System.out.println(car1);
        System.out.println(car2);

        // Check if car1 and car2 are equal
        System.out.println("Are car1 and car2 equal? " + car1.equals(car2));

        // Create two Bus objects
        Bus bus1 = new Bus("Bus1", 100, "Midtown", 3);
        Bus bus2 = new Bus("Bus2", "Georgia Tech");

        // Use addPassengers on bus1
        String[] busPassengers = {"Charlie", "Dave"};
        bus1.addPassengers(50, busPassengers);

        // Print bus1 and bus2 details
        System.out.println(bus1);
        System.out.println(bus2);

        // Check if bus1 and bus2 are equal
        System.out.println("Are bus1 and bus2 equal? " + bus1.equals(bus2));
    }
}