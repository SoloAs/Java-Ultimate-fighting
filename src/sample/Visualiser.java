package sample;

import sample.Model.Player;

/**
 * Created by Alexander on 10/13/2014.
 */
public class Visualiser {
    //region Singleton
    private Visualiser(){
    }
    private static Visualiser gameSingleton;
    private static Visualiser getGame()
    {
        if (gameSingleton == null)
            gameSingleton = new Visualiser();
        return gameSingleton;
    }
    //endregion
}
