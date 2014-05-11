package Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class Server {
	String serverIP;
	ServerSocket serverSocket = null;
	Socket socket;
	ClientReceive connect;

	int portNum = 0;

	public Server() {
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			connect = new ClientReceive();
		} catch (UnknownHostException e) {
			System.out.println("IP 주소가 확인되지 않습니다");
		}
	}

	public void createServer(int portNum) {
		this.portNum = portNum;
		try {
			serverSocket = new ServerSocket(portNum);
			System.out.println("IP 주소 : " + serverIP + "\t포트 넘버 : " + portNum
					+ " 의 서버가 열렸습니다.");
		} catch (IOException e) {
			System.out.println("서버가 열리지 않습니다.");
		}
	}

	public void connection() {
			try {
				this.socket = serverSocket.accept();
				System.out.println("클라이언트가 접속하였습니다.");
				ConnectThread ct = new ConnectThread(this.socket);
				ct.start();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	class ConnectThread extends Thread {
		private Socket socket;

		public ConnectThread(Socket socket) {
			this.socket = socket;
		}

		public void run() {
			while (true) {
				connect.receiveImage(this.socket);
			}
		}
	}

	public static void main(String args[]) {
		Server server1 = new Server();
		server1.createServer(11111);
		server1.connection();
	}

}
