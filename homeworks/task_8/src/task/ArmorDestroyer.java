package task;

public class ArmorDestroyer extends BattleUnitBase {
    //constructor
    //------------------------------------------------------------
    
    public ArmorDestroyer(String name, int maxHealth, int baseStrength, int maxArmor){
        super(name, maxHealth, baseStrength, maxArmor);
    }

    //methods
    //------------------------------------------------------------

    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){
        int selectEnemy = 0, maxArmor = 0; //base "max"-armor enemy
        for(int i = 0; i < enemyTeam.length; i++){
            BattleUnit enemy = enemyTeam[i];
            if(enemy.health() > 0 && enemy.armor() > maxArmor){
                selectEnemy = i;
                maxArmor = enemy.armor();
            }
        }
        double doubleDamage = this.str*2 < 1 ? 1 : this.str*2, quarterDamage = this.str/4 < 1 ? 1 : this.str/4;
        if(maxArmor > 0)
            enemyTeam[selectEnemy].damageArmor((int) doubleDamage);
        else
            enemyTeam[selectEnemy].takeDamage((int) quarterDamage);
    }

    @Override
    public void attack(BattleUnit enemy){
        double halfDamage = this.str/2 < 1 ? 1 : this.str/2, quarterDamage = this.str/4 < 1 ? 1 : this.str/4;
        if(enemy.armor() > 0){
            enemy.takeDamage((int) quarterDamage);
            enemy.damageArmor(this.str);
        } else 
            enemy.takeDamage((int) halfDamage);
    }
}
