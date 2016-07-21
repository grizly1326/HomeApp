import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ServerTask implements Runnable {
	DatagramPacket packet=null;
	DatagramSocket socket=null;
	@Override
	public void run() {
	        byte[] b = new byte[1024];
	        try {
	            socket=new DatagramSocket(1326);
	        } catch (SocketException e) {
	            e.printStackTrace();
	            System.out.println("Cannot create DatagramSocket on Receive");
	        }
	        while(true) {
	            packet= new DatagramPacket(b, b.length);
	            try {
	                socket.receive(packet);
	            } catch (IOException e) {
	                e.printStackTrace();
	                System.out.println("Cannot Receive.");
	            }
	            System.out.println("Length:    "+packet.getLength());
	            packet.setData(packet.getData(),0,packet.getLength());
	            Switcher.mainSwitch(packet);
	        }
	}

}
