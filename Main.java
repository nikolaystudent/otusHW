import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Integer> testList = new ArrayList<>();

        //заполнение списка случайными числами от 0 до 100_000
        for (int i = 0; i <= 100_001; i++){

            testList.add((int) (Math.random()*100_001));

        }
        //копирование списка для проверки дефолтным методом сортировки
        List<Integer> referenceList = new ArrayList<>(testList);

        //---Дефолтный метод---
        long startTime = System.currentTimeMillis();

        Collections.sort(referenceList);

        long endTime = System.currentTimeMillis();
        System.out.println("Время в миллисекундах на сортировку при использовании Collections.sort(): "
                + String.valueOf(endTime-startTime));

        //---Метод пузырьком---
        startTime = System.currentTimeMillis();

        //буфер для замены
        Integer temp = 0;
        //маркер отмечающий завершение сортировки
        boolean sorted = false;

        // повторять цикл с перебором элементов пока маркер не останется true
        while (!sorted){
            sorted = true;

            for (int i = testList.size()-1; i > 0; i--){

                if (testList.get(i) < testList.get(i-1)){
                    sorted = false;
                    temp = testList.get(i);
                    testList.set(i, testList.get(i-1));
                    testList.set(i-1,temp);
                }
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("время в миллисекундах затраченное на сортировку при использовании метода пузырьком: "
                + String.valueOf(endTime - startTime));

    }

    //разница существенная, практически в минуту (47 и 58680 миллисекунд)

}
