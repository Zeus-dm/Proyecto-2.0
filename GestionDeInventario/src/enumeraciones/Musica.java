
package enumeraciones;

public enum Musica {
    CHAYANNE_TORERO("/gui/musica/chayanne_torero.wav"),
    CAMILLE_LE_FESTIN("/gui/musica/camille_le_festin.wav"),
    
    MUSICA_ACTUAL(CAMILLE_LE_FESTIN.getMusica());
    
    private String musica;

    private Musica(String musica) {
        this.musica = musica;
    }
    
    public void setMusica(String musica){
        this.musica = musica;
    }
    
    public String getMusica(){
        return this.musica;
    }
}
