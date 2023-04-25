import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Test {



    public static void main(String[] args) {

        System.out.println("Перед вами будут выводиться вопросы с варинтами ответа");
        System.out.println("ваша задача выбрать единственно верный вариант и набрать в консоли его номер");
        System.out.println("Удачи! Введите свое имя, чтобы начать...");

        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();

        //массив с вопросами
        String questions[] = {"Является ли сериал Кремниевая долина клевым?",
                "Что из перечисленного является лучшим подарком на любой праздник?",
                "Кого из перечисленных можно назвать величайшим в мире актером?"};

        //массив с вариантами ответа
        String answers[][] = {{"Да!", "Не уверен", "Нет"},{"Деньги", "Настольная игра", "Книга"},
                {"Брэд Питт", "Аль Пачино", "Райан Гослинг"}};

        //массив с верными ответами
        String trueAnswers[] = {"Да!", "Настольная игра", "Райан Гослинг"};


        int answersCounter = 0; //счетчик верных ответов
        int result; //номер выбранного ответа

        //перебор вопросов
        for (int i = 0; i < questions.length; i++){
            System.out.println(questions[i]);

            //перебор ответов
            int j = 1;
            for (String answer : answers[i]) {
                System.out.println(j +". " + answer);
                j++;
            }

            do {
                System.out.println("Введите номер верного ответа...");
                result = scan.nextInt();
            }
            while (result > answers.length || result <= 0);

            //проверка ответов
                if (answers[i][result - 1] == trueAnswers[i]) {
                    System.out.println("Верно!");
                    answersCounter++;
                } else System.out.println("Не верно!");

        }

        System.out.println("Тест завершен! " + userName + ", ваш результат: " + answersCounter + " из " + questions.length);
    }
}
