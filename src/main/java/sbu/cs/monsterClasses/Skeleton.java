package sbu.cs.monsterClasses;

import sbu.cs.Monster;

public class Skeleton extends Monster
{
    int baseHealth;
    int deathCount;
    public Skeleton(String name) {

        super(name);
        deathCount = 0;
        baseHealth = 100;
    }

    public void takeDamage(int damage)
    {
        System.out.println(name + " Took " + damage + " Damage!");
        health -= damage;
        if(health <= 0)
        {
            deathCount++;
            if(deathCount < 2)
            {
                health = baseHealth;
                System.out.println(name + " died, but CAME BACK!");
                return;
            }

            health = 0;
            die();
            return;
        }
        System.out.println(name + " health is " + health);
    }
}
