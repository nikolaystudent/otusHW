public class filmSession implements AutoCloseable {

    public filmSession() {
        System.out.println("Киносеанс открыт");
    }

    @Override
    public void close(){
        System.out.println("Киносеанс закрыт");
    }
}
