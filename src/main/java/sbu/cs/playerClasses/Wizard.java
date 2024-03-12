package sbu.cs.playerClasses;

import sbu.cs.GameObject;
import sbu.cs.Monster;
import sbu.cs.Player;

// Implementing this class is optional
public class Wizard extends Player
{
    private int mana = 100;
    private int healingSpellPower = 10;
    private int damageSpellPower = 20;
    private int damageSpellCost = 10;
    private int healSpellCost = 20;

    @Override
    public void attack(GameObject target)
    {
        if(mana <= 0) {
            System.out.println("Wizard does not have enough mana! ");
        }
        System.out.println(playerName  + " SPELLED " + ((Monster) target).name);
        mana -= damageSpellCost;
        target.takeDamage(damageSpellPower);
    }
    public void heal(Player player)
    {
        if(mana <= 0)
        {
            System.out.println("Wizard does not have enough mana! ");
        }

        player.health += healingSpellPower;
        System.out.println(playerName  + " HEALED " + player.playerName + " (Current Health: " + player.health + ")");
        mana -= damageSpellCost;
    }

    public Wizard(String playerName) {
        super(playerName);
    }
}
