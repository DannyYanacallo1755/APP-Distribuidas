import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class cliente {
    public static void main(String[] args) {
        int puerto=5000;
        try {
            //Crear un objeto socket
            DatagramSocket socket = new DatagramSocket();
            
            //Direccion servidor
            InetAddress direccionIp_Servidor = InetAddress.getByName("localhost");
            
            String mensajeSalida = "Hola soy el cliente";
            byte[] bufferSalida = mensajeSalida.getBytes();
            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionIp_Servidor,puerto);
            socket.send(paqueteSalida);




            // Crear arreglo de bytes para recibir los datos del cliente
            byte[] bufferEntrada= new byte[1024];
            //crear objeto datagram para recibir los datos
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length );
            
            //recibir el paquete
            socket.receive(paqueteEntrada);

            ////////////////////////////////////////////////////////////////////////////////////////////////////////

            

    
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            
        }
    }
}
