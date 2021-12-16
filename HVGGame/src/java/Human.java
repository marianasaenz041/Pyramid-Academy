public class Human extends Players {

    public Human() {

        this.setHealth(100);
        this.position = new int[]{0, 0};
        this.nextPosition = new int[]{this.getPosition()[0], this.getPosition()[1]};
    }

    public boolean isDead(boolean b){
        if(b && this.getHealth() <= 0){
            System.out.println("You died in combat");
        }
        return this.getHealth() <= 0;
    }
}
