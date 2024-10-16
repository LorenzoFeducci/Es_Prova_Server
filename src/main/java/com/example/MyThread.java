package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class MyThread extends Thread {
    Socket socket;

    public MyThread(Socket s) {
        this.socket = s;
    }

    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream())); // ascolto                                                                              // (ricevere)
            DataOutputStream out = new DataOutputStream(socket.getOutputStream()); // parla (invia)
            do {
                String stringaRicevuta = in.readLine(); // in attesa della stringa del client
                System.out.println("La stringa ricevuta: " + stringaRicevuta); // stringa ricevuta dal client e stampata
                String stringaMaiuscola = stringaRicevuta.toUpperCase();// stringa in maiuscolo
                out.writeBytes(stringaMaiuscola + '\n'); // invio della stringa al client
            } while (true);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
