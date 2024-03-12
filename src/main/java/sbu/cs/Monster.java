package sbu.cs;

public abstract class Monster implements GameObject
{
    public String name;
    protected int health;
    protected int attackPower;
    protected  boolean isAlive;

    public Monster(String name)
    {
        this.name = name;
        attackPower = 10;
        health = 100;
        isAlive = true;
    }

    public void attack(GameObject target)
    {
        System.out.println(name + " attacked " + ((Player)target).playerName);
        target.takeDamage(attackPower);
    }

    public void takeDamage(int damage)
    {
        System.out.println(name + " Took " + damage + " Damage!");
        health -= damage;
        if(health <= 0)
        {
            health = 0;
            die();
            return;
        }
        System.out.println(name + " health is " + health);
    }

    public void die()
    {
        isAlive = false;
        System.out.println(name  + " DIED");
    }
}
