package sample.Model.Action;

import sample.Enums.Target;

/**
 * Created by Alexander on 10/13/2014.
 */
public class Defense {
    public Defense(Defense defense)
    {
        this.defenseTarget = defense.defenseTarget;
    }

    public Defense(Target defenseTarget)
    {
        this.defenseTarget = defenseTarget;
    }

    private Target defenseTarget;
    public Target getDefenseTarget()
    {
        return defenseTarget;
    }
}
