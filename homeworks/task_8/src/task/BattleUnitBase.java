package task;

public abstract class BattleUnitBase implements BattleUnit {
    //fields
    //------------------------------------------------------------

    public int health, str, armor, maxHealth, maxArmor, baseStr; 
    public String name;

    //constructor
    //------------------------------------------------------------

    public BattleUnitBase(String name, int maxHealth, int baseStr, int maxArmor){
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth();
        this.baseStr = baseStr;
        this.str = baseStrength();
        this.maxArmor = maxArmor;
        this.armor = maxArmor();
    }

    //abstract methods
    //------------------------------------------------------------

    public abstract void specialAbility(BattleUnit[] ownTeam, BattleUnit[] enemyTeam);
    public abstract void attack(BattleUnit other);

    //methods
    //------------------------------------------------------------

    @Override // <-- this is for "reading" abstract methods from interface;
    public String name(){
        return this.name;
    }

    @Override
    public int health(){
        return this.health;
    }

    @Override
    public int maxHealth(){
        return this.maxHealth;
    }

    @Override
    public void setMaxHealth(int value){
        this.maxHealth = value;
        this.health = this.health > this.maxHealth ? this.maxHealth : this.health; // <- termary operator 
    }

    @Override
    public void heal(int value){
        this.health = this.health + value > this.maxHealth ? this.maxHealth : this.health + value;
    }

    @Override
    public void takeDamage(int value){
        this.health = this.health - value < 0 ? 0 : this.health - value;
    }

    @Override
    public int strength(){
        return this.str;
    }

    @Override
    public void setStrength(int value){
        this.str = value;
    }

    @Override
    public int baseStrength(){
        return this.baseStr;
    }

    @Override
    public int armor(){
        return this.armor;
    }

    @Override
    public void restoreArmor(int value){
        this.armor = this.armor + value > maxArmor ? maxArmor : this.armor + value;
    }

    @Override
    public void damageArmor(int value){
        this.armor = this.armor - value < 0 ? 0 : this.armor - value;
    }

    @Override
    public int maxArmor(){
        return this.maxArmor;
    }

    @Override
    public void setMaxArmor(int value){
        this.maxArmor = value;
        this.armor = this.armor > this.maxArmor ? this.maxArmor : this.armor;
    }
}
