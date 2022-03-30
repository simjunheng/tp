package seedu.address.model.strategy;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

public class Player {
    private static final int DEF_XCOORD = 50;
    private static final int DEF_YCOORD = 50;

    private final String name;
    private int xCoord;
    private int yCoord;

    /**
     * Creates a new player without specifying the coordinates
     */
    public Player(String name) {
        requireNonNull(name);
        this.name = name;
        this.xCoord = DEF_XCOORD;
        this.yCoord = DEF_YCOORD;
    }

    /**
     * Creates a new player with specified coordinates
     */
    public Player(String name, int xCoord, int yCoord) {
        this.name = name;
        this.xCoord = xCoord;
        this.yCoord = yCoord;
    }

    //Getters
    public String getName() {
        return name;
    }

    public int getXCoord() {
        return xCoord;
    }

    public int getYCoord() {
        return yCoord;
    }

    //Setters
    public void setXCoord(int xCoord) {
        this.xCoord = xCoord;
    }

    public void setYCoord(int yCoord) {
        this.yCoord = yCoord;
    }

    //uti methods
    public Player toCopy() {
        return new Player(name, xCoord, yCoord);
    }

    /**
     * Returns true if both players have the same name
     * This defines a stronger notion of equality between two tasks.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Player)) {
            return false;
        }

        Player otherPlayer = (Player) other;
        return otherPlayer.getName().equals(getName());
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(name, xCoord, yCoord);
    }
}
