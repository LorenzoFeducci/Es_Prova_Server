package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;


public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Server avviato");
        ServerSocket ss = new ServerSocket(5637);

        Socket mySocket = ss.accept();
        System.out.println("Qualcuno si è collegato");

        BufferedReader in = new BufferedReader(new InputStreamReader(mySocket.getInputStream())); //ascolto (ricevere)
        DataOutputStream out = new DataOutputStream(mySocket.getOutputStream()); //parla (invia)

        String stringaRicevuta = in.readLine(); //in attesa della stringa del client 
        System.out.println("La stringa ricevuta: " + stringaRicevuta); //stringa ricevuta dal client e stampata

        String stringaMaiuscola = stringaRicevuta.toUpperCase();//stringa in maiuscolo
        out.writeBytes(stringaMaiuscola + '\n'); //invio della stringa al client

        mySocket.close(); //chiusura
        ss.close();
    }
}