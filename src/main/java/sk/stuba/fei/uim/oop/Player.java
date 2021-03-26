package sk.stuba.fei.uim.oop;

public class Player {
    private String name = "";
    private int balance = 15000;
    private int position = 0;
    private int jailTime = 0;



    
    public void setJailTime(int jailTime) {
        this.jailTime = jailTime;
    }

    public void decreaseJailTime() {
        this.jailTime--;
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


    public void reduceBalance(int amount) {
        this.balance -= amount;
    }

    public int getJailTime() {
        return jailTime;
    }
}
