package sample.model.action;

/**
 * Created by Alexander on 10/13/2014.
 */
public class Move {

    public Move(Move move)
    {
        this.defense = move.defense;
        this.attack = move.attack;
    }
    public Move(Defense defense, Attack attack)
    {
        this.defense = defense;
        this.attack = attack;
      //  this.player = player;
    }

    private Defense defense;
    public Defense getDefense()
    {
        return defense;
    }
    public void setDefense(Defense dfs)
    {
        defense = dfs;
    }

    private Attack attack;
    public Attack getAttack()
    {
        return attack;
    }
    public void setAttack(Attack atk)
    {
        attack = atk;
    }

   // private int player;
   // public int getPlayer()
   // {
   //     return player;
   // }

}
