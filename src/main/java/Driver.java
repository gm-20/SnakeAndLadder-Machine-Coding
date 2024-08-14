import model.Ladder;
import model.Player;
import model.Snake;
import service.SnakeAndLadderService;

import java.util.ArrayList;
import java.util.List;

public class Driver {


    public static void main(String[] args) {


        //Board Init
        SnakeAndLadderService snakeAndLadderService = new SnakeAndLadderService(100);

        //Snake Init
        List<Snake> snakes = new ArrayList<>();
        snakes.add(new Snake(10,6));
        snakes.add(new Snake(99,55));
        snakeAndLadderService.setSnakes(snakes);

        //Ladder Init
        List<Ladder> ladders = new ArrayList<>();
        ladders.add(new Ladder(20,88));
        ladders.add(new Ladder(3,91));
        snakeAndLadderService.setLadders(ladders);

        //Player Init
        List<Player> players = new ArrayList<>();
        players.add(new Player("Gaurav"));
        players.add(new Player("Divya"));
        players.add(new Player("Saurabh"));
        snakeAndLadderService.setPlayers(players);

        //Game Start
        snakeAndLadderService.startGame();
    }


}

