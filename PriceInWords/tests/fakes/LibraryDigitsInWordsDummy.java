package tests.fakes;

import application.LibraryDigitsInWords;

public class LibraryDigitsInWordsDummy implements LibraryDigitsInWords {
    @Override
    public String getValue(int digit) {
        return null;
    }
    @Override
    public String getEnding(int lustDigit){ return null; }

    @Override
    public String getCents(int cent){ return null; }
}
