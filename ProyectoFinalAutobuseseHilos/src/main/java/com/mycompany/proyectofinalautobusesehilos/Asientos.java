package com.mycompany.proyectofinalautobusesehilos;
/**
 *
 * @author Equipo5
 */
public class Asientos {
    private int numero;
    private boolean reservado;
/*** 
 * @param numero el contructor que lo recibe 
 */
    public Asientos(int numero) {
        this.numero = numero;
        this.reservado = false;
    }

    /*** 
     * @param idCliente
     * @return el metodo synchronized para reservar asiento de forma segura
     */
    public synchronized boolean reservar(int idCliente) {
        if (!reservado) {
            reservado = true;
            System.out.println("Cliente " + idCliente + " reservo el asiento " + numero);
            return true;
        }
        return false;
    }
    
    /*** 
     * @return si el asiento ya esta reservado 
     */
    public boolean isReserved() {
        return reservado;
    }

    /*** 
     * @return el numero del asiento 
     */
    public int getNumero() {
        return numero;
    }
}
