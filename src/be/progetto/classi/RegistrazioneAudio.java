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
    public void play() {
        String printVolume = "";
        for(int i = 0; i < volume; i++) {
            printVolume += "*";
        }
        System.out.println(titolo + "Volume:" + printVolume);
    }
}
