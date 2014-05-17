import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;


public class WatchThread extends Thread{
	LinkedList list;
	long date[];
	Boolean checkFile = true;
	Boolean checkUsb = true;
	String pw;
	String drive_name[];
	Video video;
	
	public WatchThread(LinkedList list, String pw){
		this.list = list;
		this.pw = pw;
		date = new long[256];
		drive_name = new String[256];
	}
	
	public void run(){
		init();
		while(true){
			fileWatch();
			usbWatch();
		}
	}
	
	public void setVideo(Video video){
		this.video = video;
	}
	
	public void init(){
		Iterator it = list.iterator();
		int count = 0;
		String fileName;
		File temp;
		File list[];
		
		while(it.hasNext()){	
			fileName = ((File)it.next()).getPath();
			temp = new File(fileName);
			date[count] = temp.lastModified();
			System.out.println(date[count]);
			count++;
		}
		
		list = File.listRoots();
		
		for(int i = 0; i<list.length; i++){
			drive_name[i] = list[i].getName();
		}
	}
	
	public void fileWatch(){
		Iterator it = list.iterator();
		long last;
		String fileName;
		File temp;
		
		for(int i = 0; it.hasNext() && checkFile; i++){
			fileName = ((File)it.next()).getPath();
			temp = new File(fileName);
			last = temp.lastModified();
			if(date[i] != last){
				System.out.println("파일이 변하였다!!!!");
				checkFile = false;
				new PasswordJFrame(pw);
				video.capture();
			}
		}
	}
	
	public void usbWatch(){
		File list[] = File.listRoots();
		
		for(int i = 0; i<list.length && checkUsb; i++){
			if(!drive_name[i].equals(list[i].getName())){
				checkUsb = false;
				new PasswordJFrame(pw);
				video.capture();
			}
		}
		
	}

}
