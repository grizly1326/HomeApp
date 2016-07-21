package videoPlayer;

import java.io.File;

public class FileGetter {
	public static void updateDir(String url){
		File f= new File(url);
		String[] s=f.list();
		MediaList.addDir(new MediaBlock("Current address",null,url,false));
		MediaList.addDir(new MediaBlock("Back address",null,getBackAddress(url),false));
		for(String a:s){
			if(new File(url+"/"+a).isDirectory()){
				MediaList.addDir(new MediaBlock(a,null,url+"/"+a,true));
			}else{
				MediaList.addDir(new MediaBlock(a,null,url+"/"+a,false));
			}
		}
		System.out.println("MSG: Dir updated......");
	}
	private static String getBackAddress(String path){
		String[] list=path.split("/");
		String out=null;
		for(int i=0;i<list.length-1;i++){
			if(i==0)out=list[i];else out+="/"+list[i];
		}
		return out;
	}
}
