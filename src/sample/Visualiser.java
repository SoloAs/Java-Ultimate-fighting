package sample;

import sample.model.Game;

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
        while(answer != "start")
        System.out.println(helloMsg);
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

        return names;
    }

    public void writeWinner(String name)
    {
        System.out.println("Winner is " + name);
    }
}
