package components;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TripulantCabina extends Tripulant {



    private int barres;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe menys dataAlta i barres.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres.
     - Inicialitzar l'atribut dataAlta amb l'hora actual del sistema.
     - Inicialitzar l'atribut barres mitjançant el mètode pertinent d'aquesta classe.
     */
    public TripulantCabina(String passaport, String nom, int edat, Date dataAlta, int horesVol, String rang, int barres) {
        super(passaport,nom,edat,dataAlta,horesVol,rang);
        this.barres=barres;
    }


    /*
    Mètodes accessors
     */
    

    public int getBarres() {
        return barres;
    }

    public void setBarres(int barres) {
        this.barres = barres;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou tripulant de cabina.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que el nom no té per què estar format per una única 
    paraula, per exemple, Pep Gómez.
    - També heu de tenir en compte que les hores de vol són de tipus LocalTime, per
    tant heu de demanar a l'usuari les hores i minuts per crear el LocalTime. En aquest
    cas es considerarà que els segons i nanosegons, sempre són  0.
    -  Li demanarà a l'usuari el rang del tripulant de cabina tenint en compte que
    "C" serà el que ha d'introduir l'usuari si el rang és comandant, "CP" si és
    copilot i "EV" si és enginyer de vol.
    - Si no introdueix cap dels tres rangs, no se li assignarà cap valor al rang i se 
    li mostrarà a l'usuari el missatge "\nEl rang introduït no és correcte".
    - Si el rang introduït és correcte, se li assignarà a l'atribut rang "Comandant"
    en cas que el valor introduït sigui "C", "Copilot" en cas que el valor introduït
    sigui "CP" i "Enginyer de vol" en cas que el valor introduït sigui "EV".
    Retorn: El nou tripulant de cabina.
     */
    public static TripulantCabina nouTripulantCabina() {
        String passaport, nom, rang;
        int edat, hores;

        System.out.println("\nPassaport del tripulant:");
        passaport = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nNom del tripulant:");
        nom = DADES.nextLine();
        System.out.println("\nEdat del tripulant:");
        edat = DADES.nextInt();

        System.out.println("\nHores de vol del tripulant:");
        hores = DADES.nextInt();

        System.out.println("\nQuin rang té el tripulant?: C-Comandant, CP-Copilot, EV-Enginyer de vol");
        rang = DADES.next();

        return new TripulantCabina(passaport, nom, edat, hores, rang);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte menys data d'alta.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los. En el cas de les hores de vol, només se li han
     de mostrar les hores i minuts.
     - Si es vol modificar el rang, a l'hora de demanar-li el nou rang a l'usuari
     haurem de fer el mateix que en el mètode nouTripulantCabina, però en aquest 
     cas, si no s'introdueix un rang correcte, en lloc de no assignar-li res a 
     l'atribut rang, el que farem és no modificar el seu valor actual.
     - Abans de modificar el valor del rang, hem de comprovar que el nou valor 
     compleix els requisits especificats en l'enunciat de la pràctica de la UF1 
     del mòdul 5, és a dir, un Enginyer de cabina pot passar a ser còpilot si té 5
     o més anys d'antiguetat, i un copilot pot passar a ser comandant, si té 15 
     o més anys d'antiguetat.
     - Si modifiquem el valor del rang, també haurem de modificar el valor de les
     barres amb el mètode adient d'aquesta classe.
    
     NOTA: 5 anys són 157788000 segons.
    
     Retorn: cap
     */
    public void modificarTripulantCabina() {

        System.out.println("\nEl passaport actual del tripulant és:" + passaport);
        System.out.println("\nQuin és el nou passaport del tripulant?");
        passaport = DADES.next();
        DADES.nextLine(); //Neteja de buffer
        System.out.println("\nEl nom actual del tripulant és:" + nom);
        System.out.println("\nQuin és el nou nom del tripulant?");
        nom = DADES.nextLine();
        System.out.println("\nL'edat actual del tripulant és:" + edat);
        System.out.println("\nQuina és la nova edat del tripulant?");
        edat = DADES.nextInt();

        System.out.println("Les hores de vol actuals del tripulant són:" + horesVol);
        System.out.println("\nQuines són les hores de vol actuals del tripulant:");
        horesVol = DADES.nextInt();

        System.out.println("\nEl rang actual del tripulant és:" + rang);
        System.out.println("\nQuin és el nou rang del tripulant?: C-Comandant, CP-Copilot, EV-Enginyer de vol");
        assignarBarres(DADES.next());

    }

    public void mostrarTripulantCabina() {
        System.out.println("\nLes dades del tripulant de cabina amb passaport " + passaport + " són:");
        System.out.println("\nNom: " + nom);
        System.out.println("\nEdat: " + edat);
        System.out.println("\nData d'alta: " + new SimpleDateFormat("dd-MM-yyyy").format(dataAlta));
        System.out.println("\nHores de vol: " + horesVol);
        System.out.println("\nRang: " + rang);
        System.out.println("\nBarres: " + barres);
    }

    /*
     Paràmetres: rang
     Accions:
     - Se li assignarà a l'atribut barres el valor corresponent segons el rang introduït
     per paràmetre i les especificacions de l'enunciat de la UF1 del mòdul 5, és a dir, 
     en el cas del copilot, 2 barres si té menys de 1500 hores de vol i 3 si té 1500 o més, 
     en el cas del comandant sempre 4 i en el cas de l'enginyer de vol sempre 1.
     Retorn: cap
     */
    public void assignarBarres(String pRang) {

        switch (pRang) {
            case "C":
                rang = "Comandant";
                barres = 4;
                break;
            case "CP":
                rang = "Copilot";
                if (horesVol < 1500) {
                    barres = 2;
                } else {
                    barres = 3;
                }
                break;
            case "EV":
                rang = "Enginyer de vol";
                barres = 1;
                break;
            default:
                System.out.println("\nEl rang no és correcte");
                break;
        }

    }

}
