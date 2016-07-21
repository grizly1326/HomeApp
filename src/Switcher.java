import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Switcher {
	public static void mainSwitch(DatagramPacket packet){
        String a=new String(packet.getData()).substring(0, packet.getLength());
        System.out.println(a);
        switch(a){
            case "ping":System.out.println("ping from here.");Send.sendMessage(packet.getAddress(),"ping.back"); break;
            case "ping.getContent":Send.sendMessage(packet.getAddress(),"ping.getContent=Video player");break;
            case "getList":System.out.println(a);send_list(packet.getAddress(),"list.txt");break;
            default:System.out.println("Cannot find this command:    "+a);break;
        }
    }
	private static void send_list(InetAddress address,String FileName){
		SendFile a = null;
		try {
			a = new SendFile(new Socket(address,1325));
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<File> file=new ArrayList<File>();
		file.add(new File(FileName));
		a.send(file);
	}
}
