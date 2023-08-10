package application;

public class Main {
    public static void main(String[] args) {

        IOService ioService = new IOStreamsService(System.in, System.out); //подключение сервиса потоков ввода/вывода
        LibraryDigitsInWords libraryWords = new RussianLibrary(); //подключение библиотеки с цифрами текстом
        StringCreator creator = new StringCreatorLogic(); //подключение логики преобразования числа в строку

        NumbersInWordsApplication application = new NumbersInWordsApplication();
        application.run(ioService, libraryWords, creator); //запуск приложения
    }
}
