package ru.otus.tests;

import ru.otus.assertions.Assertions;
import ru.otus.game.*;
import ru.otus.tests.fakes.DiceStub;
import ru.otus.tests.fakes.GameWinnerPrinterStub;

public class GameTest {

    public void correctDeterminationWinnerTest(){

        String scenario = "Тест игры с одинаковыми результатами броска кубика";
        try {
            //передаем контролируемые значения бросков кубика
            int[] diceResult = new int[]{1, 1};
            Player player1 = new Player("Игрок_1");
            Player player2 = new Player("Игрок_2");

            Dice dice = new DiceStub(diceResult);
            GameWinnerPrinterStub winnerPrinter = new GameWinnerPrinterStub();
            Game game = new Game(dice, winnerPrinter);
            game.playGame(player1, player2);
            String winner = winnerPrinter.getWinnerName();
            Assertions.assertEquals(player1, player2, winner);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест игры с большим результатом для первого игрока";
        try {
            //передаем контролируемые значения бросков кубика
            int[] diceResult = new int[]{6, 1};
            Player player1 = new Player("Игрок_1");
            Player player2 = new Player("Игрок_2");

            Dice dice = new DiceStub(diceResult);
            GameWinnerPrinterStub winnerPrinter = new GameWinnerPrinterStub();
            Game game = new Game(dice, winnerPrinter);
            game.playGame(player1, player2);
            String winner = winnerPrinter.getWinnerName();
            Assertions.assertEquals(player1, winner);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест игры с большим результатом для второго игрока";
        try {
            //передаем контролируемые значения бросков кубика
            int[] diceResult = new int[]{1, 6};
            Player player1 = new Player("Игрок_1");
            Player player2 = new Player("Игрок_2");

            Dice dice = new DiceStub(diceResult);
            GameWinnerPrinterStub winnerPrinter = new GameWinnerPrinterStub();
            Game game = new Game(dice, winnerPrinter);
            game.playGame(player1, player2);
            String winner = winnerPrinter.getWinnerName();
            Assertions.assertEquals(player2, winner);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

}
