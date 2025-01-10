package be.progetto.classi;

import be.progetto.interfacce.Luminosità;
import be.progetto.interfacce.Riproducibile;

public class Video extends ElementoMultimediale implements Riproducibile, Luminosità {
    int volume;
    int durata;

    public Video(String titolo, int volume, int durata) {
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
    public void aumentaLuminosita(int num) {

    }

    @Override
    public void diminuisciLuminosita(int num) {

    }

    @Override
    public void play() {

    }
}
