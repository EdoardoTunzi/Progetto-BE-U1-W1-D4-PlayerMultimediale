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
        System.out.println("Volume: +" + num + " Volume di " + titolo +" = " + volume);
    }

    @Override
    public void abbassaVolume(int num) {
        if(num >0 && num <= volume) {
            volume -= num;
        }
        System.out.println("Volume: -" + num + " Volume di " + titolo +" = " + volume);
    }

    @Override
    public void aumentaLuminosita(int num) {
        if(num > 0) {
            luminosità += num;
        }
        System.out.println("Luminosità di " + titolo + " aumentata di: " + num);

    }

    @Override
    public void diminuisciLuminosita(int num) {
        if(num >0 && num <= luminosità) {
            luminosità -= num;
        }
        System.out.println("Luminosità di " + titolo + " ridotta di: " + num);
    }

    @Override
    public void play() {
        String printVolume = "";
        for(int i = 0; i < volume; i++) {
            printVolume += "! ";
        }
        String printLum = "";
        for(int i = 0; i < luminosità; i++) {
            printLum += "* ";
        }

        for (int i = 0; i < durata; i++) {
            System.out.println(titolo + "Volume:" + printVolume + "Luminosità: " + printLum);
        }
    }
}
