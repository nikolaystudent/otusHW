package assertions;

import java.util.List;

public class Assertions {

    public static void assertEquals(List<String> expected, List<String> actual ) {
        if(!expected.equals(actual)){
            throw new AssertionError(String.format("Expected %s contains %s",expected, actual));
        }
    }
    public static void assertEquals(String expected, String actual) {
        if(!expected.equals(actual)){
            throw new AssertionError(String.format("Expected %s contains %s",expected, actual));
        }
    }

}
