public class Client {

    private int idClient;
    private String nameClient;
    private int ageClient;

    //Конструктор класса
    Client(int id, String name, int age){
        this.idClient = id;
        this.nameClient = name;
        this.ageClient = age;
    }

    //конструктор для поиска
    Client(int id){
        this.idClient = id;
    }

    //переопределение hashcode и equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        return idClient == client.idClient;
    }

    @Override
    public int hashCode() {
        return idClient;
    }
}
