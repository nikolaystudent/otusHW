package ru.otus.tests.fakes;

import ru.otus.game.GameWinnerPrinter;
import ru.otus.game.Player;

public class GameWinnerPrinterStub implements GameWinnerPrinter {

    private String winnerName;
    @Override
    public void printWinner(Player winner) {
        this.winnerName = winner.getName();
    }

    public String getWinnerName(){
        return this.winnerName;
    }

}
