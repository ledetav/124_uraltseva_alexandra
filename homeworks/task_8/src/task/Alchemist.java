package task;

public class Alchemist extends BattleUnitBase {
    //constructor
    //------------------------------------------------------------
    
    public Alchemist(String name, int maxHealth, int baseStrength, int maxArmor){
        super(name, maxHealth, baseStrength, maxArmor);
    }

    //methods
    //------------------------------------------------------------

    @Override
    public void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam){
        int selectMinOwn = 0, minHealth = Integer.MAX_VALUE; //base "min"-health own
        int selectMaxOwn = 0, maxHealth = Integer.MIN_VALUE; //base "max"-health own
        for(int i = 0; i < ownTeam.length; i++){
            BattleUnit own = ownTeam[i];
            if(own.health() > 0 && own.health() < minHealth){
                selectMinOwn = i;
                minHealth = own.health();
            }
            if(own.health() > maxHealth){
                selectMaxOwn = i;
                maxHealth = own.health();
            }
        }
        ownTeam[selectMinOwn].heal(10);
        ownTeam[selectMaxOwn].setStrength(ownTeam[selectMaxOwn].strength()+1);
    }

    @Override
    public void attack(BattleUnit enemy){
        enemy.setStrength(enemy.strength()-2);
        enemy.setMaxHealth(enemy.maxHealth()-4);
    }
}
