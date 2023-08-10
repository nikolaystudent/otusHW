package tests;

import application.*;
import assertions.Assertions;
import tests.fakes.IOServiceStub;
import tests.fakes.LibraryDigitsInWordsDummy;
import tests.fakes.StringCreatorStub;

import java.util.Arrays;
import java.util.List;

public class NumbersInWordsApplicationTest {

    public void correctApplicationWorkTest() {

        String scenario = "Тест работы приложения при передаче одного корректного запроса и остановке работы";
        try {
            String[] givenInput = new String[]{"666", "stop"};
            String[] givenResult = new String[]{"шестьсот шестьдесят шесть рублей"};
            List<String> actual;

            IOServiceStub ioService = new IOServiceStub(givenInput); //подключение fake сервиса потоков ввода/вывода
            LibraryDigitsInWords libraryWords = new LibraryDigitsInWordsDummy(); //подключение библиотеки с цифрами текстом
            StringCreator creator = new StringCreatorStub(givenResult); //подключение фейковой логики преобразования числа в строку

            NumbersInWordsApplication application = new NumbersInWordsApplication();
            application.run(ioService, libraryWords, creator); //запуск приложения
            actual = ioService.output;
            List<String> expected = Arrays.asList("Введите число от 1 до 99_999 для преобразования или stop для остановки программы", "шестьсот шестьдесят шесть рублей", "Введите число от 1 до 99_999 для преобразования или stop для остановки программы");
            Assertions.assertEquals(expected, actual);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест работы приложения при передаче трех корректных запросов и остановке работы";
        try {
            String[] givenInput = new String[]{"666", "1345", "90854", "stop"};
            String[] givenResult = new String[]{"шестьсот шестьдесят шесть рублей", "одна тысяча триста сорок пять рублей",
                    "девяносто тысяч восемьсот пятьдесят четыре рубля"};
            List<String> actual;

            IOServiceStub ioService = new IOServiceStub(givenInput); //подключение fake сервиса потоков ввода/вывода
            LibraryDigitsInWords libraryWords = new LibraryDigitsInWordsDummy(); //подключение библиотеки с цифрами текстом
            StringCreator creator = new StringCreatorStub(givenResult); //подключение фейковой логики преобразования числа в строку

            NumbersInWordsApplication application = new NumbersInWordsApplication();
            application.run(ioService, libraryWords, creator); //запуск приложения
            actual = ioService.output;
            List<String> expected = Arrays.asList("Введите число от 1 до 99_999 для преобразования или stop для остановки программы", "шестьсот шестьдесят шесть рублей", "Введите число от 1 до 99_999 для преобразования или stop для остановки программы", "одна тысяча триста сорок пять рублей", "Введите число от 1 до 99_999 для преобразования или stop для остановки программы", "девяносто тысяч восемьсот пятьдесят четыре рубля", "Введите число от 1 до 99_999 для преобразования или stop для остановки программы");
            Assertions.assertEquals(expected, actual);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест работы приложения при передаче одного некорректного, одного корректного запроса и остановке работы";
        try {
            String[] givenInput = new String[]{"-100", "100", "stop"};
            String[] givenResult = new String[]{"сто рублей"};
            List<String> actual;

            IOServiceStub ioService = new IOServiceStub(givenInput); //подключение fake сервиса потоков ввода/вывода
            LibraryDigitsInWords libraryWords = new LibraryDigitsInWordsDummy(); //подключение библиотеки с цифрами текстом
            StringCreator creator = new StringCreatorStub(givenResult); //подключение фейковой логики преобразования числа в строку

            NumbersInWordsApplication application = new NumbersInWordsApplication();
            application.run(ioService, libraryWords, creator); //запуск приложения
            actual = ioService.output;
            List<String> expected = Arrays.asList("Введите число от 1 до 99_999 для преобразования или stop для остановки программы", "Ошибка ввода, попробуйте еще раз", "Введите число от 1 до 99_999 для преобразования или stop для остановки программы", "сто рублей", "Введите число от 1 до 99_999 для преобразования или stop для остановки программы");
            Assertions.assertEquals(expected, actual);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
