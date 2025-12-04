package com.mycompany.proyectofinalautobusesehilos;
/***
 * @author Equipo5
 */
public class Clientes implements Runnable{
    private Autobus bus;
    private int idCliente;
    private int asiento;
    
    public Clientes(int idCliente, Autobus  bus, int asiento) {
        this.idCliente = idCliente;
        this.bus = bus;
        this.asiento = asiento;
    }

    @Override
    public void run() {
    bus.reservarAsientoEspecifico(idCliente, asiento);

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            System.out.println("Error en hilo");
        }
    }
 }
