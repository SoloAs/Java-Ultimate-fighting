package sample.other;

import sample.enums.AttackResult;
import sample.model.action.Attack;

/**
 * Created by Alexander on 10/14/2014.
 *
 * Class for visualising move consiquences
 */
public class MoveResult {

    public MoveResult()
    {
        this.attackResult = AttackResult.Missed;
        this.damage = -1;
        this.stunned = false;
        this.name = "";
    }

    public MoveResult(AttackResult attackResult, boolean stunned, int damage, String name)
    {
        this.attackResult = attackResult;
        this.damage = damage;
        this.stunned = stunned;
        this.name = name;
    }


    private String name;
    public String getName()
    {
        return name;
    }


    private int damage;
    public int getDamage()
    {
        return damage;
    }
    public void setDamage(int damage) { this.damage = damage; }

    private boolean stunned;
    public boolean getStunned()
    {
        return stunned;
    }

    private AttackResult attackResult;
    public AttackResult getAttackResult()
    {
        return attackResult;
    }

}
