package sbu.cs;
import static sbu.cs.App.*;


public abstract class Player implements GameObject{
    public int health;
    protected boolean isAlive ;
    protected int attackPower;
    public String playerName;
    //-----------------------------------------------------------------------------
    // constructor
    public Player(String playerName){
        isAlive = true;
        health = 100;
        this.playerName = playerName;
        attackPower = 10;
    }
    //-----------------------------------------------------------------------------
    public void attack(GameObject target){
        printGreen(playerName + " attacked " + ((Monster)target).name + "! ");
        target.takeDamage(attackPower);
    }
    //-----------------------------------------------------------------------------
    public void takeDamage(int damage){
        printRed(playerName + " Took " + damage + " Damage!");
        health -= damage;
        if(health <= 0){
            health = 0;
            die();
            return;
        }
        printRed(playerName + " health is " + health);
    }
    //-----------------------------------------------------------------------------
    public void die(){
        isAlive = false;
        printRed(playerName + " DIED");
        // System.out.println(playerName + " DIED");
    }
    //-----------------------------------------------------------------------------
}
