package sbu.cs.monsterClasses;

import sbu.cs.GameObject;
import sbu.cs.Monster;
import sbu.cs.Player;

public class Dragon extends Monster
{
    int fireDamage;

    public Dragon(String name)
    {
        super(name);
        fireDamage = 20;
    }

    @Override
    public void attack(GameObject target)
    {
        System.out.println(name + " FIRED " + ((Player) target).playerName);
        target.takeDamage(fireDamage);
    }


}

