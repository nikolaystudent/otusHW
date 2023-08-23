package tests.fakes;

import application.LibraryDigitsInWords;

import java.util.ArrayList;
import java.util.List;

public class LibraryDigitsInWordsSpy implements LibraryDigitsInWords {

    public List<String> methodСallStack = new ArrayList<>();

    @Override
    public String getValue(int digit) {
        methodСallStack.add("Метод getValue был вызван с параметром " + digit);
        return Integer.toString(digit);
    }

    //доделать
    @Override
    public String getEnding(int lustDigit){
        methodСallStack.add("Метод getEnding был вызван с параметром " + lustDigit);
        return Integer.toString(lustDigit);
    }

    @Override
    public String getCents(int cent){
        methodСallStack.add("Метод getCents был вызван с параметром " + cent);
        return Integer.toString(cent);
    }
}
