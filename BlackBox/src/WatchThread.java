import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;


public class WatchThread extends Thread{ // USB 사용과 지정한 파일의 수정 시 작동하는 쓰레드
	private LinkedList list;
	private long date[];
	private Boolean checkFile = true;
	private Boolean checkUsb = true;
	private String pw;
	private String drive_name[];
	private Video video;
	private ScreenCapture sc;
	
	public WatchThread(LinkedList list, String pw){
		this.list = list;
		this.pw = pw;
		sc = new ScreenCapture(this.pw);
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
		
		
		while(it.hasNext()){	
			fileName = ((File)it.next()).getPath();
			temp = new File(fileName);
			date[count] = temp.lastModified();
			System.out.println(date[count]);
			count++;
		}
		
		File list[] = File.listRoots();
		
		for(int i = 0; i<list.length; i++){
			drive_name[i] = list[i].getPath();
		}
	}
	
	public void fileWatch(){ // 파일의 수정 유무 확인
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
				video.start();
				sc.start();
			}
		}
	}
	
	public void usbWatch(){ // USB 연결 확인
		File list[] = File.listRoots();
		
		for(int i = 0; i<list.length && checkUsb; i++){
			if(!drive_name[i].equals(list[i].getPath())){
				checkUsb = false;
				new PasswordJFrame(pw);
				video.start();
				sc.start();
			}
		}
		
	}

}
