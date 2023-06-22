package ru.otus.tests.fakes;

import ru.otus.game.Dice;

public class DiceStub implements Dice {

    private int[] diceResult;
    //маркер для перехода по массиву
    private int i = -1;
    public DiceStub(int[] actual){
        this.diceResult = actual;
    }

    @Override
    public int roll() {
        i++;
        return diceResult[i];
    }


}
