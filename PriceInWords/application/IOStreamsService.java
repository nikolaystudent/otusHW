package application;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOStreamsService implements IOService{

private final Scanner in;
private final PrintStream out;

    public IOStreamsService(InputStream in, PrintStream out) {
        this.in = new Scanner(in);
        this.out = out;
    }

    @Override
    public String inputString() {
        return in.nextLine();
    }

    @Override
    public void outputString(String message) {
        out.println(message);
    }
}
