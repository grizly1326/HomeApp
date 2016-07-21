import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Send {
	public static void sendMessage(InetAddress address,String text){
		DatagramSocket socket=null;
		try {
			socket= new DatagramSocket();
		} catch (SocketException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DatagramPacket packet = null;
		packet= new DatagramPacket(text.getBytes(),text.getBytes().length,address,1326);
		try {
			socket.send(packet);
			System.out.println("Response sent.");
		} catch (IOException e) {
			System.out.println("Cannot send a package.");
			e.printStackTrace();
		}
	}
}
