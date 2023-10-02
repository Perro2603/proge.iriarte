package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerStr {

    ServerSocket server = null;
    Socket client = null;
    String stringaRicevuta = null;
    String stringaModificata = null;
    BufferedReader inDalclient;
    DataOutputStream outVersoclient;



    public Socket attendi(){


        try {
            System.out.println("I Server partito in esecuzione ");


            server = new ServerSocket(3069);

            client =  server.accept();

            server.close();

            inDalclient = new BufferedReader(new InputStreamReader(client.getInputStream()));

            outVersoclient = new DataOutputStream(client.getOutputStream());

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("Errore durante l'instanza del server !");
            System.out.println(1);

            // TODO: handle exception
        }
        return client;
    }
    

    public void comunica(){


        try {
            System.out.println("benvenuto client scrivi una frase e la trasformo in maisculo , Attendo...");
            stringaRicevuta = inDalclient.readLine();
            System.out.println("ricevuta la stringa dal cliente : " + stringaRicevuta);

            stringaModificata = stringaRicevuta.toUpperCase();
            System.out.println("invio la stringa modificata al client ");
            outVersoclient.writeBytes(stringaModificata+'\n');

            System.out.println("server fine elaborazione ... buona notte ");
            client.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
