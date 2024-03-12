package sbu.cs;

public abstract class Player implements GameObject
{
    protected int health;
    protected int attackPower;
    protected boolean isAlive;
    protected String playerName;

    public Player(String playerName)
    {
        isAlive = true;
        health = 100;
        this.playerName = playerName;
        attackPower = 10;
    }

    public void attack(GameObject target)
    {
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
        System.out.println(playerName + " DIED");
    }


}
