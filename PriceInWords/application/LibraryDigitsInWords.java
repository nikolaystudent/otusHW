package application;

import java.util.HashMap;

public interface LibraryDigitsInWords {

    HashMap<Integer, String> listValues = new HashMap<>();

    public String getValue(int digit);
    public String getEnding(int lustDigit);
    public String getCents(int cent);
}
