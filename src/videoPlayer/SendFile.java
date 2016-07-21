package videoPlayer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;


public class SendFile {
    public static void saveList(){
    	if(new File("list.txt").exists())new File("list.txt").delete();			//directory listing...
		PrintWriter writer=null;
		try {
			writer = new PrintWriter("list.txt");
		} catch (FileNotFoundException e) {
			System.out.println("Cannot create file.");
			e.printStackTrace();
		}
		MediaBlock b=null;
		for(int i=0;i<MediaList.getDirSize();i++){
			b=MediaList.getDirBlock(i);
			writer.println("Path//"+b.getPath()+"//SubName//"+b.getSubName()+"//Name//"+b.getName()+"//Directory//"+b.isDirecotry());
		}
		writer.close();
	}
}