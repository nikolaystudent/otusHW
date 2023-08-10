package tests.fakes;

import application.IOService;

import java.util.ArrayList;
import java.util.List;

public class IOServiceStub implements IOService {

    public String[] input;
    public List<String> output = new ArrayList<>();
    private int i = -1;
    public IOServiceStub(String[] input) {
        this.input = input;
    }
    @Override
    public String inputString() {
        return input[++i];
    }

    @Override
    public void outputString(String message) {
        this.output.add(message);
    }
}
