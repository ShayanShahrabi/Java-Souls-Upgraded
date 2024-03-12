package sbu.cs;
import static sbu.cs.App.*;

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
        printRed(name + " ATTACKED " + ((Player)target).playerName);
        target.takeDamage(attackPower);
    }
    //-----------------------------------------------------------------------------
    public void takeDamage(int damage){
        printGreen(name + " TOOK " + damage + " DAMAGE!");
        health -= damage;
        if(health <= 0){
            health = 0;
            die();
            return;
        }
        printGreen(name + " HEALTH IS " + health);
    }
    //-----------------------------------------------------------------------------
    public void die(){
        isAlive = false;
        printGreen(name  + " DIED");
    }
    //-----------------------------------------------------------------------------
}
