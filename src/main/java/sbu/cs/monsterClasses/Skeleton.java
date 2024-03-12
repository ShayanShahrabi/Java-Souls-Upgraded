package sbu.cs.monsterClasses;

import sbu.cs.Monster;

public class Skeleton extends Monster{
    int baseHealth;
    int deathCount;
    //-----------------------------------------------------------------------------
    // constructor
    public Skeleton(String name){
        super(name);
        deathCount = 0;
        baseHealth = 100;
    }
    //-----------------------------------------------------------------------------
    public void takeDamage(int damage){
        System.out.println(name + " TOOK " + damage + " DAMAGE!");
        health -= damage;
        if(health <= 0){
            deathCount++;
            if(deathCount < 2){
                health = baseHealth;
                System.out.println(name + " DIED, BUT CAME BACK!");
                return;
            }
            health = 0;
            die();
            return;
        }
        System.out.println(name + "HEALTH IS " + health);
    }
    //-----------------------------------------------------------------------------
}
