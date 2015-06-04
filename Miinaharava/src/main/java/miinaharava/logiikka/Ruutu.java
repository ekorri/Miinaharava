package miinaharava.logiikka;

/**
 * Tämä luokka luo ruudun, joista pelin pelilauta koostuu. Ruutu tietää oman
 * tilansa: onko se avattu, onko siinä, miina tai lippu.
 * 
 * @author Eevastiina Korri
 */
public class Ruutu {

    
    private boolean avattu;
    private boolean onkoRuudussaMiina;
    private boolean onkoLiputettu;
    private String arvo;

    public Ruutu(String arvo) {        
        this.avattu = false;
        this.onkoRuudussaMiina = false;
        this.onkoLiputettu = false;
        this.arvo = arvo;

    }

    public boolean avattu() {
        return avattu;
    }

    public void setAvattu(boolean avattu) {
        this.avattu = avattu;
    }

    public boolean onkoRuudussaMiina() {
        return onkoRuudussaMiina;
    }

    public void setOnkoRuudussaMiina(boolean onkoRuudussaMiina) {
        this.onkoRuudussaMiina = onkoRuudussaMiina;
    }

    public boolean onkoLiputettu() {
        return onkoLiputettu;
    }

    public void setOnkoLiputettu(boolean onkoLiputettu) {
        this.onkoLiputettu = onkoLiputettu;
    }

    public void setArvo(String arvo) {
        this.arvo = arvo;
    }

    public String getArvo() {
        return arvo;
    }
    
    

    @Override
    public String toString() {
        return this.arvo;
    }

}
