package sbu.cs;

public interface GameObject {
    //-----------------------------------------------------------------------------
    // constructor
    void attack(GameObject target);
    //-----------------------------------------------------------------------------
    void takeDamage(int damage);
    //-----------------------------------------------------------------------------
    void die();
    //-----------------------------------------------------------------------------
}
