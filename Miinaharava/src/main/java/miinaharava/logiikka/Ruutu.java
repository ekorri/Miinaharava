package miinaharava.logiikka;

/**
 * Luokka luo ruudun, joista pelin pelilauta koostuu. Ruutu tietää oman
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
    
    /**
     * Metodi kertoo, onko ruutu avattu.
     * 
     * @return true tai false, sen mukaan onko ruutu avattu vai ei
     */
    public boolean avattu() {
        return avattu;
    }
    
    /**
     * Metodi asettaa ruudun avatuksi tai suljetuksi
     * 
     * @param avattu true tai false
     */
    public void setAvattu(boolean avattu) {
        this.avattu = avattu;
    }
    
    /**
     * Metodi kertoo onko ruudussa miina.
     * 
     * @return true tai false sen mukaan onko ruudussa miina vai ei 
     */
    public boolean onkoRuudussaMiina() {
        return onkoRuudussaMiina;
    }
    
    /**
     * Metodi asettaa ruudun tilan sen mukaan, onko ruudussa miina vai ei
     * 
     * @param onkoRuudussaMiina true tai false
     */
    public void setOnkoRuudussaMiina(boolean onkoRuudussaMiina) {
        this.onkoRuudussaMiina = onkoRuudussaMiina;
    }
    
    /**
     * Metodi tarkistaa onko ruudussa merkki, "lippu"
     * 
     * @return true tai false sen mukaan onko ruudussa merkki vai ei
     */
    public boolean onkoLiputettu() {
        return onkoLiputettu;
    }
    
    /**
     * Metodi asettaa ruudun tilan liputetuksi tai ei-liputetuksi
     * 
     * @param onkoLiputettu true tai false
     */
    public void setOnkoLiputettu(boolean onkoLiputettu) {
        this.onkoLiputettu = onkoLiputettu;
    }
    
    /**
     * Metodi asettaa ruutuun arvon
     * 
     * @param arvo merkki, joka ruutuun halutaan asettaa 
     */
    public void setArvo(String arvo) {
        this.arvo = arvo;
    }
    
    /**
     * Metodi palauttaa ruudussa olevan arvon
     * 
     * @return ruudun arvo, joka on joko tyhjä, [ ], numero 1-8, P tai *
     */
    public String getArvo() {
        return arvo;
    }
    
    
    /**
     * Metodi palauttaa ruudun merkkijonona eli sen arvon
     * @return ruudussa oleva arvo
     */
    @Override
    public String toString() {
        return this.arvo;
    }

}
