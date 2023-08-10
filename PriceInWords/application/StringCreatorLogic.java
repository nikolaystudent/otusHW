package application;

public class StringCreatorLogic implements StringCreator{

    @Override
    public String createString(String inputNumber, LibraryDigitsInWords libraryWords) {
        String result = ""; //
        char[] numberByDigits = inputNumber.toCharArray(); //разделение введенного числа в массив цифр
        int sizeNumber = numberByDigits.length; //кол-во разрядов в веденном числе
        int lustDigit = Character.digit(numberByDigits[numberByDigits.length - 1], 10); //последняя цифра в введенном числе
        int currentDigit = 0; //текущая цифра

        for (int i = 0; i <= numberByDigits.length; i++) {

            if (i != numberByDigits.length) {currentDigit = Character.digit(numberByDigits[i], 10);}

            switch (sizeNumber) {
                case 0:
                    if (lustDigit == 1) {
                        result = result + " " + "рубль";
                    } else if (lustDigit < 5 && lustDigit > 1) {
                        result = result + " " + "рубля";
                    } else result = result + " " + "рублей";
                    break;
                case 1:
                    if (currentDigit > 0) {
                        result = result + (result.equals("") ? "" : " ") + libraryWords.getValue(currentDigit);
                    }
                    sizeNumber--;
                    break;
                case 2:
                    //если в десятом разряде числа до 20 использовать отдельный массив
                    if (currentDigit == 1) {
                        result = result + (result.equals("") ? "" : " ") + libraryWords.getValue(10 + Character.digit(numberByDigits[i + 1], 10)) +
                                " " + "рублей";
                        sizeNumber = sizeNumber - 3;
                    } else {
                        if (currentDigit > 1) {
                            result = result + (result.equals("") ? "" : " ") + libraryWords.getValue(currentDigit * 10);
                        }
                        sizeNumber--;
                    }
                    break;
                case 3:
                    if (currentDigit > 0) {
                        result = result + (result.equals("") ? "" : " ") + libraryWords.getValue(currentDigit * 100);
                    }
                    sizeNumber--;
                    break;
                case 4:
                    if (currentDigit > 0) {
                        result = result + (result.equals("") ? "" : " ") + libraryWords.getValue(currentDigit * 1000);
                    }
                    sizeNumber--;
                    break;
                case 5:
                    //если в разряде числа до 20 использовать отдельный массив
                    if (currentDigit == 1) {
                        result = result + libraryWords.getValue(10 + Character.digit(numberByDigits[i + 1], 10)) +
                                " " + libraryWords.getValue(000);
                    } else {
                        result = result + libraryWords.getValue(currentDigit * 10) + " " + libraryWords.getValue(Character.digit(numberByDigits[i + 1], 10) *1000);
                    }
                    sizeNumber = sizeNumber - 2;
                    i++;
                    break;
            }
        }
        return result;
    }

}
