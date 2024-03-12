package sbu.cs.playerClasses;

import sbu.cs.GameObject;
import sbu.cs.Monster;
import sbu.cs.Player;

public class Assassin extends Player{
    private int criticalMultuplayer = 3;
    private boolean isInvisible = true;
    //-----------------------------------------------------------------------------
    // constructor
    public Assassin(String playerName)
    {
        super(playerName);
    }
    //-----------------------------------------------------------------------------
    public void attack(GameObject target){
        if(isInvisible){
            System.out.println(playerName + " WAS HIDDEN AND ATTACKED " + ((Monster) target).name);
            isInvisible = false;
            target.takeDamage(attackPower * criticalMultuplayer);
            return;
        }
        System.out.println(playerName + " ATTACKED " + ((Monster) target).name);
        target.takeDamage(attackPower);
    }
    //-----------------------------------------------------------------------------
}
