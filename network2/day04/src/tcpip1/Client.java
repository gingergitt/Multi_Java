package tcpip1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	Socket socket;
	Sender sender; //sender�� ������ ��������� ���������. 

	public Client() {
	}

	// socket�� ����� ���ؼ� �ʿ��� �͵���? -> address,port
	public Client(String address, int port) throws IOException {
		try {
			socket = new Socket(address,port);
		} catch (Exception e) {
			e.printStackTrace();
			while (true) {
				System.out.println("Please Retry");
				try {
					Thread.sleep(1000);
					socket = new Socket(address, port); // 1�� �Ŀ� �ٽ� �õ��ض�
					break;

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		}
		System.out.println("Connected Server:" + address);
		sender = new Sender(socket); //���� ����� �� ������ �־��ֱ� 
	}
	//������ thread �����
	class Sender implements Runnable{

		OutputStream os;
		DataOutputStream dos;
		String msg;
		
	      public Sender() {

	      }
		public Sender (Socket socket) throws IOException {
			os = socket.getOutputStream();
			dos = new DataOutputStream(os);
		}
		
		public void setMsg(String msg) {
			this.msg = msg;
		}
		@Override
		public void run() {
			//������ 
			if(dos !=null) {
				try {
					//UTF���·� �����Ͱ� �������ʰ� ������ 
					dos.writeUTF(msg);
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
		
	}
	

	public void startClient() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("Input Msg");
			String msg = sc.nextLine();
			   if (msg.equals("q")) {
		            break;
		         }
		         sender.setMsg(msg);
		         new Thread(sender).start();
		         if(msg.equals("q")) {
		        	 try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
					
						e.printStackTrace(); 
					}
		        	 break;
		         }
		      }

		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("End Client!");
		sc.close();
	}

	public static void main(String[] args) throws Exception {

		Client client = null;
		try {
			client = new Client("70.12.113.248",8888);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		client.startClient();
	}

}
