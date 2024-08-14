package service;

import model.Ladder;
import model.Player;
import model.Snake;
import model.SnakeAndLadderBoard;

import java.util.*;

public class SnakeAndLadderService {

    //Member Variables
    private SnakeAndLadderBoard snakeAndLadderBoard;
    private int initialNumberOfPlayers;
    private Queue<Player> players;


    private static final int DEFAULT_BOARD_SIZE = 100;

    public SnakeAndLadderService(int boardSize) {
        this.snakeAndLadderBoard = new SnakeAndLadderBoard(boardSize);
        this.players = new LinkedList<Player>();
    }

    public void setSnakes(List<Snake> snakes) {
        snakeAndLadderBoard.setSnakes(snakes); // Add snakes to board
    }

    public void setLadders(List<Ladder> ladders) {
        snakeAndLadderBoard.setLadders(ladders); // Add ladders to board
    }

    public void setPlayers(List<Player> players) {

        this.initialNumberOfPlayers = players.size();
        Map<String,Integer> playerPieces = new HashMap<>();

        for(Player p : players) {
            this.players.add(p);
            playerPieces.put(p.getId(),p.getPos());
        }
    }


    private boolean isGameCompleted() {
        return initialNumberOfPlayers == 1;
    }


    private int checkSnakesAndLadder(int position) {

        for (Snake s : snakeAndLadderBoard.getSnakes()) {

            if (position == s.getStart()) {
                position = s.getEnd();
            }
        }

        for (Ladder l : snakeAndLadderBoard.getLadders()) {

            if (position == l.getStart()) {
                position = l.getEnd();
            }
        }

        return position;
    }


    private void movePlayer(Player player , int diceValue) {

        int currPosition = player.getPos();
        int newPosition = currPosition + diceValue;

        if (newPosition > DEFAULT_BOARD_SIZE) {
            newPosition = currPosition;
        } else {
            newPosition = checkSnakesAndLadder(newPosition);
        }

        player.setPos(newPosition);
        System.out.println(player.getName() + " rolled dice with " + diceValue + " and moved from " + currPosition + " to " + newPosition);
    }

    private boolean hasPlayerWon(Player player) {

        if (player.getPos() == DEFAULT_BOARD_SIZE) {
            return true;
        } else
            return false;

    }

    public void startGame() {

        while (!isGameCompleted()) {

            int diceValue = DiceService.roll();

            Player currentPlayer = players.poll();

            movePlayer(currentPlayer,diceValue);

            if (hasPlayerWon(currentPlayer)) {
                System.out.println(currentPlayer.getName() + " wins the game");
                this.initialNumberOfPlayers--;
            } else {
                players.add(currentPlayer);
            }
        }
    }

}
