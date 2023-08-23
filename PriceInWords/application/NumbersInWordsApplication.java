package application;

import java.util.Objects;

public class NumbersInWordsApplication {

    public void run(IOService ioService, LibraryDigitsInWords libraryWords, StringCreator creator) {
        while (true) {
            ioService.outputString("Введите число от 0.01 до 99_999.99 для преобразования или stop для остановки программы");
            try {
                String input = ioService.inputString();
                double inpunDouble;
                if (Objects.equals(input, "stop")) {
                    break;
                }
                try {
                    inpunDouble = Double.parseDouble(input);
                } catch (Exception e) {
                    throw new Exception("введенное значение не является числом");
                }
                if (inpunDouble > 99_999.99 || inpunDouble < 0.01) {
                    throw new Exception("число вне диапазона");
                }
                String result = creator.createString(input, libraryWords);
                ioService.outputString(result);
            } catch (Exception e){
                ioService.outputString("Ошибка ввода: " + e.getMessage());
            }

        }
    }
}
