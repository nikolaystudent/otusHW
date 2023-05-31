import java.util.HashMap;
import java.util.Map;

public class Bank {
    //база аккаунтов
    private static Map<Account, Client> accountBase = new HashMap<>();

    //привязка аккаунтов к клиентам (заполнение списка и map)
    private static void connectAccountWithClient(Account account, Client client) {
        client.setListAccounts(account);
        accountBase.put(account, client);
    }

    //поиск клиента по мапе
    public static Client findClient(Account account){
        return accountBase.get(account);
    }

    public static void main(String[] args) {

        //заполнение аккаунтов и клиентов для примера
        Client client1 = new Client(0, "client1", 30);
        Client client2 = new Client(1, "client2", 26);
        Client client3 = new Client(2, "client3", 20);
        Client client4 = new Client(3, "client4", 40);
        Client client5 = new Client(4, "client5", 40);
        Client client6 = new Client(5, "client6", 35);
        Client client7 = new Client(6, "client7", 34);

        connectAccountWithClient(new Account(0),client1);
        connectAccountWithClient(new Account(1),client1);
        connectAccountWithClient(new Account(2),client1);
        connectAccountWithClient(new Account(3),client2);
        connectAccountWithClient(new Account(4),client2);
        connectAccountWithClient(new Account(5),client3);
        connectAccountWithClient(new Account(6),client4);
        connectAccountWithClient(new Account(7),client5);
        connectAccountWithClient(new Account(8),client6);
        connectAccountWithClient(new Account(9),client6);
        connectAccountWithClient(new Account(10),client7);
        connectAccountWithClient(new Account(11),client7);

        //хотим найти клиента которому пренадлежит аккаунт с id-10
        System.out.println(findClient(new Account(10)).getIdClient());

        //хотим получить список аккаунтов клиента client6
        System.out.println(Client.getListAccounts(client6));
    }

}
