interface AccountService {
    /**
     * It finds an account by owner id
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It count the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

// Declare and implement your AccountServiceImpl here

class Account {
    
    private long id;
    private long balance;
    private User owner;
    
    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }
    
    public long getId() {
        return id;
    }
    
    public long getBalance() {
        return balance;
    }
    
    public User getOwner() {
        return owner;
    }
}

class User {
    
    private long id;
    private String firstName;
    private String lastName;
    
    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public long getId() {
        return id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
}

class AccountServiceImpl implements AccountService {
    Account [] accounts;
    public void AccountServiceImpl(Account[] accounts) {
        this.accounts = accounts;
    }
    
    @Override
    public Account findAccountByOwnerId(long id) {
        for (Account i: accounts) {
            if(i.getId()==id){
                return i;
            }
        }
        return null;
    }
    
    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        int count = 0;
        for (Account i: accounts) {
            if(i.getBalance()>0){
                count++;
            }
        }
        return count;
    }
}
class Main {
    public static void main(String[] args) {
        Account[] accounts = {new Account(12, 5847, new User(1, "user1", "xyz")), new Account(14, 5847, new User(5, "user2", "abz"))};
    }
}