package tests.fakes;

import application.LibraryDigitsInWords;
import application.StringCreator;

public class StringCreatorStub implements StringCreator {

    public String[] givenResult;
    int i = -1;
    public StringCreatorStub(String[] givenResult){
        this.givenResult = givenResult;
    }

    @Override
    public String createString(String inputNumber, LibraryDigitsInWords libraryWords) {
        return givenResult[++i];
    }
}
