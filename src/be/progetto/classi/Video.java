package be.progetto.classi;

import be.progetto.interfacce.Luminosità;
import be.progetto.interfacce.Riproducibile;

public class Video extends ElementoMultimediale implements Riproducibile, Luminosità {
    int volume;
    int durata;
    int luminosità;

    public Video(String titolo, int volume, int durata) {
        super(titolo);
        this.volume = volume;
        this.durata = durata;
    }

    @Override
    public void alzaVolume(int num) {
        if(num > 0) {
            volume += num;
        }
    }

    @Override
    public void abbassaVolume(int num) {
        if(num >0 && num <= volume) {
            volume -= num;
        }
    }

    @Override
    public void aumentaLuminosita(int num) {
        if(num > 0) {
            luminosità += num;
        }

    }

    @Override
    public void diminuisciLuminosita(int num) {
        if(num >0 && num <= luminosità) {
            luminosità -= num;
        }
    }

    @Override
    public void play() {

    }
}
