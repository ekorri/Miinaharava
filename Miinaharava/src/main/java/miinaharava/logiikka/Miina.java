

package miinaharava.logiikka;


public class Miina {
    
    private int xKoordinaatti;
    private int yKoordinaatti;
    
    public Miina(int xKoordinaatti, int yKoordinaatti) {
        this.xKoordinaatti = xKoordinaatti;
        this.yKoordinaatti = yKoordinaatti;
    }

    public int getxKoordinaatti() {
        return xKoordinaatti;
    }

    public void setxKoordinaatti(int xKoordinaatti) {
        this.xKoordinaatti = xKoordinaatti;
    }

    public int getyKoordinaatti() {
        return yKoordinaatti;
    }

    public void setyKoordinaatti(int yKoordinaatti) {
        this.yKoordinaatti = yKoordinaatti;
    }
    
    @Override
    public String toString() {
       return "Koordinaatit: " + this.xKoordinaatti + ", " + this.yKoordinaatti; 
    }
    
    
}
