package sbu.cs.playerClasses;

import sbu.cs.GameObject;
import sbu.cs.Player;

public class Assassin extends Player
{
    private int criticalMultuplayer = 3;
    private boolean isInvisible = true;
    public Assassin(String playerName)
    {
        super(playerName);
    }

    public void attack(GameObject target)
    {
        if(isInvisible)
        {
            isInvisible = false;
            target.takeDamage(attackPower * criticalMultuplayer);
            return;
        }
        target.takeDamage(attackPower);
    }

}
