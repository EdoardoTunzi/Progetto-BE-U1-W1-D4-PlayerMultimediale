import be.progetto.classi.ElementoMultimediale;
import be.progetto.classi.Immagine;
import be.progetto.classi.RegistrazioneAudio;
import be.progetto.classi.Video;
import be.progetto.interfacce.Luminosità;
import be.progetto.interfacce.Riproducibile;

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
        //----------------------------------sezione creazione elementi multimediali-----------------------------------
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
        //-------------------------------------sezione scelta riproduzione-------------------------------------------
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
                //downcasting necessario per accedere ai metodi delle istanze delle sottoclassi
               if ( elementoSelezionato instanceof Immagine) {
                   //richiesta di modifica valori prima di esecuzione con metodo( a fine codice) per maggiore leggibilità, visto che era troppo lungo
                  gestioneLuminosità((Luminosità) elementoSelezionato, scanner);
                   System.out.println("Eseguo " + elementoSelezionato.titolo);
                   ((Immagine) elementoSelezionato).show();

               } else if (elementoSelezionato instanceof Video) {
                   gestioneVolume((Riproducibile) elementoSelezionato, scanner);
                   gestioneLuminosità((Luminosità) elementoSelezionato, scanner);
                   System.out.println("Eseguo " + elementoSelezionato.titolo);
                   ((Video) elementoSelezionato).play();

               } else if (elementoSelezionato instanceof RegistrazioneAudio) {
                   gestioneVolume((Riproducibile) elementoSelezionato, scanner);
                   System.out.println("Eseguo " + elementoSelezionato.titolo);
                   ((RegistrazioneAudio) elementoSelezionato).play();
               }

           } else if(sceltaElemento !=0) { //controllo necessario perchè senza mi stampava questo messaggio anche se terminavo il player con 0
               System.out.println("Scelta non valida, Riprova inserendo un numero da 1 a 5 per selezionare un elemento.");
           }
        } while (sceltaElemento !=0);

        System.out.println("Player spento. Programma terminato.");

    }
    //--------------------------------metodi per gestione luminosità e durata parte utente------------------------


    //utilizzo l'interfaccia come type per l'elemento selezionato così il metodo può essere utilizzato sia da Immagine che Video

    public static void gestioneLuminosità(Luminosità elementoSelezionato, Scanner scanner) {
        System.out.println("Vuoi modificare la luminosità prima di eseguirlo? ");
        System.out.println("1 = Si , 2 = No");
        int selezione = scanner.nextInt();


        if (selezione == 1) {
            System.out.println("Inserisci: 1 - per aumentare la luminosità, 2 - per ridurre la luminosità");
            int selezLum = scanner.nextInt();
            if (selezLum == 1) {
                System.out.println("Inserisci valore numerico per aumentare la luminosità");
                int newLum1 = scanner.nextInt();
                elementoSelezionato.aumentaLuminosita(newLum1);

            } else if (selezLum == 2) {
                System.out.println("Inserisci valore numerico per ridurre la luminosità");
                int newLum2 = scanner.nextInt();
                elementoSelezionato.diminuisciLuminosita(newLum2);

            }


        } else if (selezione == 2) {
            System.out.println("Passo a Riproduzione...");
            //Tentativo di riproduzione inutile, perchè è meglio gestire la riproduzione dopo l'invocazione di questo metodo, che deve gestire solo la luminosità.
            /*if (elementoSelezionato instanceof Immagine) {
                ((Immagine) elementoSelezionato).show();
            } else if (elementoSelezionato instanceof Video) {
                ((Video) elementoSelezionato).play();
            }*/

        } else {
            System.out.println("Selezione non valida");
        }
    }

    //metodo simile ma con Riproducibile come parametro, per gestione volume.
    public static void gestioneVolume(Riproducibile elementoSelezionato, Scanner scanner) {
        System.out.println("Vuoi modificare il volume prima di eseguirlo? ");
        System.out.println("1 = Si , 2 = No");
        int selezione = scanner.nextInt();


        if (selezione == 1) {
            System.out.println("Inserisci: 1 - per aumentare volume, 2 - per ridurre volume");
            int selezVol = scanner.nextInt();

            if (selezVol == 1) {
                System.out.println("Inserisci valore numerico per aumentare volume");
                int newVol1 = scanner.nextInt();
                elementoSelezionato.alzaVolume(newVol1);
            } else if (selezVol == 2) {
                System.out.println("Inserisci valore numerico per ridurre volume");
                int newVol2 = scanner.nextInt();
                elementoSelezionato.abbassaVolume(newVol2);
            }

        } else if (selezione == 2) {
            System.out.println("Ok continuo");
        } else {
            System.out.println("Selezione non valida");
        }
    }
 }