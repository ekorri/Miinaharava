package miinaharava.logiikka;

public class Ruutu {

    
    private boolean avattu;
    private boolean onkoRuudussaMiina;
    private boolean onkoLiputettu;
    private String testi;

    public Ruutu(String testi) {        
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

    public void setTesti(String arvo) {
        this.testi = arvo;
    }

    public String getTesti() {
        return testi;
    }
    
    

    @Override
    public String toString() {
        return this.testi;
    }

}
