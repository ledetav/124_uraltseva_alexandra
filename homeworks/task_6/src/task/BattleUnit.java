package task;

public class BattleUnit {

    //fields
    private int strenght, armor, health, x, y;

    //constructor
    public BattleUnit(int strenght, int armor, int health, int x, int y){
        this.strenght = strenght;
        this.armor = armor;
        this.health = health;
        this.x = x;
        this.y = y;
    }

    //methods
    public int getStrength(){
        return strenght;
    }
    public int getArmor(){
        return armor;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getHealth(){
        return health;
    }

    public void attacked(BattleUnit enemy){
        if(armor > 0)
            if(enemy.strenght >= armor)
                health -= (enemy.strenght - armor);
            else
                health -= 0;
        else
            health -= enemy.strenght;
    }

    public void moveUp(){
        y--;
    }
    public void moveDown(){
        y++;
    }
    public void moveLeft(){
        x--;
    }
    public void moveRight(){
        x++;
    }

    public boolean isAlive(){
        return health > 0;
    }
}
