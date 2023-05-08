import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        System.out.println("Перед вами будут выводиться вопросы с варинтами ответа");
        System.out.println("ваша задача выбрать единственно верный вариант и набрать в консоли его номер");
        System.out.println("Удачи! Введите свое имя, чтобы начать...");

        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();

        //массив с экземплярами вопросов
        Questions questions[] = {new Questions(1,"Является ли сериал Кремниевая долина клевым?"),
                new Questions(2,"Что из перечисленного является лучшим подарком на любой праздник?"),
                new Questions(3,"Кого из перечисленных можно назвать величайшим в мире актером?")};

        //массив с экземплярами ответов
        Answers answers[] = {new Answers(1,"Да!",1, true),
                new Answers(2, "Не уверен", 1, false),
                new Answers(3, "Нет", 1, false),
                new Answers(4, "Деньги", 2,false),
                new Answers(5, "Настольная игра", 2, true),
                new Answers(6, "Книга",2, false),
                new Answers(7, "Брэд Питт",3, false),
                new Answers(8, "Аль Пачино",3, false),
                new Answers(9, "Райан Гослинг", 3, true)};


        int answersCounter = 0; //счетчик верных ответов
        int result; //номер выбранного ответа

        //перебор вопросов
        for (Questions question: questions){

            //печать вопроса
            question.printQuestion();

            //перебор ответов
            for (Answers answer : answers) {
                if (answer.getIdQuestion() == question.getNumberQuestion()) answer.printAnswer();
            }

            //ввод ответа пользователя и проверка корректности ввода
            do {
                System.out.println("Введите номер верного ответа...");
                result = scan.nextInt();
            }
            while (result > answers.length || result <= 0);

            //проверка ответов
                if (answers[result - 1].getRightOrNo()) {
                    System.out.println("Верно!");
                    answersCounter++;
                } else System.out.println("Не верно!");

        }

        System.out.println("Тест завершен! " + userName + ", ваш результат: " + answersCounter + " из " + questions.length);
    }
}
