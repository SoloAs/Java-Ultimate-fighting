package sample.Model;

import sample.Enums.Status;

/**
 * Created by Alexander on 10/13/2014.
 */
public class Player {
    public Player()
    {
        hp = 100;
        status = Status.Active;
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

}
