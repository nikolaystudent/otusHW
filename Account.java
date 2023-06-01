import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Account {

    private int idAccount;
    //private static Map<Account, Client> accountBase = new HashMap<>();

    //конструктор
    public Account(int id){
        this.idAccount = id;
    }

    //переопределение hashcode и equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        return idAccount == account.idAccount;
    }

    @Override
    public int hashCode() {
        return idAccount;
    }
}
