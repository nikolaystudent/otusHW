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
            String[] givenResult = new String[]{"запрос 1"};
            List<String> actual;

            IOServiceStub ioService = new IOServiceStub(givenInput); //подключение fake сервиса потоков ввода/вывода
            LibraryDigitsInWords libraryWords = new LibraryDigitsInWordsDummy(); //подключение библиотеки с цифрами текстом
            StringCreator creator = new StringCreatorStub(givenResult); //подключение фейковой логики преобразования числа в строку

            NumbersInWordsApplication application = new NumbersInWordsApplication();
            application.run(ioService, libraryWords, creator); //запуск приложения
            actual = ioService.output;
            List<String> expected = Arrays.asList("Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы", "запрос 1", "Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы");
            Assertions.assertEquals(expected, actual);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест работы приложения при передаче трех корректных запросов и остановке работы";
        try {
            String[] givenInput = new String[]{"666", "1345", "90854.32", "stop"};
            String[] givenResult = new String[]{"запрос 1", "запрос 2", "запрос 3"};
            List<String> actual;

            IOServiceStub ioService = new IOServiceStub(givenInput); //подключение fake сервиса потоков ввода/вывода
            LibraryDigitsInWords libraryWords = new LibraryDigitsInWordsDummy(); //подключение библиотеки с цифрами текстом
            StringCreator creator = new StringCreatorStub(givenResult); //подключение фейковой логики преобразования числа в строку

            NumbersInWordsApplication application = new NumbersInWordsApplication();
            application.run(ioService, libraryWords, creator); //запуск приложения
            actual = ioService.output;
            List<String> expected = Arrays.asList("Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы", "запрос 1", "Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы", "запрос 2", "Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы", "запрос 3", "Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы");
            Assertions.assertEquals(expected, actual);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }

        scenario = "Тест работы приложения при передаче двух некорректных, одного корректного запроса и остановке работы";
        try {
            String[] givenInput = new String[]{"-100", "TEXT", "100", "stop"};
            String[] givenResult = new String[]{"запрос 1"};
            List<String> actual;

            IOServiceStub ioService = new IOServiceStub(givenInput); //подключение fake сервиса потоков ввода/вывода
            LibraryDigitsInWords libraryWords = new LibraryDigitsInWordsDummy(); //подключение библиотеки с цифрами текстом
            StringCreator creator = new StringCreatorStub(givenResult); //подключение фейковой логики преобразования числа в строку

            NumbersInWordsApplication application = new NumbersInWordsApplication();
            application.run(ioService, libraryWords, creator); //запуск приложения
            actual = ioService.output;
            List<String> expected = Arrays.asList("Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы", "Ошибка ввода: число вне диапазона", "Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы",
                    "Ошибка ввода: введенное значение не является числом", "Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы", "запрос 1", "Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы");
            Assertions.assertEquals(expected, actual);
            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e){
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }
}
