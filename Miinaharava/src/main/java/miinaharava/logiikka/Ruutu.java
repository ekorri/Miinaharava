package miinaharava.logiikka;

public class Ruutu {

    
    private boolean avattu;
    private boolean onkoRuudussaMiina;
    private boolean onkoLiputettu;
    private int testi;

    public Ruutu(int testi) {        
        this.avattu = false;
        this.onkoRuudussaMiina = false;
        this.onkoLiputettu = false;
        this.testi = testi;

    }

    public boolean isAvattu() {
        return avattu;
    }

    public void setAvattu(boolean avattu) {
        this.avattu = avattu;
    }

    public boolean isOnkoRuudussaMiina() {
        return onkoRuudussaMiina;
    }

    public void setOnkoRuudussaMiina(boolean onkoRuudussaMiina) {
        this.onkoRuudussaMiina = onkoRuudussaMiina;
    }

    public boolean isOnkoLiputettu() {
        return onkoLiputettu;
    }

    public void setOnkoLiputettu(boolean onkoLiputettu) {
        this.onkoLiputettu = onkoLiputettu;
    }

    

    @Override
    public String toString() {
        return "" + this.testi;
    }

}
