/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientsocket;

import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fumagalli.luca
 */
public class ClientSocket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            Socket clientSocket = new Socket("localhost", 5000);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            Scanner tastiera = new Scanner(System.in);

            int scelta;
            boolean stato = false;
            
            String username = null, password = null;
            String user, psw;

            do {
                System.out.println("Selezionare una scelta:\n"
                        + "0 Esci \n"
                        + "1 registrazione \n"
                        + "2 log in\n");
                scelta = sc.nextInt();

                switch (scelta) {
                    case 0:
                        stato = true;
                        break;
                    case 1:
                        System.out.println("Inserire user name");
                        user = tastiera.next();
                        System.out.println("Inserire password");
                        psw = tastiera.next();

                        stato = false;
                        break;

                    case 2:
                        System.out.println("Inserire user name");
                        username = tastiera.next();
                        System.out.println("Inserire password");
                        password = tastiera.next();

                        out.println(username);
                        System.out.println("Il server risponde: " + in.readLine());

                        stato = false;
                        break;
                }
            } while (stato);

            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}