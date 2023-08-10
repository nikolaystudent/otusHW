package application;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class RussianLibrary implements LibraryDigitsInWords{

    HashMap<Integer, String> listValues = new HashMap<>();

    public RussianLibrary(){
        listValues.put(1,"один");
        listValues.put(2,"два");
        listValues.put(3,"три");
        listValues.put(4,"четыре");
        listValues.put(5,"пять");
        listValues.put(6,"шесть");
        listValues.put(7,"семь");
        listValues.put(8,"восемь");
        listValues.put(9,"девять");
        listValues.put(10,"десять");
        listValues.put(11,"одиннадцать");
        listValues.put(12,"двенадцать");
        listValues.put(13,"тренадцать");
        listValues.put(14,"четырнадцать");
        listValues.put(15,"пятнадцать");
        listValues.put(16,"шестнадцать");
        listValues.put(17,"семьнадцать");
        listValues.put(18,"восемьнадцать");
        listValues.put(19,"девятнадцать");
        listValues.put(20,"двадцать");
        listValues.put(30,"тридцать");
        listValues.put(40,"сорок");
        listValues.put(50,"пятьдесят");
        listValues.put(60,"шестьдесят");
        listValues.put(70,"семдесят");
        listValues.put(80,"восемьдесят");
        listValues.put(90,"девяносто");
        listValues.put(100,"сто");
        listValues.put(200,"двести");
        listValues.put(300,"триста");
        listValues.put(400,"четыреста");
        listValues.put(500,"пятьсот");
        listValues.put(600,"шестьсот");
        listValues.put(700,"семьсот");
        listValues.put(800,"восемьсот");
        listValues.put(900,"девятьсот");
        listValues.put(000,"тысяч");
        listValues.put(1000,"одна тысяча");
        listValues.put(2000,"две тысячи");
        listValues.put(3000,"три тысячи");
        listValues.put(4000,"четыре тысячи");
        listValues.put(5000,"пять тысячь");
        listValues.put(6000,"шесть тысяч");
        listValues.put(7000,"семь тысяч");
        listValues.put(8000,"восемь тысяч");
        listValues.put(9000,"девять тысяч");
    }

    @Override
    public String getValue(int digit){
        if (!listValues.containsKey(digit)) throw new NoSuchElementException("Запрос по отсутствующему ключу");
        return new String(listValues.get(digit));
    }

}

