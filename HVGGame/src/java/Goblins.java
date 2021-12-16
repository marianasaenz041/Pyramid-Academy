
public class Goblins extends Players {

    public Goblins() {
        this.setHealth((int)Math.floor(Math.random()*(100-50+1)+50));
        this.setStrength((int)Math.floor(Math.random()*(50-10+1)+10));
        this.position = new int[]{4, 4};
        this.nextPosition = new int[]{this.getPosition()[0], this.getPosition()[1]};
    }

}
