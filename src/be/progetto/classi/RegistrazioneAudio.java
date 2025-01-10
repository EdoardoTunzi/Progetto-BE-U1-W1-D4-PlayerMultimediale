package be.progetto.classi;

import be.progetto.interfacce.Riproducibile;

public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile {

    int volume;
    int durata;

    public RegistrazioneAudio( String titolo, int volume, int durata) {
        super(titolo);
        this.volume = volume;
        this.durata = durata;
    }

    @Override
    public void alzaVolume() {

    }

    @Override
    public void abbassaVolume() {

    }

    @Override
    public void play() {

    }
}
