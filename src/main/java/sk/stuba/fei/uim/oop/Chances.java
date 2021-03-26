package sk.stuba.fei.uim.oop;

public class Chances {
    private Chance[] chances = {new Chance(),
                                new Chance(),
                                new Chance(),
                                new Chance(),
                                new Chance()
                                };
    Chances(){
        chances[0].setMoney(2000);
        chances[1].setMoney(1000);
        chances[2].setMoney(3000);
        chances[3].setMoney(5000);
        chances[4].setMoney(4000);
    }
    public int getChanceCard(int chanceNumber) {
        return chances[chanceNumber].getMoney();
    }

}
