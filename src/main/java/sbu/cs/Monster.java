package sbu.cs;

public abstract class Monster implements GameObject
{
    protected String name;
    protected int health;
    protected int attackPower;

    public Monster()
    {

    }

    public void attack(GameObject target)
    {
        target.takeDamage(attackPower);
    }

    public void takeDamage(int damage)
    {
        health -= damage;
        if(health <= 0)
        {
            health = 0;
            die();
        }
    }

    public void die()
    {
        System.out.println(name  + " DIED");
    }

}
