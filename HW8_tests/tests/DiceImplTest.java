package ru.otus.tests;

import ru.otus.assertions.Assertions;
import ru.otus.game.DiceImpl;

import java.sql.Array;

public class DiceImplTest {

    DiceImpl dice = new DiceImpl();

    public void correctResultTestDiceImpl(){
        String scenario = "Тест получения корректного результата броска кубика";
        try {
            int actual = dice.roll();
            Assertions.assertEquals(new int[]{1,2,3,4,5,6}, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }



    }

}
