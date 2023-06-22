package ru.otus.assertions;

import ru.otus.game.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class Assertions {

    public static void assertEquals(int[] expected, int actual) {
        if (!(expected.equals(actual))) {
            throw new AssertionError(String.format("Expected [1,2,3,4,5,6] contains %s", actual));
        }
    }

    public static void assertEquals(Player player1, Player player2, String actual) {
        if (actual.equals(player1.getName()) || actual.equals(player2.getName())) {
            throw new AssertionError(String.format("Expected no winner contains %s", actual));
        }
    }

    public static void assertEquals(Player player1, String actual) {
        if (!(actual.equals(player1.getName()))) {
            throw new AssertionError(String.format("Expected %s contains %s",player1.getName(), actual));
        }
    }

}
