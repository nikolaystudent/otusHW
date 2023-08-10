package tests;

public class DemoTests {
    public static void main(String[] args) {

        new NumbersInWordsApplicationTest().correctApplicationWorkTest();
        new RussianLibraryTest().correctLibraryWorkTest();
        new StringCreatorLogicTest().correctStringCreatorWorkTest();
        new StringCreatorLogicTest().correctCreateStringTest();
        new IOStreamsServiceTest().testInput();
        new IOStreamsServiceTest().testOutput();

    }
}
