package sbu.cs;

public abstract class Player implements GameObject
{
    public int health;
    protected boolean isAlive ;
    protected int attackPower;
    public String playerName;

    public Player(String playerName)
    {
        isAlive = true;
        health = 100;
        this.playerName = playerName;
        attackPower = 10;
    }

    public void attack(GameObject target)
    {
        System.out.println(playerName + " attacked " + ((Monster)target).name + "! ");
        target.takeDamage(attackPower);
    }

    public void takeDamage(int damage)
    {
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

    public void die()
    {
        isAlive = false;
        System.out.println(playerName + " DIED");
    }
}
