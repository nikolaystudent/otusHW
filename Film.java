public class Film {
    private boolean filmAvailability;
    private int ageLimit;

    public Film(int ageLimit,boolean filmAvailability) {
        this.ageLimit = ageLimit;
        this.filmAvailability = filmAvailability;
    }

    //проверка на наличие фильма с пробросом исключения
    public boolean checkFilmAvailability() throws NoFilmException{
        if (this.filmAvailability){
            return true;
        } else {
            throw new NoFilmException("фильма нет в наличии");
        }
    }

    //проверка огранияения по возрасту с пробросом исключения
    public boolean checkAgeLimit(int yourAge) throws UncorrectAgeException{
        if (yourAge >= this.ageLimit){
            return true;
        } else{
            throw new UncorrectAgeException("возрастные ограничения не позволяют вам посмотреть этот фильм");
        }
    }
}
