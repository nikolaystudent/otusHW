import java.util.ArrayList;
import java.util.List;

public class Client {

    private int idClient;
    private String nameClient;
    private int ageClient;
    private List<Account> listAccounts;

    //Конструктор класса
    Client(int id, String name, int age){
        this.idClient = id;
        this.nameClient = name;
        this.ageClient = age;
        this.listAccounts = new ArrayList<>();
    }

    //возвращает id клиента
    public int getIdClient() {
        return idClient;
    }

    //добавляет аккаунт в список клиента
    public void setListAccounts(Account account){
        listAccounts.add(account);
    }

    //возвращает список аккаунтов клиента
    public static List<Account> getListAccounts(Client client) {
        return client.listAccounts;
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
