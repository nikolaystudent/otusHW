public class Answers {

    private int numberAnswer;
    private String textAnswer;
    private int idQuestion;
    private boolean rightOrNo;

    //конструктор
    Answers(int numberAnswer, String textAnswer, int idQuestion, boolean rightOrNo){
        this.numberAnswer = numberAnswer;
        this.textAnswer = textAnswer;
        this.idQuestion = idQuestion;
        this.rightOrNo = rightOrNo;
    }

    //геттер для id вопроса к которому привязан ответ
    int getIdQuestion(){
        return idQuestion;
    }

    //геттер для значения верности ответа
    boolean getRightOrNo(){
        return rightOrNo;
    }

    //вывод варианта ответа в консоль
    public void printAnswer(){

        System.out.println(numberAnswer + ". " + textAnswer);

    }


}
