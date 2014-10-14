package sample.model;

import sample.enums.Status;
import sample.model.action.Move;

/**
 * Created by Alexander on 10/13/2014.
 */
public class Player {
    public Player()
    {
        hp = 100;
        status = Status.Active;
        name = "none";
    }

    public Player(String name)
    {
        hp = 100;
        status = Status.Active;
        this.name = name;
    }


    private String name;
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    private int hp;
    public int getHp()
    {
        return hp;
    }
    public void setHp(int hp)
    {
        this.hp = hp;
    }
    public void changeHp(int dhp)
    {
        this.hp += dhp;
    }

    private Status status;
    public Status getStatus()
    {
        return status;
    }
    public void setStatus(Status status)
    {
        this.status = status;
    }

    private Move currentMove;
    public Move getMove()
    {
        return currentMove;
    }
    public void setMove(Move move)
    {
        this.currentMove = move;
    }



}
