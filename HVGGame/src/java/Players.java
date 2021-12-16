import java.util.Arrays;

public class Players {
    public int[] position = new int[]{0,0};
    public int[] nextPosition = new int[]{0,0};
    private int health;

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    private int strength;


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }


    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] position) {
        this.position = position;
    }



    public int[] getNextPosition() {
        return nextPosition;
    }

    public void setNextPosition(int[] nextPosition) {
        this.nextPosition = nextPosition;
    }

    @Override
    public String toString() {
        return "Players{" +
                "position=" + Arrays.toString(position) +
                ", nextPosition=" + Arrays.toString(nextPosition) +
                '}';
    }
}
