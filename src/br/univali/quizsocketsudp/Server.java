/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.univali.quizsocketsudp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author biankatpas
 */

public class Server
{
    public static void main(String[] args) 
    {
        int porta = 12345;
        DatagramSocket socket = null;

        try 
        {
            socket = new DatagramSocket(porta);
            System.out.println("Servidor para contar a história iniciado...");

            while (true) 
            {
//              recebimento dos dados em um datagrama de 1024 bytes
                DatagramPacket bufferRecebimento = new DatagramPacket(new byte[1024], 1024);
                socket.receive(bufferRecebimento); //recepção

//              imprime o dado do datagrama recebido
                String msgRecebida = new String(bufferRecebimento.getData());
                System.out.println(msgRecebida);

//              envio de dados para o emissor do datagrama recebido
//              String msgEnviada = "Trecho da história recebido: "+msgRecebida;
//              DatagramPacket bufferEnvio = new DatagramPacket(msgEnviada.getBytes(), msgEnviada.getBytes().length, bufferRecebimento.getAddress(), bufferRecebimento.getPort());
//              socket.send(bufferEnvio);
            }
        } 
        catch (IOException e) 
        {
            System.out.println(e);
            if (socket != null) 
                socket.close();
        }
    }
}
