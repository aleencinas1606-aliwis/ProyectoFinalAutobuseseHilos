package com.mycompany.proyectofinalautobusesehilos;
import java.util.Scanner;
/**
 *
 * @author Equipo5
 */
public class ProyectoFinalAutobuseseHilos {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        Autobus monster = new Autobus("MONSTER", 10);
        Autobus redbull = new Autobus("RED BULL", 10);

        int contador = 1;
        boolean seguir = true;

        while (seguir) {

            /**
             * Verificamos si los autobuses estan lleno
             */
            if (monster.estaLleno() && redbull.estaLleno()) {
                System.out.println("\nYA NO SE PUEDEN RESERVAR MAS ASIENTOS");
                break;
            }

            System.out.println("\nCLIENTE " + contador);
            monster.mostrarDisponibles();
            redbull.mostrarDisponibles();

            int busElegido = 0;

            while (busElegido != 1 && busElegido != 2) {
                System.out.println("\nElige autobus:");
                System.out.println("1 = MONSTER");
                System.out.println("2 = RED BULL");

                if (sc.hasNextInt()) {
                    busElegido = sc.nextInt();
                } else {
                    System.out.println("Debes elegir el bus 1 o 2");
                    sc.next();
                }
            }

            Autobus bus = (busElegido == 1) ? monster : redbull;

            /**
             * Verificamos si el bus que esta eligiendo esta lleno
             */
            if (bus.estaLleno()) {
                System.out.println("Ese autobus ya esta lleno");
                continue;
            }

            int asiento = 0;

            while (true) {
                System.out.println("Elige asiento del 1 al 10:");

                if (sc.hasNextInt()) {
                    asiento = sc.nextInt();

                    if (asiento >= 1 && asiento <= 10) {

                        Thread t = new Thread(new Clientes(contador, bus, asiento));
                        t.start();
                        t.join();

                        if (bus.estaReservado(asiento)) {
                            break;
                        } else {
                            System.out.println("Quieres intentar con otro asiento");
                        }

                    } else {
                        System.out.println("Debes elegir un numero del 1 al 10");
                    }

                } else {
                    System.out.println("Debes escribir solo numeros");
                    sc.next();
                }
            }

            contador++;

            /**
             * Preguntmos si deses seguir la compra de los boletos
             */
            System.out.println("\nQuieres seguir registrando compras");
            System.out.println("1 = Si");
            System.out.println("2 = No");

            int opcion = 0;

            while (opcion != 1 && opcion != 2) {
                if (sc.hasNextInt()) {
                    opcion = sc.nextInt();
                } else {
                    System.out.println("Debes escribir 1 o 2");
                    sc.next();
                }
            }

            if (opcion == 2) {
                seguir = false;
            }
        }

        /**
         * Resultados finales
         */
        int personasMonster = monster.contarReservas();
        int personasRedbull = redbull.contarReservas();

        System.out.println("\nPERSONAS EN MONSTER: " + personasMonster);
        System.out.println("PERSONAS EN RED BULL: " + personasRedbull);

        CarreraBuses.iniciarCarrera(personasMonster, personasRedbull);
    }
}