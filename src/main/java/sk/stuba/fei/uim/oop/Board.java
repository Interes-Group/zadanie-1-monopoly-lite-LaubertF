package sk.stuba.fei.uim.oop;


public class Board {
    
    private Tile[] tiles = {new SpecialTile(), //Start 0
                    new Property(),
                    new Property(),
                    new SpecialTile(), //Sanca 3
                    new Property(),
                    new Property(),
                    new SpecialTile(), //Vazenie 6
                    new Property(),
                    new Property(),
                    new SpecialTile(), //Sanca 9
                    new Property(),
                    new Property(),
                    new SpecialTile(), //Policia   12
                    new Property(),
                    new Property(),
                    new SpecialTile(), //Sanca 15
                    new Property(),
                    new Property(),
                    new SpecialTile(), //Daniaren 18
                    new Property(),
                    new Property(),
                    new SpecialTile(), //Sanca 21
                    new Property(),
                    new Property(), //23
                };
    Board(){
        tiles[0].setName("Start");
        tiles[1].setName("AB300");  //AB300 AB150 BC300 BC150 CD300 CD150 DE300 DE150
        tiles[2].setName("AB150");
        tiles[3].setName("Sanca");
        tiles[4].setName("BC300");
        tiles[5].setName("BC150");
        tiles[6].setName("Vazenie");
        tiles[7].setName("CD300");
        tiles[8].setName("CD150");
        tiles[9].setName("Sanca");
        tiles[10].setName("DE300");
        tiles[11].setName("DE150");
        tiles[12].setName("Policia");
        tiles[13].setName("CPU");
        tiles[14].setName("Plavaren");
        tiles[15].setName("Sanca");
        tiles[16].setName("Velka telocvicna");
        tiles[17].setName("Mala telocvicna");
        tiles[18].setName("Platba dane");
        tiles[19].setName("D712");
        tiles[20].setName("C517");
        tiles[21].setName("Sanca");
        tiles[22].setName("Posilnovna");
        tiles[23].setName("C117");
    }
    public Tile getTile(int tileNumber) {
        return tiles[tileNumber];
    }
}
