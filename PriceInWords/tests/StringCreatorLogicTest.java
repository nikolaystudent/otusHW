package tests;

import application.StringCreator;
import application.StringCreatorLogic;
import assertions.Assertions;
import tests.fakes.LibraryDigitsInWordsSpy;

import java.util.Arrays;
import java.util.List;

public class StringCreatorLogicTest {

    public void correctStringCreatorWorkTest() {

        String scenario = "Тест интеграции алгоритма с беблиотекой слов";
        try {
            String givenInput = "54908";
            String result;
            List<String> actualMethodСallStack;

            StringCreator creator = new StringCreatorLogic();
            LibraryDigitsInWordsSpy stubLibrary = new LibraryDigitsInWordsSpy();

            result =  creator.createString(givenInput, stubLibrary);
            actualMethodСallStack = stubLibrary.methodСallStack;
            List<String> expectedMethodСallStack = Arrays.asList("Метод был вызван с параметром 50", "Метод был вызван с параметром 4000", "Метод был вызван с параметром 900", "Метод был вызван с параметром 8");
            Assertions.assertEquals(expectedMethodСallStack, actualMethodСallStack);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void correctCreateStringTest(){
        String scenario = "Тест корректной работы алгоритма создания строки";
        try {
            String givenInput = "54908";
            String actual;
            String expected = "50 4000 900 8 рублей";

            StringCreator creator = new StringCreatorLogic();
            LibraryDigitsInWordsSpy stubLibrary = new LibraryDigitsInWordsSpy();

            actual =  creator.createString(givenInput, stubLibrary);
            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
