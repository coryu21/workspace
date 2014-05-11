import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class FTP_Connector {

	private static String setIp;
	private static int setPort;
	private static String setId;
	private String setPassword;

	public FTPClient connectFtpServer(String ip, int port, String id,
			String password) {

		setIp = ip;
		setPort = port;
		setId = id;
		setPassword = password;

		FTPClient ftp = null;

		int reply;

		try {
			ftp = new FTPClient();

			ftp.connect(ip, port); // 연결

			reply = ftp.getReplyCode(); // ftp 연결 확인

			if (!ftp.login(id, password)) {
				ftp.logout();
			}

			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
			}
		}// end try
		catch (Exception e) {
			e.printStackTrace();
		}
		return ftp;
	} // end connectFtpServer

	public boolean sendFtpServer(String localPath, String files) {
		boolean isSuccess = false;

		FTPClient ftp = connectFtpServer(setIp, setPort, setId, setPassword);

		try {
			ftp.setFileType(FTP.BINARY_FILE_TYPE);
			ftp.enterLocalPassiveMode(); // 로컬에서 쓸수있게 권한

			String tempFileName = new String(files.getBytes("utf-8"),
					"iso_8859_1");
			String sourceFile = localPath;
			File uploadFile = new File(sourceFile);
			FileInputStream fis = null;
			try {
				fis = new FileInputStream(uploadFile);
				isSuccess = ftp.storeFile(tempFileName, fis);
			} catch (IOException e) {
				e.printStackTrace();
				isSuccess = false;
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (IOException e) {
					}
				}
			}// end try

			ftp.logout();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ftp != null && ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException e) {
				}
			}
		} // end try

		return isSuccess;
	}

	public boolean getFtpServer(String localPath, String files) {

		boolean isSuccess = false;
		FTPClient ftp = connectFtpServer(setIp, setPort, setId, setPassword);
		try {
			ftp.setFileType(FTP.BINARY_FILE_TYPE);// file send type
			ftp.enterLocalPassiveMode(); // Local 사용 가능 하게 하는 코드

			String tempFileName = new String(files.getBytes("utf-8"),
					"iso_8859_1");

			File downloadFile = new File(localPath);
			FileOutputStream fos = null;
			try {
				fos = new FileOutputStream(downloadFile);
				isSuccess = ftp.retrieveFile(tempFileName, fos);
			} catch (IOException e) {
				e.printStackTrace();
				isSuccess = false;
			} finally {
				if (fos != null) {
					try {
						fos.close();
					} catch (IOException e) {
					}
				}
			}// end try
			ftp.logout();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (ftp != null && ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException e) {
				}
			}
		}
		return isSuccess;
	}

	public FTPFile[] getFileList() {
		FTPClient ftp = connectFtpServer(setIp, setPort, setId, setPassword);
		FTPFile[] fileList = null;
		try {
			fileList = ftp.listFiles();
			return fileList;
		} catch (IOException e) {
			e.printStackTrace();
		}// end try
		return null;
	}// void getFileList

	public static void main(String args[]) {
		FTP_Connector fc = new FTP_Connector();
		fc.connectFtpServer("192.168.0.89", 80, "mang", "q1w2E#R$T%");
		
	}
}