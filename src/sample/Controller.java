package sample;

import sample.model.Game;

public class Controller {

    private void Play()
    {
        Game game = Game.getGame();

        switch (game.getGameState())
        {
            case MainMenu:
                Visualiser.getVisualiser().sayHello();
                String[] names = Visualiser.getVisualiser().getNames();
                game.getPlayers()[0].setName(names[0]);
                game.getPlayers()[1].setName(names[1]);
                break;
            case Fight:
                while ((game.getPlayers()[0].getHp() >= 0) && (game.getPlayers()[1].getHp() >= 0))
                {
                    //получить параметры хода и рассчитать
                    game.evaluateMove();
                }
                break;
            case Ending:
                Visualiser.getVisualiser().writeWinner(game.getPlayers()[game.getCurrentPlayer()].getName());
                break;
        }
    }

}
