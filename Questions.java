public class Questions {

    private int numberQuestion;
    private String textQuestions;

    //конструктор
    Questions(int numberQuestion, String textQuestions) {
        this.numberQuestion = numberQuestion;
        this.textQuestions = textQuestions;
    }

    //геттер для номера вопроса
    int getNumberQuestion(){
        return numberQuestion;
    }

    //вывод вопроса в консоль
    public void printQuestion(){

        System.out.println(numberQuestion + ") " + textQuestions);

    }

}
