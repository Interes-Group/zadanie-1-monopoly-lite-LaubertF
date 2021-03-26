package sk.stuba.fei.uim.oop;


import java.util.LinkedList;
//import java.util.ListIterator;
//import java.io.Console;
import java.util.Scanner;
import java.util.Random;
/**
 * Game
 */
public class Game {
        
    Game(){
        System.out.println("Zadaj pocet hracov.");
        Scanner scan = new Scanner(System.in);
        int playerCount = 0;
        try {
            playerCount =  Integer.parseInt(scan.nextLine());
        } catch (Exception e) {
            System.out.println("Nezadal si pocet hracov :/");
        }
        
        if(playerCount < 2) {
            System.out.println("Hru musi hrat viac hracov");
            
        } else {
            System.out.println("Pocet hracov je:" + playerCount);
            var players = new LinkedList<Player>();
            for (int i = 0; i < playerCount; i++){
                System.out.println("Zadaj meno " + (i+1) + ". hraca");
                String temp = scan.nextLine();
                var player = new Player();
                player.setName(temp);
                players.add(player);
            }
            System.out.println("Mena hracov:");

            for (int i = 0; i < playerCount; i++){
                System.out.println(players.get(i).getName());
            }
            System.out.println("Zaciatok hry");
            
            

            
            
            
            var board = new Board();
            int playerNumber = 0;
           int chanceNumber = 0;
            Chances chances = new Chances();
            while(players.size()>1){
                Player playerPlaying = players.get(playerNumber);
                if (playerPlaying.getJailTime() >0 ){
                    playerPlaying.decreaseJailTime();
                    break;
                }
                Random rand = new Random();
                int diceNumber = rand.nextInt(6) + 1;
                System.out.println("Hrac "+ playerPlaying.getName() + " hodil " + diceNumber);
                System.out.print("Ide z " + Integer.toString(playerPlaying.getPosition() + 1)+" na ");
                int currentPosition = playerPlaying.getPosition() + diceNumber;
                if (currentPosition > 23){
                    playerPlaying.changeBalance(3000);
                    currentPosition-=24;
                }
                playerPlaying.setPosition(currentPosition);
                System.out.println(currentPosition + 1);
                Tile currentTile = board.getTile(currentPosition);
                switch(currentTile.name){
                    case "Start":
                        System.out.println("Si na starte");
                        break;
                    case "Vazenie":
                        System.out.println("Nastevujes vazenie");
                        break;
                    case "Policia":
                        System.out.println("Chytili ta ringle");
                        playerPlaying.setJailTime(3);
                        break;
                    case "Platba dane":
                        if (playerPlaying.getBalance() > 5000){
                            playerPlaying.changeBalance(-5000);
                            System.out.println("Platis dan 3000");
                        }else {
                            players.remove(playerPlaying);
                            playerNumber--;
                            System.out.println("Nemas peniaze na dane, prehravas :/");
                        }
                        break;
                    case "Sanca":
                        System.out.println("sancujes");
                        playerPlaying.changeBalance(chances.getChanceCard(chanceNumber));
                        chanceNumber++;
                        if (chanceNumber > 4){
                            chanceNumber = 0;
                        }

                        break;
                    default:
                        Property currentProperty = (Property) currentTile;
                        if(currentProperty.getOwner() == null){
                            System.out.println("Chces kupit: "+ currentProperty.getName()+"? (zadaj Y pre kupu)");
                            String temp = scan.nextLine();
                            if (temp == "Y"){
                                if (currentProperty.getPrice() > playerPlaying.getBalance()){
                                    System.out.println("Nemas na kupu peniaze :/");                                    
                                }
                                else{
                                    playerPlaying.changeBalance(-currentProperty.getPrice());
                                    System.out.println("Gratulujem, stal si sa majitelom "+ currentProperty.name);  
                                }
                            }
                        }else{
                            if (playerPlaying.getBalance() > currentProperty.getFee()){
                                playerPlaying.changeBalance(-currentProperty.getFee());
                                System.out.print("Hrac " + playerPlaying.getName() + " plati stojne " + currentProperty.getFee() + " hracovi "+ currentProperty.getOwner().getName());
                            }else {
                                currentProperty.getOwner().changeBalance(playerPlaying.getBalance());
                                System.out.println("Hrac " + playerPlaying.getName() + " nema peniaze nastojne a prehrava.");
                                players.remove(playerPlaying);
                                playerNumber--;
                            }
                        }
                    

                }

                playerNumber++;
                if (playerNumber >= players.size()){
                    playerNumber = 0;
                }
            }
            System.out.println("Vyhral "+ players.get(0).getName());
        }
        
    scan.close();
    }


}
