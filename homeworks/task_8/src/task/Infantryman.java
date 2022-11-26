package task;

public class Infantryman extends BattleUnitBase {
    //constructor
    //------------------------------------------------------------
    
    public Infantryman(String name, int maxHealth, int baseStrength, int maxArmor){
        super(name, maxHealth, baseStrength, maxArmor);
    }

    //methods
    //------------------------------------------------------------

    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){}

    @Override
    public void attack(BattleUnit enemy){
        double halfDamage = this.str/2 < 1 ? 1 : this.str/2;
        double quarterDamage = this.str/4 < 1 ? 1 : this.str/4;

        if(enemy.armor() == 0)
            enemy.takeDamage(this.str);
        else {
            enemy.takeDamage((int) halfDamage);
            enemy.damageArmor((int) quarterDamage);
        }
    }
}
