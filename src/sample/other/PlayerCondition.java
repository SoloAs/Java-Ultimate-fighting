package sample.other;

import sample.enums.Status;
import sample.model.Player;

/**
 * Created by Alexander on 10/14/2014.
 *
 * Class for visualising player condition
 */
public class PlayerCondition {
    public PlayerCondition(Player player)
    {
        name = player.getName();
        hp = player.getHp();
        status = player.getStatus();
    }

    private String name;
    public String getName()
    {
        return name;
    }

    private int hp;
    public int getHp()
    {
        return hp;
    }

    private Status status;
    public Status getStatus() {
        return status;
    }
}
