package be.progetto.classi;

import be.progetto.interfacce.Luminosità;

public class Immagine extends ElementoMultimediale implements Luminosità {

    int luminosità;

    public Immagine (String titolo, int luminosità) {
        super(titolo);
        this.luminosità = luminosità;
    }
    @Override
    public void aumentaLuminosita(int num) {
        luminosità += num;

    }

    @Override
    public void diminuisciLuminosita(int num) {
        if(num <= luminosità) {
            luminosità -= num;
        }
    }

    public void show() {

    }
}
