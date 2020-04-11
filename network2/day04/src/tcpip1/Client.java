package tcpip1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

	Socket socket;
	Sender sender; //sender는 소켓이 만들어지면 만들어진다. 

	public Client() {
	}

	// socket을 만들기 위해서 필요한 것들은? -> address,port
	public Client(String address, int port) throws IOException {
		try {
			socket = new Socket(address,port);
		} catch (Exception e) {
			e.printStackTrace();
			while (true) {
				System.out.println("Please Retry");
				try {
					Thread.sleep(1000);
					socket = new Socket(address, port); // 1초 후에 다시 시도해라
					break;

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		}
		System.out.println("Connected Server:" + address);
		sender = new Sender(socket); //소켓 만들기 후 센더에 넣어주기 
	}
	//보내는 thread 만들기
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
			//던지기 
			if(dos !=null) {
				try {
					//UTF형태로 데이터가 깨지지않게 보내라 
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
