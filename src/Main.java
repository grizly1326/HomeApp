import java.io.IOException;
import java.net.UnknownHostException;

import videoPlayer.FileGetter;
import videoPlayer.MediaList;
import videoPlayer.SendFile;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		new Thread(new ServerTask()).start();
		FileGetter.updateDir("D:/Desktop/a");
		debugList();
		SendFile.saveList();		//save list.
	}
	private static void debugList(){
		for(int i =0;i<MediaList.getDirSize();i++){
			System.out.println(i+". Block:	"+MediaList.getDirBlock(i).getName());
		}
	}
}
