import be.progetto.classi.ElementoMultimediale;
import be.progetto.classi.Immagine;
import be.progetto.classi.RegistrazioneAudio;
import be.progetto.classi.Video;

import java.util.Scanner;

public class MediaPlayer {
    public static void main(String[] args) {
        //TEST

        /*Video v1 = new Video("video1", 3, 2);
        Immagine im1 = new Immagine("foto1", 6);
        RegistrazioneAudio reg1 = new RegistrazioneAudio("audio1", 10, 3);*/

        /*System.out.println(v1.titolo);
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
        reg1.play();*/

        // IMPLEMENTAZIONE PLAYER

        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];

        System.out.println("Accensione Player");
        for (int i = 0; i < elementi.length ; i++) {
            System.out.println("Crea il " + (i+1) +"° elemento multimediale:");
            System.out.println("Scegli il tipo inserendo il numero corrispondente (1. Immagine, 2. Video, 3. Audio) :");
            int tipo = scanner.nextInt();
            scanner.nextLine();

            switch (tipo) {
                case 1:
                    System.out.println("Hai scelto immagine");
                    System.out.println("Inserisci titolo:");
                    String titoloImg = scanner.nextLine();
                    System.out.println("Inserisci luminosità:");
                    int luminosità = scanner.nextInt();
                    elementi[i] = new Immagine(titoloImg,luminosità);
                    System.out.println("Immagine: " + titoloImg + " creata con successo!");
                    break;
                case 2:
                    System.out.println("Hai scelto video");
                    System.out.println("Inserisci titolo:");
                    String titoloVd = scanner.nextLine();
                    System.out.println("Inserisci il volume:");
                    int volumeVideo = scanner.nextInt();
                    System.out.println("Inserisci la durata del video:");
                    int durataVideo = scanner.nextInt();
                    elementi[i] = new Video(titoloVd, volumeVideo, durataVideo);
                    System.out.println("Video: " + titoloVd + " creato con successo!");
                    break;
                case 3:
                    System.out.println("Hai scelto Audio");
                    System.out.println("Inserisci titolo:");
                    String titoloA = scanner.nextLine();
                    System.out.println();
                    System.out.println("Inserisci il volume:");
                    int volumeAudio = scanner.nextInt();
                    System.out.println("Inserisci la durata:");
                    int durataAudio = scanner.nextInt();
                    elementi[i] = new RegistrazioneAudio(titoloA, volumeAudio, durataAudio);
                    System.out.println("Audio: " + titoloA + " creato con successo!");
                    break;
                default:
                    System.out.println("Tipo inserito non valido, riprova inserendo un tipo valido tra quelli richiesti.");
                    i--; //faccio ripetere l'iterazione per non perdere la posizione nell'array.
            }
        }

        if(elementi.length == 5) {
            System.out.println(" 5 elementi creati con successo!");
        }

        int sceltaElemento;

        do {
            System.out.println("Quale elemento vuoi riprodurre? Scegli il numero corrispondente all'elemento:");
            System.out.println("1 :" + elementi[0].titolo);
            System.out.println("2 :" + elementi[1].titolo);
            System.out.println("3 :" + elementi[2].titolo);
            System.out.println("4 :" + elementi[3].titolo);
            System.out.println("5 :" + elementi[4].titolo);
            System.out.println("Inserisci 0 per uscire dal player");

            sceltaElemento = scanner.nextInt();
           if (sceltaElemento >=1 && sceltaElemento <= 5) {
               ElementoMultimediale elementoSelezionato = elementi[sceltaElemento - 1];

               if ( elementoSelezionato instanceof Immagine) {
                   ((Immagine) elementoSelezionato).show();
               } else if (elementoSelezionato instanceof Video) {
                   ((Video) elementoSelezionato).play();
               } else {
                   ((RegistrazioneAudio) elementoSelezionato).play();
               }
           } else if(sceltaElemento !=0) {
               System.out.println("Scelta non valida, Riprova inserendo un numero da 1 a 5 per selezionare un elemento.");
           }
        } while (sceltaElemento !=0);

        System.out.println("Player spento. Programma terminato.");

    }
}