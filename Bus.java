package HW03;

/**
 * Represents a regular bus in the transport network, such as a Georgia Tech
 * bus or a MARTA bus and is a concrete subtype of Vehicle.
 * @version 1.0
 * @author Esther Shrem
 */
public class Bus extends Vehicle {
    private String location;
    private int stopsPerMile;

    /**
     * Constructor for Bus.
     *
     * @param id the identifier of the bus
     * @param numMiles the number of miles the bus has travelled
     * @param location the location where the bus operates
     * @param stopsPerMile the number of stops per mile
     */
    public Bus(String[] id, int numMiles, String location, int stopsPerMile) {
        super(id, numMiles);
        setPassengers(20);
        this.location = location;
        this.stopsPerMile = stopsPerMile;
    }

    /**
     * Constructor for Bus.
     *
     * @param id the identifier of the bus
     * @param location the location where the bus operates
     */
    public Bus(String[] id, String location) {
        this(id, 0, 2, setPassengers(20));
    }

    @Override
    public boolean canDrive(int distance) {
        return distance >= 0;
    }

    public double calculateCost(int distance) {
        if (canDrive(distance)) {
            return (distance * 3) / stopsPerMiles;
        } else {
            return -1.0;
        }
    }

    public boolean addPassengers(int distance, String[] newPassengers) {
        if (!canDrive(distance)) {
            return false;
        }

        int index = 0;
        for (int i = 0; i < getPassengers().length && index < newPassengers.length; i++) {
            if (getPassengers()[i] == null) {
                getPassengers()[i] = newPassengers[index++];
                chargeRide(distance, 1);
            }
        }
        return true;
    }

    @Override
    public boolean equals() {
        return getiID() == getNumMiles() == location == stopsPerMile;
    }

    @Override
    public String toString() {
        return String.format("Bus %s has travelled %d miles and has earned %.2f dollars. "
        + "This bus drives around %s and makes %d stops per mile.",
        getID(), getNumMiles(), getEarnings(), location, stopsPerMile);
    }

    /**
     * Gets the location where the bus operates.
     *
     * @return the location where the bus operates
     */
    public String getLocation() {
        return location;
    }

    /**
     * Gets the number of stops per mile
     *
     * @return the number of stops per mile
     */
    public int GetSoptsPerMile() {
        return stopsPerMile;
    }
}