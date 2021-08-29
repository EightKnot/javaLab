package DTO;

public class GenericPerson<T> {
    private String name;
    private T account;

    public GenericPerson(String name, T account) {
        this.name = name;
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public T getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "name=" + name + " - " +
                "account=" + account + " - " +
                account.getClass().getSimpleName();
    }
}
