package sbu.cs.playerClasses;

import sbu.cs.Player;

public class Knight extends Player
{
    private boolean isBlocking;
    private int armorStrength = 10;
    public Knight(String playerName) {
        super(playerName);
    }

    @Override
    public void takeDamage(int damage)
    {
        if(isBlocking) { damage /= 2;}
        if(armorStrength >= damage)
        {
            armorStrength -= damage;
            damage = 0;
        }
        else
        {
            damage -= armorStrength;
            armorStrength = 0;
        }


        System.out.println(playerName + " Took " + damage + " Damage!");
        health -= damage;
        if(health <= 0)
        {
            health = 0;
            die();
            return;
        }
        System.out.println(playerName + " health is " + health);
    }

}
