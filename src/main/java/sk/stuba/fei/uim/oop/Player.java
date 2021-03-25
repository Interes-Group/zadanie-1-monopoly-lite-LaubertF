package sk.stuba.fei.uim.oop;

public class Player {
    private String name = "";
    private int balance = 15000;
    private int position = 0;
    private int jail_time = 0;



    public int getJail_time() {
        return jail_time;
    }

    public void setJail_time(int jail_time) {
        this.jail_time = jail_time;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public int getBalance() {
        return balance;
    }

    public void changeBalance(int profit) {
        this.balance += profit;
    }

    public void addBalance(int addBalance) {
        this.balance += addBalance;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void reduceJail_time() {
        this.jail_time -= jail_time;
    }

    public void reduceBalance(int amount) {
        this.balance -= amount;
    }
}
