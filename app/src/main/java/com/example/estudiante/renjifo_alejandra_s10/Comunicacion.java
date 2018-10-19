package com.example.estudiante.renjifo_alejandra_s10;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Comunicacion extends Thread {

    private boolean conectado;
    public String msg;
    MulticastSocket socket;
    InetAddress IPgrupo;
    OnMessage observer;


    public  Comunicacion(){

        conectado=false;
    }

    @Override
    public void run() {

        try {
            while (true){
                if(!conectado) {
                    IPgrupo = InetAddress.getByName("228.0.0.19");
                    socket = new MulticastSocket(5000);
                    socket.joinGroup(IPgrupo);
                    conectado=true;
                }else {
                    recibirDatos();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void recibirDatos() {
        try {
            while (true) {
                byte[] buff = new byte[1000];
                DatagramPacket datagrama = new DatagramPacket(buff, buff.length, IPgrupo, 5000);
                socket.receive(datagrama);
                msg = new String(datagrama.getData());
                observer.onReceived(msg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void enviarDatos(String dato) {
        try {
            byte[] buff= dato.getBytes();
            DatagramPacket datagrama= new DatagramPacket(buff,buff.length);
            socket.send(datagrama);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public interface OnMessage{
        public void onReceived(String input);
    }

    public void setObserver(OnMessage observer) {
        this.observer = observer;
    }


}
