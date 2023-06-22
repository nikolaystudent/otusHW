package ru.otus.tests;

import ru.otus.game.DiceImpl;

public class DemoTests {

    //Тест 1
    public static void main(String[] args) {
        new DiceImplTest().correctResultTestDiceImpl();
        new GameTest().correctDeterminationWinnerTest();
    }

}
