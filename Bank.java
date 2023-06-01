import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    //база аккаунтов
    private static Map<Account, Client> accountBase = new HashMap<>();
    //база клиентов
    private static Map<Client, List<Account>> clientBase = new HashMap<>();

    //привязка аккаунтов к клиентам (заполнение списка и map)
    private static void connectAccountWithClient(Account account, Client client) {
        accountBase.put(account, client);

        //проверяем если такая связка уже добавлена, получаем список аккаунтов и добавляем новый
        if (clientBase.containsKey(client)){
            List<Account> tempListAccount = clientBase.get(client);
            tempListAccount.add(account);
        } else { //если такой связки нет, создаем новый список и добавляем
            List<Account> tempListAccount = new ArrayList<>();
            tempListAccount.add(account);
            clientBase.put(client,tempListAccount);
        }
    }

    //поиск клиента по мапе
    public static Client findClient(Account account){
        return accountBase.get(account);
    }
    //поиск аккаунтов по мапе
    public static List<Account> findAccount(Client client){
        return clientBase.get(client);
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
        System.out.println(findClient(new Account(10)));

        //хотим получить список аккаунтов клиента с id-5
        System.out.println(findAccount(new Client(5)));
        //для поиска будет достаточно "пустого" клиента с id так условно считаем его уникальным
    }

}
