import java.io.*;
 
public class TestGrade {
   public static void main(String[] args) throws IOException {
      int student_num[] = new int[256];
      int tuition_perCredit = 0;
      String word = "";
      String str = null;
      int count = 0;
      FileReader fStr = null;
      
      fStr = new FileReader("stData.txt");
      
      BufferedReader br = new BufferedReader(fStr);
      str = br.readLine();
      // str = "3 345"
      for(int i = 0; i<str.length(); i++) {
         if(str.charAt(i)==' ') {
        	student_num[count] = Integer.parseInt(word);
        	word ="";
        	count++;
         } else{
        	 word+= str.charAt(i);
         }
      }
      
      student_num[count] = Integer.parseInt(word);
      
      for(int i = 0; i<count+1; i++){
    	  System.out.println(student_num[i]);
      }
      
   }
}