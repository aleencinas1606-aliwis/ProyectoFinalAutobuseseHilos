package com.mycompany.proyectofinalautobusesehilos;

import java.util.Random;

/**
 *
 * @author Equipo5
 */
public class CarreraBuses {
    
public static void iniciarCarrera(int personasMonster, int personasRedbull) {

        System.out.println("\n--- INICIA LA CARRERA DE BUSES ---");

        int posMonster = 0;
        int posRedbull = 0;

        Random rand = new Random();

        /**
         * Mientras ninguno llegue al final
         */
        while (posMonster < 50 && posRedbull < 50) {

            /**
             * El bus que tenga mas personas ira mas lento
             */
            if (personasMonster < personasRedbull) {
                posMonster += rand.nextInt(3) + 1;
                posRedbull += rand.nextInt(2) + 1;
            } 
            else if (personasRedbull < personasMonster) {
                posRedbull += rand.nextInt(3) + 1;
                posMonster += rand.nextInt(2) + 1;
            } 
            else {
                posMonster += rand.nextInt(3) + 1;
                posRedbull += rand.nextInt(3) + 1;
            }

            /**
             * Se dibujan los autobuses en la consola
             */
            dibujarBuses(posMonster, posRedbull);

            try {
                Thread.sleep(200);
            } catch (Exception e) {
                System.out.println("Error en la carrera");
            }
        }

        if (posMonster >= 50 && posRedbull >= 50) {
            System.out.println("\nEMPATE");
        } 
        else if (posMonster >= 50) {
            System.out.println("\nGANA MONSTER");
        } 
        else {
            System.out.println("\nGANA RED BULL");
        }
    }

    /**
     * Con este metodo se dibujan los buses
     * @param m es monster
     * @param r es redbull
     */
    private static void dibujarBuses(int m, int r) {

        limpiarPantalla();

        System.out.println(repetir(" ", m) + "_______________  |");
        System.out.println(repetir(" ", m) + "|__|__|__|__|__|___|)");
        System.out.println(repetir(" ", m) + "|    MONSTER      |)");
        System.out.println(repetir(" ", m) + "|~~~@~~~~~~~~~@~~~|)");
        System.out.println(repetir("_", 70));

        System.out.println(repetir(" ", r) + "_______________  |");
        System.out.println(repetir(" ", r) + "|__|__|__|__|__|___|)");
        System.out.println(repetir(" ", r) + "|   RED BULL      |)");
        System.out.println(repetir(" ", r) + "|~~~@~~~~~~~~~@~~~|)");
        System.out.println(repetir("_", 70));
    }

    /***
     * Metodo donde se repiten los espacios
     * @param txt 
     * @param n
     * @return 
     */
    private static String repetir(String txt, int n) {
        String resultado = "";
        for (int i = 0; i < n; i++) {
            resultado += txt;
        }
        return resultado;
    }

    /**
     * Limpiamos la pantalla
     */
    private static void limpiarPantalla() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}