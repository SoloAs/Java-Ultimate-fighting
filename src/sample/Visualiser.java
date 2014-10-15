package sample;

import sample.enums.AttackType;
import sample.enums.Status;
import sample.enums.Target;
import sample.model.Game;
import sample.model.Player;
import sample.model.action.Attack;
import sample.other.MoveAttributes;
import sample.other.MoveResult;
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
        while(!answer.matches("START|start|Start"))
        answer = in.next();
    }

    public String[] getNames()
    {
        String[] names = new String[2];
        names[0] = names[1] = "";
        System.out.print("Set name of the first player: ");
        names[0] = in.next();
     //   System.out.println();

        System.out.print("Set name of the second player: ");
        names[1] = in.next();
    //    System.out.println();

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

            System.out.print("Set an attack target: ");
            while (!temp.matches("Head|HEAD|head|body|BODY|Body|Legs|LEGS|legs"))
                temp = in.next();
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

            System.out.print("Set an attack type: ");
            while (!temp.matches("Berserk|BERSERK|berserk|Normal|NORMAL|normal|Concentrated|CONCENTRATED|concentrated"))
                temp = in.next();
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

            System.out.print("Set a defense target: ");
            while (!temp.matches("Head|HEAD|head|body|BODY|Body|Legs|LEGS|legs"))
                temp = in.next();
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

    public void outStatus(Player player, Player player1)
    {
        PlayerCondition pc = new PlayerCondition(player);
        PlayerCondition enemyPc = new PlayerCondition(player1);
        System.out.println("Current player name: " + pc.getName().toUpperCase());
        System.out.println("Hit points: " + pc.getHp());
        System.out.print("Status: ");
        if (pc.getStatus() == Status.Active)
            System.out.println("ACTIVE\n");
        else
            System.out.println("STUNNED\n");
        System.out.println("Enemy hit points: " + enemyPc.getHp());

        System.out.print("Enemy status: ");
        if (enemyPc.getStatus() == Status.Active)
            System.out.println("ACTIVE\n");
        else
            System.out.println("STUNNED\n");
    }

    public void outMoveResult(MoveResult[] moveResults)
    {
         for(MoveResult mr : moveResults)
         {
             System.out.print("Player " + mr.getName().toUpperCase());
             switch (mr.getAttackResult())
             {
                 case Not_realised:
                     System.out.print(" is still stunned");
                     break;
                 case Missed:
                     System.out.print(" missed");
                     break;
                 case Blocked:
                     System.out.print(" hit block");
                     break;
                 case Succeeded:
                     System.out.print(" intflicted " + mr.getDamage() + " damage");
                     if (mr.getStunned())
                         System.out.print(" and stunned his enemy");
                     break;
             }
             System.out.println();
         }

        printWhiteSpaces(2);
    }

    public int anotherPlayer(int currentPlayer)
    {
        if (currentPlayer == 0)
            return 1;
        else
            return 0;
    }

    public void printWhiteSpaces(int number)
    {
        for(int i = 0; i < number; i++)
            System.out.println('*');
    }
}
