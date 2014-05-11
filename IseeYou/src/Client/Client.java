package Client;

import java.io.IOException;
import java.net.Socket;

public class Client {
	Socket socket;
	String serverIP;
	Capture cap;

	public Client() {
		serverIP = "165.246.149.153"; // 58.236.159.141
	}

	public void connection(int portNum) {
		try {
			socket = new Socket(serverIP, portNum);
			System.out.println("클라이언트가 서버로 연결되었습니다");
			cap = new Capture(socket);
			cap.start();
		} catch (IOException e) {
			System.out.println("서버와의 연결에 실패했습니다.");
		}
	}

	public static void main(String args[]) {
		Client client1 = new Client();
		client1.connection(11111);
	}

}
