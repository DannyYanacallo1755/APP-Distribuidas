import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class HiloCliente  extends Thread{
    private DatagramSocket socket;
    private DatagramPacket paqueteEntrada;

    public HiloCliente(DatagramSocket socket, DatagramPacket paqueteEntrada){
        this.socket = socket;
        this.paqueteEntrada=paqueteEntrada;

    }


    public void run(){
        String mensajeRecibido = new String(paqueteEntrada.getData());
        System.out.println("Mensaje es:"+mensajeRecibido);


        InetAddress direccionIp_Clientes = paqueteEntrada.getAddress();
        int puerto_cliente=paqueteEntrada.getPort();

        String mensajeSalida = "No yo soy tu padre";
        byte[] bufferSalida = mensajeSalida.getBytes();

        DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_Clientes,puerto_cliente);
        //socket.send(paqueteSalida);


        
    }
}
