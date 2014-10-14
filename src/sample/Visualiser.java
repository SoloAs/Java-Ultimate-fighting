package sample;

import sample.enums.AttackType;
import sample.enums.Status;
import sample.enums.Target;
import sample.model.Game;
import sample.model.Player;
import sample.model.action.Attack;
import sample.other.MoveAttributes;
import sample.other.PlayerCondition;

import java.util.Scanner;

/**
 * Created by Alexander on 10/13/2014.
 */
public class Visualiser {
    //region Singleton
    Scanner in = new Scanner(System.in);

    private Visualiser(){
    }
    private static Visualiser gameSingleton;
    public static Visualiser getVisualiser()
    {
        if (gameSingleton == null)
            gameSingleton = new Visualiser();
        return gameSingleton;
    }
    //endregion
    private final String helloMsg = "Blah blah blah.  Enter start to begin                              ";
    public void sayHello()
    {
        String answer = "";
        System.out.println(helloMsg);
        while(answer != "start")
        in.next(answer);
    }

    public String[] getNames()
    {
        String[] names = new String[2];
        names[0] = names[1] = "";
        System.out.println("Set name of the first player");
        in.next(names[0]);

        System.out.println("Set name of the second player");
        in.next(names[1]);

        //Game.getGame().getPlayers()[0].getMove().setAttack(new Attack(Target.Head, AttackType.Berserk));

        return names;
    }


    public void writeWinner(String name)
    {
        System.out.println("Winner is " + name);
    }

    public MoveAttributes getMove()
    {
        if (Game.getGame().getPlayers()[Game.getGame().getCurrentPlayer()].getStatus() != Status.Stunned) {
            String temp = "";
            Target attackTarget = Target.Body;
            Target defenseTarget = Target.Body;
            AttackType attackType = AttackType.Normal;

            System.out.println("Set an attack target");
            while (!temp.matches("Head|HEAD|head|body|BODY|Body|Legs|LEGS|legs"))
                in.next(temp);
            switch (temp.toLowerCase().charAt(0)) {
                case 'h':
                    attackTarget = Target.Head;
                    break;
                case 'b':
                    attackTarget = Target.Body;
                    break;
                case 'l':
                    attackTarget = Target.Legs;
                    break;
            }

            System.out.println("Set an attack type");
            while (!temp.matches("Berserk|BERSERK|berserk|Normal|NORMAL|normal|Concentrated|CONCENTRATED|concentrated"))
                in.next(temp);
            switch (temp.toLowerCase().charAt(0)) {
                case 'b':
                    attackType = AttackType.Berserk;
                    break;
                case 'n':
                    attackType = AttackType.Normal;
                    break;
                case 'c':
                    attackType = AttackType.Concentrated;
                    break;
            }

            System.out.println("Set a defense target");
            while (!temp.matches("Head|HEAD|head|body|BODY|Body|Legs|LEGS|legs"))
                in.next(temp);
            switch (temp.toLowerCase().charAt(0)) {
                case 'h':
                    defenseTarget = Target.Head;
                    break;
                case 'b':
                    defenseTarget = Target.Body;
                    break;
                case 'l':
                    defenseTarget = Target.Legs;
                    break;
            }

            return new MoveAttributes(attackTarget, attackType, defenseTarget);
        }
        return null;
    }

    public void outStatus(Player player)
    {
        PlayerCondition pc = new PlayerCondition(player);
        System.out.println("Player name: " + pc.getName().toUpperCase());
        System.out.println("Hit points: " + pc.getHp());
        System.out.print("Status: ");
        if (pc.getStatus() == Status.Active)
            System.out.println("ACTIVE");
        else
            System.out.println("STUNNED");
    }
}
