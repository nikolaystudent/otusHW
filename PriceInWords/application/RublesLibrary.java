package application;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Objects;

public class RublesLibrary implements LibraryDigitsInWords{

    HashMap<Integer, String> listValues = new HashMap<>();
    HashMap<Integer, String> ListCents = new HashMap<>();
    HashMap<Integer, String> ListEndings = new HashMap<>();

    public RublesLibrary(){
        listValues.put(0,"ноль");
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
        listValues.put(13,"тринадцать");
        listValues.put(14,"четырнадцать");
        listValues.put(15,"пятнадцать");
        listValues.put(16,"шестнадцать");
        listValues.put(17,"семнадцать");
        listValues.put(18,"восемнадцать");
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
        listValues.put(999,"тысяч");
        listValues.put(1000,"одна тысяча");
        listValues.put(2000,"две тысячи");
        listValues.put(3000,"три тысячи");
        listValues.put(4000,"четыре тысячи");
        listValues.put(5000,"пять тысячь");
        listValues.put(6000,"шесть тысяч");
        listValues.put(7000,"семь тысяч");
        listValues.put(8000,"восемь тысяч");
        listValues.put(9000,"девять тысяч");

        ListEndings.put(1, "рубль");
        ListEndings.put(2, "рубля");
        ListEndings.put(3, "рубля");
        ListEndings.put(4, "рубля");
        ListEndings.put(5, "рублей");
        ListEndings.put(6, "рублей");
        ListEndings.put(7, "рублей");
        ListEndings.put(8, "рублей");
        ListEndings.put(9, "рублей");
        ListEndings.put(0, "рублей");

        ListCents.put(0, "ноль копеек");
        ListCents.put(1, "одна копейка");
        ListCents.put(2, "две копейки");
        ListCents.put(3, "три копейки");
        ListCents.put(4, "четыре копейки");
        ListCents.put(5, "пять копеек");
        ListCents.put(6, "шесть копеек");
        ListCents.put(7, "семь копеек");
        ListCents.put(8, "восемь копеек");
        ListCents.put(9, "девять копеек");
        ListCents.put(11, "одиннадцать копеек");
        ListCents.put(12, "двенадцать копеек");
        ListCents.put(13, "тринадцать копеек");
        ListCents.put(14, "четырнадцать копеек");
        ListCents.put(15, "пятнадцать копеек");
        ListCents.put(16, "шестнадцать копеек");
        ListCents.put(17, "семнадцать копеек");
        ListCents.put(18, "восемнадцать копеек");
        ListCents.put(19, "девятнадцать копеек");
        ListCents.put(10, "десять");
        ListCents.put(20, "двадцать");
        ListCents.put(30, "тридцать");
        ListCents.put(40, "сорок");
        ListCents.put(50, "пятдесят");
        ListCents.put(60, "шестдесят");
        ListCents.put(70, "семдесят");
        ListCents.put(80, "восемдесят");
        ListCents.put(90, "девяносто");
        ListCents.put(100, "копеек");

    }

    @Override
    public String getValue(int digit){
        if (!listValues.containsKey(digit)) throw new NoSuchElementException("Запрос по отсутствующему ключу");
        return new String(listValues.get(digit));
    }

    @Override
    public String getEnding(int lastDigit){
        if (!ListEndings.containsKey(lastDigit)) throw new NoSuchElementException("Запрос по отсутствующему ключу");
        return new String(ListEndings.get(lastDigit));
    }

    @Override
    public String getCents(int cent){
        if (!ListCents.containsKey(cent)) throw new NoSuchElementException("Запрос по отсутствующему ключу");
        return new String(ListCents.get(cent));
    }

}

