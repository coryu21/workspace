import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;


public class WatchThread extends Thread{
	LinkedList list;
	long date[];
	
	public WatchThread(LinkedList list){
		this.list = list;
	}
	
	public void init(){
		Iterator it = list.iterator();
		int count = 0;
		while(it.hasNext()){
			File temp = new File(((File) it.next()).getPath());
			date[count] = temp.lastModified();
			System.out.println(date[count]);
			count++;
		}
	}

}
