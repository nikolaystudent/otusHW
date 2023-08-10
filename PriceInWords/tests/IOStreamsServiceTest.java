package tests;

import application.IOStreamsService;
import assertions.Assertions;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class IOStreamsServiceTest {

    public void testInput() {
        String scenario = "Тест чтения строки";
        try {
            String expected = "input string";
            ByteArrayInputStream inputStream = new ByteArrayInputStream(expected.getBytes());
            IOStreamsService ioService = new IOStreamsService(inputStream, null);
            String actual = ioService.inputString();
            Assertions.assertEquals(expected, actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

    public void testOutput() {
        String scenario = "Тест вывода строки";
        try {
            String expected = "output string";
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            IOStreamsService ioService = new IOStreamsService(new ByteArrayInputStream(new byte[0]),
                    new PrintStream(outputStream));
            ioService.outputString(expected);
            String actual = outputStream.toString();
            Assertions.assertEquals(expected + System.getProperty("line.separator"), actual);

            System.out.printf("\"%s\" passed %n", scenario);
        } catch (Throwable e) {
            System.err.printf("\"%s\" fails with message \"%s\" %n", scenario, e.getMessage());
        }
    }

}
