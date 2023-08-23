package tests;

import application.RublesLibrary;
import assertions.Assertions;

import java.util.NoSuchElementException;

public class RublesLibraryTest {

    public void correctLibraryWorkTest() {

        String scenario = "Тест корректной обработки запроса десятков";
        try {
            int input = 14;
            String actual;

            RublesLibrary library = new RublesLibrary();

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

            RublesLibrary library = new RublesLibrary();

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

            RublesLibrary library = new RublesLibrary();

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

            RublesLibrary library = new RublesLibrary();

            actual = library.getValue(input);

        } catch (NoSuchElementException e){
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест корректной обработки запроса копеек";
        try {
            int input = 15;
            String actual;

            RublesLibrary library = new RublesLibrary();

            actual = library.getCents(input);
            String expected = "пятнадцать копеек";
            Assertions.assertEquals(expected, actual);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест корректной обработки запроса окончания";
        try {
            int input = 1;
            String actual;
            RublesLibrary library = new RublesLibrary();
            actual = library.getEnding(input);
            String expected = "рубль";
            Assertions.assertEquals(expected, actual);

            input = 2;
            actual = library.getEnding(input);
            expected = "рубля";
            Assertions.assertEquals(expected, actual);

            input = 5;
            actual = library.getEnding(input);
            expected = "рублей";
            Assertions.assertEquals(expected, actual);

            input = 0;
            actual = library.getEnding(input);
            expected = "рублей";
            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);

        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

    }
}
