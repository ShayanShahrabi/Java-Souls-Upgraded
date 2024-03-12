package sbu.cs.monsterClasses;

import sbu.cs.GameObject;
import sbu.cs.Monster;

public class Dragon extends Monster
{
    int fireDamage;

    public Dragon()
    {

        fireDamage = 20;
    }

    @Override
    public void attack(GameObject target)
    {
        target.takeDamage(fireDamage);
    }


}

