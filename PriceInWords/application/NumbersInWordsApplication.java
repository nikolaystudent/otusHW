package application;

import java.util.Objects;

public class NumbersInWordsApplication {

    public void run(IOService ioService, LibraryDigitsInWords libraryWords, StringCreator creator) {
        while (true) {
            ioService.outputString("Введите число от 1 до 99_999 для преобразования или stop для остановки программы");
            try {
                String number = ioService.inputString();
                if (Objects.equals(number, "stop")) {
                    break;
                } else if (Integer.parseInt(number) > 99_999 || Integer.parseInt(number) < 1){
                    throw new Exception("Ошибка ввода, попробуйте еще раз");
                }
                String result = creator.createString(number, libraryWords);
                ioService.outputString(result);
            } catch (Exception e){
                ioService.outputString(e.getMessage());
            }
        }
    }
}
