package sample.model.action;

import sample.Consts;
import sample.enums.Target;
import sample.enums.AttackType;


/**
 * Created by Alexander on 10/13/2014.
 */
public class Attack {

    public Attack(Attack attack)
    {
        stunChance = attack.stunChance;
        approximateDamage = attack.approximateDamage;
        missChance = attack.missChance;
        attackTarget = attack.attackTarget;
        attackType = attack.attackType;
    }

    public Attack(Target attackTarget, AttackType attackType)
    {
        this.attackTarget = attackTarget;
        this.attackType = attackType;
        this.approximateDamage = Consts.DAMAGE;
        this.stunChance = this.missChance = 0;


        switch (attackTarget) {
            case Head:
                approximateDamage *= 2;
                missChance += 50;
                break;
            case Body:
                break;
            case Legs:
                approximateDamage *= 0.6;
                stunChance += 20;
                break;
        }

        switch (attackType){
            case Berserk:
                approximateDamage *= 1.5;
                missChance += 25;
                break;
            case Normal:
                stunChance += 10;
                break;
            case Concentrated:
                approximateDamage *= 0.6;
                stunChance += 30;
                break;
        }



     }

    private int stunChance;
    public int getStunChance()
    {
        return stunChance;
    }
    public void setStunChance(int sc)
    {
        if(sc >= 0)
            stunChance = sc;
        else
            stunChance = 0;
    }


    private int approximateDamage;
    public int getApproximateDamage()
    {
        return approximateDamage;
    }
    public void setApproximateDamage(int ad)
    {
        if(ad >= 0)
            approximateDamage = ad;
        else
            approximateDamage = 0;
    }

    private int missChance;
    public int getMissChance()
    {
        return missChance;
    }
    public void setMissChance(int mc)
    {
        if(mc >= 0)
            missChance = mc;
        else
            missChance = 0;
    }


    private Target attackTarget;
    public Target getAttackTarget()
    {
        return attackTarget;
    }


    private AttackType attackType;
    public AttackType getAttackType()
    {
        return attackType;
    }

}
