
public class SKIP {
	
	int skip[];
	
	public SKIP(){
		skip = new int[128];
	}
	
	public void initSkip(String pattern){
		char p [] = pattern.toCharArray();
		for(int i = 0; i<128; i++){
			skip[i] = 0;
		}
		for(int i = 0; i<pattern.length(); i++){
			skip[p[i]]  = pattern.length() - i - 1;
		}
		for(int i = 0; i<pattern.length(); i++){
			System.out.print(p[i] + "\t");
		}
		System.out.println();
		for(int i = 0; i<pattern.length(); i++){
			System.out.print(skip[p[i]] + "\t");
		}
		System.out.println();
	}

	public static void main(String args[]){
		new SKIP().initSkip("reminiscence");
	}
}
