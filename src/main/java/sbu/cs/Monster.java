package sbu.cs;

public abstract class Monster implements GameObject {
    public String name;
    protected int health;
    protected int attackPower;
    protected  boolean isAlive;
    //-----------------------------------------------------------------------------
    // constructor
    public Monster(String name){
        this.name = name;
        attackPower = 10;
        health = 100;
        isAlive = true;
    }
    //-----------------------------------------------------------------------------
    public void attack(GameObject target){
        System.out.println(name + " ATTACKED " + ((Player)target).playerName);
        target.takeDamage(attackPower);
    }
    //-----------------------------------------------------------------------------
    public void takeDamage(int damage){
        System.out.println(name + " TOOK " + damage + " DAMAGE!");
        health -= damage;
        if(health <= 0)
        {
            health = 0;
            die();
            return;
        }
        System.out.println(name + " HEALTH IS " + health);
    }
    //-----------------------------------------------------------------------------
    public void die(){
        isAlive = false;
        System.out.println(name  + " DIED");
    }
    //-----------------------------------------------------------------------------
}
