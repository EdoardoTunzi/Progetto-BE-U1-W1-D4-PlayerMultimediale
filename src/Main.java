import be.progetto.classi.ElementoMultimediale;
import be.progetto.classi.Immagine;
import be.progetto.classi.RegistrazioneAudio;
import be.progetto.classi.Video;

public class Main {
    public static void main(String[] args) {
        Video v1 = new Video("video1", 3, 2);
        Immagine im1 = new Immagine("foto1", 6);
        RegistrazioneAudio reg1 = new RegistrazioneAudio("audio1", 10, 3);

        System.out.println(v1.titolo);
        v1.aumentaLuminosita(4);
        v1.alzaVolume(6);
        v1.diminuisciLuminosita(2);
        v1.abbassaVolume(2);
        v1.play();
        System.out.println(im1.titolo);
        im1.diminuisciLuminosita(3);
        im1.aumentaLuminosita(4);
        im1.show();
        System.out.println(reg1.titolo);
        reg1.abbassaVolume(2);
        reg1.alzaVolume(5);
        reg1.play();

    }
}