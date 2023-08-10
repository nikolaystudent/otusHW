package tests;

import application.RussianLibrary;
import assertions.Assertions;

import java.util.NoSuchElementException;

public class RussianLibraryTest {

    public void correctLibraryWorkTest() {

        String scenario = "Тест корректной обработки запроса десятков";
        try {
            int input = 14;
            String actual;

            RussianLibrary library = new RussianLibrary();

            actual = library.getValue(input);
            String expected = "четырнадцать";
            Assertions.assertEquals(expected, actual);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест корректной обработки запроса сотых";
        try {
            int input = 100;
            String actual;

            RussianLibrary library = new RussianLibrary();

            actual = library.getValue(input);
            String expected = "сто";
            Assertions.assertEquals(expected, actual);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест корректной обработки запроса тысячных";
        try {
            int input = 1000;
            String actual;

            RussianLibrary library = new RussianLibrary();

            actual = library.getValue(input);
            String expected = "одна тысяча";
            Assertions.assertEquals(expected, actual);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест обработки некорректного запроса";
        try {
            int input = 456;
            String actual;

            RussianLibrary library = new RussianLibrary();

            actual = library.getValue(input);

        } catch (NoSuchElementException e){
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

    }

}
