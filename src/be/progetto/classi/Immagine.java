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

    public void show() {
        String luminositaPrint = "";
        for(int i = 0; i < luminosità; i++) {
            luminositaPrint += "*";
        }
        System.out.println(titolo + "Luminosità:" + luminositaPrint);
    }
}
