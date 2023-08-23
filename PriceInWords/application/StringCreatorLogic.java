package application;

public class StringCreatorLogic implements StringCreator {

    @Override
    public String createString(String inputNumber, LibraryDigitsInWords libraryWords) {
        StringBuilder result = new StringBuilder();

        String[] splitInputNumber = inputNumber.split("\\."); //разделение введенного числа на целую часть и копейки

        char[] numberByDigits = splitInputNumber[0].toCharArray(); //разделение введенного числа (целой части) в массив цифр
        int sizeNumber = numberByDigits.length; //кол-во разрядов в веденном числе
        int lastDigit = Character.digit(numberByDigits[numberByDigits.length - 1], 10); //последняя цифра в введенном числе
        int currentDigit = 0; //текущая цифра
        boolean centSwitch = false;

        int q = 0;
        while (q<2) {
            for (int i = 0; i <= numberByDigits.length; i++) {

                if (i != numberByDigits.length) {
                    currentDigit = Character.digit(numberByDigits[i], 10);
                }

                switch (sizeNumber) {
                    case 0:
                        String appended = centSwitch ? "" : " " + libraryWords.getEnding(lastDigit);
                        result.append(appended);
                        break;
                    case 1:
                        if (currentDigit > 0) {
                            appended = centSwitch ? libraryWords.getCents(currentDigit) : libraryWords.getValue(currentDigit);
                            result.append((result.toString().equals("") ? "" : " ") +appended);
                        } else{
                                result.append(centSwitch ? " " + libraryWords.getCents(100) : "");
                        }
                        sizeNumber--;
                        break;
                    case 2:
                        //если в десятом разряде числа до 20 использовать слияние с единицами
                        if (currentDigit == 1) {

                            appended = centSwitch ? libraryWords.getCents(10 + Character.digit(numberByDigits[i + 1], 10))
                                    : libraryWords.getValue(10 + Character.digit(numberByDigits[i + 1], 10)) + " " + libraryWords.getEnding(0);

                            result.append((result.toString().equals("") ? "" : " ") + appended);
                            sizeNumber = sizeNumber - 3;
                        } else {
                            if (currentDigit > 1) {
                                appended = centSwitch ? libraryWords.getCents(currentDigit * 10) : libraryWords.getValue(currentDigit * 10);
                                result.append((result.toString().equals("") ? "" : " ") + appended);
                            }
                        }
                        sizeNumber--;
                        break;
                    case 3:
                        if (currentDigit > 0) {
                            result.append((result.toString().equals("") ? "" : " ") + libraryWords.getValue(currentDigit * 100));
                        }
                        sizeNumber--;
                        break;
                    case 4:
                        if (currentDigit > 0) {
                            result.append((result.toString().equals("") ? "" : " ") + libraryWords.getValue(currentDigit * 1000));
                        }
                        sizeNumber--;
                        break;
                    case 5:
                        //если в разряде числа до 20 использовать слияние с разрядом ниже
                        if (currentDigit == 1) {
                            result.append(libraryWords.getValue(10 + Character.digit(numberByDigits[i + 1], 10)) +
                                    " " + libraryWords.getValue(999));
                        } else {
                            result.append(libraryWords.getValue(currentDigit * 10) + " " + libraryWords.getValue((numberByDigits[i + 1] == '0' ) ? 999 : Character.digit(numberByDigits[i + 1], 10) * 1000));
                        }
                        sizeNumber = sizeNumber - 2;
                        i++;
                        break;
                }
            }
            if (splitInputNumber.length > 1 && !splitInputNumber[1].equals("00") && !splitInputNumber[1].equals("0")) { //проверка есть ли копейки в веденном числе
                q++;
                numberByDigits = splitInputNumber[1].toCharArray(); //разделение введенного числа (копеек) в массив цифр
                sizeNumber = numberByDigits.length; //кол-во разрядов в веденном числе
                lastDigit = Character.digit(numberByDigits[numberByDigits.length - 1], 10); //последняя цифра в введенном числе
                centSwitch = true;
            } else{
                q = 2;
                result.append(" " + libraryWords.getCents(0));
            }
        }
            return result.toString();
        }
    }


