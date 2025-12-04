package com.mycompany.proyectofinalautobusesehilos;

import java.util.ArrayList;

/**
 *
 * @author Equipo5
 */
public class Autobus {

 private String nombreBus;
 private ArrayList<Asientos> asientos;

    public Autobus(String nombreBus, int totalAsientos) {
        this.nombreBus = nombreBus;
        asientos = new ArrayList<>();
        
        for (int i = 1; i <= totalAsientos; i++) {
            asientos.add(new Asientos(i));
        }
    }
    /*** 
     * @param idCliente id del cliente
     * @param numAsiento su num de asiento
     * @return reservamos un asiento en especifico
     */
   public synchronized boolean reservarAsientoEspecifico(int idCliente, int numAsiento) {
     
       for (Asientos a : asientos) {

        if (a.getNumero() == numAsiento) {

            if (!a.isReserved()) {
                a.reservar(idCliente);
                return true;
            } else {
                System.out.println("Ese asiento ya esta ocupado");
                return false;
            }
        }
    }
      
    System.out.println("El asiento no es valido");
    return false;
    }
   /*** 
    * @param numero el siento
    * @return verificamos que no este y ocupado
    */
   
   public boolean estaReservado(int numero) {
    for (Asientos a : asientos) {
        if (a.getNumero() == numero) {
            return a.isReserved();
        }
    }
    return false;
}
   /**
    * Mostramos los siento disponibles 
    */
    public synchronized void mostrarDisponibles() {
        System.out.print("Bus " + nombreBus + " asientos disponibles: ");
        for (Asientos a : asientos) {
            if (!a.isReserved()) {
                System.out.print(a.getNumero() + " ");
            }
        }
        System.out.println();
    }
    /*** 
     * @return para contar cuentas personas tenemos en el bus 
     */
    public int contarReservas() {
        int total = 0;

        for (Asientos a : asientos) {
            if (a.isReserved()) {
                total++;
            }
             
        }
    
        return total;
    }
    
    /*** 
     * @return para conocer si el autobus se encuentra lleno
     */
   public boolean estaLleno() {
       for (Asientos a : asientos) {
           if (!a.isReserved()) {
               return false;
           }
       }
       return true;
}
    
    
}