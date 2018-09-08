/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.contadordehistoriasocketsudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author biankatpas
 */

public class Client
{
    private int port;
    private String name;
    private String server;
    private DatagramSocket socket;
    private InetAddress address;
    private Scanner s; 

    public Client(int port, String server, String name) 
    {
        try
        {
            this.port = port;
            this.name = name;
            this.server = server;

            socket = new DatagramSocket();
            address = InetAddress.getByName(this.server);
            
            s = new Scanner(System.in);
        } 
        catch (SocketException ex) 
        {
            System.err.println("socket error");
        } 
        catch (UnknownHostException ex) 
        {
            System.err.println("host error");
        }
    }

    public void run() 
    {
        while(true)
        {
            try
            {
                //solicita a msg a ser enviada
                System.out.println("Continue a hst...");
                String message = s.nextLine();
                byte[] data = message.getBytes(); 
                //envio dos dados
                DatagramPacket sendBuffer = new DatagramPacket(data, data.length, address, port);
                socket.send(sendBuffer); //envio
            } 
            catch (IOException ex) 
            {
                System.err.println(ex);
            }
        }
    }
}

class ClientManager
{
    public static void main(String[] args) 
    {
        new Client(12345, "127.0.0.1", "Cliente").run();
    }
}

