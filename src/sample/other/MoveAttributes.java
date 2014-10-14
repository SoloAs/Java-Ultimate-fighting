package sample.other;

import sample.enums.AttackType;
import sample.enums.Target;

/**
 * Created by Alexander on 10/14/2014.
 */
public class MoveAttributes {
    public MoveAttributes(MoveAttributes ma)
    {
        this.attackTarget = ma.attackTarget;
        this.attackType = ma.attackType;
        this.defenseTarget = ma.defenseTarget;
    }

    public MoveAttributes(Target attackTarget, AttackType attackType, Target defenseTarget)
    {
        this.attackTarget = attackTarget;
        this.attackType = attackType;
        this.defenseTarget = defenseTarget;
    }

    public MoveAttributes()
    {
        attackTarget = Target.Body;
        attackType = AttackType.Normal;
        defenseTarget = Target.Body;
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

    private Target defenseTarget;
    public Target getDefenseTarget()
    {
        return defenseTarget;
    }



}
