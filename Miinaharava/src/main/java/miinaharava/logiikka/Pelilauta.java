package miinaharava.logiikka;

import java.util.ArrayList;
import java.util.Random;

public class Pelilauta {

    private int leveys;
    private int korkeus;
    private int miinoja;
    private Random random;
    private Ruutu[][] ruudukko;

    public Pelilauta(int leveys, int korkeus, int miinoja) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.miinoja = miinoja;
        this.random = new Random();
        this.ruudukko = new Ruutu[this.leveys][this.korkeus];
        for (int i = 0; i < this.leveys; i++) {
            for (int j = 0; j < this.korkeus; j++) {
                ruudukko[i][j] = new Ruutu("X");
            }
        }
    }

    public void tulostaRuudukko() {
        for (int i = 0; i < leveys; i++) {
            for (int j = 0; j < korkeus; j++) {
                System.out.print(ruudukko[i][j]);
            }
            System.out.println("");
        }
    }

    public int getLeveys() {
        return leveys;
    }

    public int getKorkeus() {
        return korkeus;
    }

    public int getMiinoja() {
        return miinoja;
    }

    public Ruutu getRuutu(int x, int y) {
        return ruudukko[x][y];
    }

    public void asetaMiinat() {
        for (int i = 0; i < this.miinoja; i++) {
            Miina miina = new Miina(random.nextInt(this.leveys), random.nextInt(this.korkeus));
            ruudukko[miina.getxKoordinaatti()][miina.getyKoordinaatti()].setOnkoRuudussaMiina(true);
        }
    }

    public void avaaRuutu(int x, int y) {
        if (x < 0 || x > this.leveys - 1 || y < 0 || y > this.korkeus - 1) {
            return;
        }
        if (ruudukko[x][y].isAvattu() == true) {
            return;
        }
        ruudukko[x][y].setAvattu(true);
//        if (ruudukko[x][y].isOnkoRuudussaMiina() == true) {
//            ruudukko[x][y].setTesti("*");
//        }
//        
//        if (ruudukko[x][y].isOnkoRuudussaMiina() == false) {
//            this.merkitseNumero(x, y);
//
//        }

    }

    public void liputaRuutu(int x, int y) {
        ruudukko[x][y].setOnkoLiputettu(true);
        ruudukko[x][y].setTesti("P");
    }

    public int getYmparillaOlevienMiinojenMaara(int x, int y) {
        int laskuri = 0;
        if (x != 0 && x != this.leveys - 1 && y != 0 && y != this.korkeus - 1) {
            if (ruudukko[x - 1][y].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x - 1][y - 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x - 1][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x][y - 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y - 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
        } else if (x == 0 && y != 0 && y != this.korkeus - 1) {
            if (ruudukko[x][y - 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y - 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
        } else if (x != 0 && x != this.leveys - 1 && y == 0) {
            if (ruudukko[x - 1][y].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x - 1][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
        } else if (x == 0 && y == 0) {
            if (ruudukko[x + 1][y].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
        } else if (x == this.leveys - 1 && y == 0) {
            if (ruudukko[x - 1][y].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x - 1][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x][y + 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
        } else if (x == 0 && y == this.korkeus - 1) {
            if (ruudukko[x][y - 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y - 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x + 1][y].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
        } else if (x == this.leveys - 1 && y == this.korkeus - 1) {
            if (ruudukko[x][y - 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x - 1][y - 1].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
            if (ruudukko[x - 1][y].isOnkoRuudussaMiina() == true) {
                laskuri++;
            }
        }
        return laskuri;
    }

    public void merkitseNumero(int x, int y) {
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 0) {
            ruudukko[x][y].setTesti("0");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 1) {
            ruudukko[x][y].setTesti("1");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 2) {
            ruudukko[x][y].setTesti("2");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 3) {
            ruudukko[x][y].setTesti("3");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 4) {
            ruudukko[x][y].setTesti("4");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 5) {
            ruudukko[x][y].setTesti("5");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 6) {
            ruudukko[x][y].setTesti("6");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 7) {
            ruudukko[x][y].setTesti("7");
        }
        if (this.getYmparillaOlevienMiinojenMaara(x, y) == 8) {
            ruudukko[x][y].setTesti("8");
        }
    }

    public void avaaYmparillaOlevat(int x, int y) {
        if (x != 0 && x != this.leveys - 1 && y != 0 && y != this.korkeus - 1) {
            if (ruudukko[x - 1][y].isOnkoRuudussaMiina() == false) {
                ruudukko[x - 1][y].setAvattu(true);
                this.merkitseNumero(x - 1, y);
            }
            if (ruudukko[x - 1][y - 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x - 1][y - 1].setAvattu(true);
                this.merkitseNumero(x - 1, y - 1);
            }
            if (ruudukko[x - 1][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x - 1][y + 1].setAvattu(true);
                this.merkitseNumero(x - 1, y + 1);
            }
            if (ruudukko[x][y - 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x][y - 1].setAvattu(true);
                this.merkitseNumero(x, y - 1);
            }
            if (ruudukko[x][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x][y + 1].setAvattu(true);
                this.merkitseNumero(x, y + 1);
            }
            if (ruudukko[x + 1][y].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y].setAvattu(true);
                this.merkitseNumero(x + 1, y);
            }
            if (ruudukko[x + 1][y - 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y - 1].setAvattu(true);
                this.merkitseNumero(x + 1, y - 1);
            }
            if (ruudukko[x + 1][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y + 1].setAvattu(true);
                this.merkitseNumero(x + 1, y + 1);
            }
        } else if (x == 0 && y != 0 && y != this.korkeus - 1) {
            if (ruudukko[x][y - 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x][y - 1].setAvattu(true);
                this.merkitseNumero(x, y - 1);
            }
            if (ruudukko[x][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x][y + 1].setAvattu(true);
                this.merkitseNumero(x, y + 1);
            }
            if (ruudukko[x + 1][y].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y].setAvattu(true);
                this.merkitseNumero(x + 1, y);
            }
            if (ruudukko[x + 1][y - 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y - 1].setAvattu(true);
                this.merkitseNumero(x + 1, y - 1);
            }
            if (ruudukko[x + 1][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y + 1].setAvattu(true);
                this.merkitseNumero(x + 1, y + 1);
            }
        } else if (x != 0 && x != this.leveys - 1 && y == 0) {
            if (ruudukko[x - 1][y].isOnkoRuudussaMiina() == false) {
                ruudukko[x - 1][y].setAvattu(true);
                this.merkitseNumero(x - 1, y);
            }
            if (ruudukko[x + 1][y].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y].setAvattu(true);
                this.merkitseNumero(x + 1, y);
            }
            if (ruudukko[x - 1][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x - 1][y + 1].setAvattu(true);
                this.merkitseNumero(x - 1, y + 1);
            }
            if (ruudukko[x][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x][y + 1].setAvattu(true);
                this.merkitseNumero(x, y + 1);
            }
            if (ruudukko[x + 1][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y + 1].setAvattu(true);
                this.merkitseNumero(x + 1, y + 1);
            }
        } else if (x == 0 && y == 0) {
            if (ruudukko[x + 1][y].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y].setAvattu(true);
                this.merkitseNumero(x + 1, y);
            }
            if (ruudukko[x + 1][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y + 1].setAvattu(true);
                this.merkitseNumero(x + 1, y + 1);
            }
            if (ruudukko[x][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x][y + 1].setAvattu(true);
                this.merkitseNumero(x, y + 1);
            }
        } else if (x == this.leveys - 1 && y == 0) {
            if (ruudukko[x - 1][y].isOnkoRuudussaMiina() == false) {
                ruudukko[x - 1][y].setAvattu(true);
                this.merkitseNumero(x - 1, y);
            }
            if (ruudukko[x - 1][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x - 1][y + 1].setAvattu(true);
                this.merkitseNumero(x - 1, y + 1);
            }
            if (ruudukko[x][y + 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x][y + 1].setAvattu(true);
                this.merkitseNumero(x, y + 1);
            }
        } else if (x == 0 && y == this.korkeus - 1) {
            if (ruudukko[x][y - 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x][y - 1].setAvattu(true);
                this.merkitseNumero(x, y - 1);
            }
            if (ruudukko[x + 1][y - 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y - 1].setAvattu(true);
                this.merkitseNumero(x + 1, y - 1);
            }
            if (ruudukko[x + 1][y].isOnkoRuudussaMiina() == false) {
                ruudukko[x + 1][y].setAvattu(true);
                this.merkitseNumero(x + 1, y);
            }
        } else if (x == this.leveys - 1 && y == this.korkeus - 1) {
            if (ruudukko[x][y - 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x][y - 1].setAvattu(true);
                this.merkitseNumero(x, y - 1);
            }
            if (ruudukko[x - 1][y - 1].isOnkoRuudussaMiina() == false) {
                ruudukko[x - 1][y - 1].setAvattu(true);
                this.merkitseNumero(x - 1, y - 1);
            }
            if (ruudukko[x - 1][y].isOnkoRuudussaMiina() == false) {
                ruudukko[x - 1][y].setAvattu(true);
                this.merkitseNumero(x - 1, y);
            }
        }
    }
    
    public void avatunRuudunKasittely(int x, int y) {
        if (ruudukko[x][y].isOnkoRuudussaMiina() == true) {
            ruudukko[x][y].setTesti("*");
        }
        
        if (ruudukko[x][y].isOnkoRuudussaMiina() == false) {
            this.merkitseNumero(x, y);
        }
        
        if (ruudukko[x][y].isOnkoRuudussaMiina() == false && this.getYmparillaOlevienMiinojenMaara(x, y) == 0) {
            this.avaaYmparillaOlevat(x, y);
        }
    }
}
