
package enumeraciones;

public enum Musica {
    SWEDEN("/gui/musica/sweden.wav"),
    
    MUSICA_ACTUAL(SWEDEN.getMusica());
    
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
