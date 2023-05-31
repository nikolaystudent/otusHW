public class Cinema {
    private boolean freeSeats;
    public Cinema(boolean freeSeats) {
        this.freeSeats = freeSeats;
    }

    //проверка свободных мест с пробросом исключения в случае отсутствия таковых
    public boolean checkFreeSeats() throws NoFreeSeatsException {
        if (this.freeSeats){
          return true;
        } else {
            throw new NoFreeSeatsException("нет свободных мест");
        }
    }

    //создание сеанса просмотра фильма
    public void viewFilm(Film film, int age){
        try (filmSession session = new filmSession()){
            if (film.checkFilmAvailability() && film.checkAgeLimit(age) && this.checkFreeSeats()){
                System.out.println("Смотрим кино");
            }
        //обработка исключений одних типов с выбросом unchecked исключения и указанием причины
        } catch (UncorrectAgeException | NoFilmException e){
            throw new RuntimeException(e);

        //обработка исключений другого типа с повторным вызовом кода
        } catch (NoFreeSeatsException e){
            System.out.println("К сожалению, " + e.getMessage() + ", подождите, мы выгоним кого-нибудь");
            this.freeSeats = true;
            System.out.println("места освободились");
            this.viewFilm(film, age);
        }
    }

    public static void main(String[] args) {

        //создаем библиотеку фильмов для примера
        Film film1 = new Film(18,true);
        Film film2 = new Film(16,false);

        //идем в кинотеатр
        Cinema cinema = new Cinema(false);

        //пробуем посмотреть кино
        cinema.viewFilm(film1,18);
        cinema.viewFilm(film2,18);
    }
}
