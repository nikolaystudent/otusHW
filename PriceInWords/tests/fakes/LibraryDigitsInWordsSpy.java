package tests.fakes;

import application.LibraryDigitsInWords;

import java.util.ArrayList;
import java.util.List;

public class LibraryDigitsInWordsSpy implements LibraryDigitsInWords {

    public List<String> methodСallStack = new ArrayList<>();

    @Override
    public String getValue(int digit) {
        methodСallStack.add("Метод был вызван с параметром " + digit);
        return Integer.toString(digit);
    }
}
