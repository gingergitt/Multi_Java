package serial;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;

import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;

public class SerialReadWrite implements SerialPortEventListener {

	CommPortIdentifier commPortIdentifier;
	CommPort commPort;
	InputStream in;
	OutputStream out;
	BufferedInputStream bin;
	SerialPort serialPort;

	public SerialReadWrite() {
	}

	public SerialReadWrite(String portName) throws Exception {
		commPortIdentifier = CommPortIdentifier.getPortIdentifier(portName);
		System.out.println("Identifier Com Port!");
		connect();
		System.out.println("Connect Com Port!");
		new Thread(new SerialWrite()).start();
		System.out.println("Start CAN Network.....");
		
	}

	public void connect() throws Exception {
		if(commPortIdentifier.isCurrentlyOwned()) {
			
		}else {
			commPort = commPortIdentifier.open(this.getClass().getName(), 5000); //5초동안 정상적 대답이 없으면 에러
			if(commPort instanceof SerialPort) {
				 serialPort = (SerialPort) commPort;
				  serialPort.addEventListener(this);
				    serialPort.notifyOnDataAvailable(true);
				    serialPort.setSerialPortParams(921600, // 통신속도
				      SerialPort.DATABITS_8, // 데이터 비트
				      SerialPort.STOPBITS_1, // stop 비트
				      SerialPort.PARITY_NONE); // 패리티
				    in = serialPort.getInputStream();
				    bin = new BufferedInputStream(in);
				    out = serialPort.getOutputStream();
				//java에서 특정 port로 CAN과 통신하고 있다. (그래서 Input/OutputStream이 필요)
			}else {
				System.out.println("this is not a Serial Port");
			}
		}
	}

	
	public void send(String msg) {
		new Thread(new SerialWrite(msg)).start();
	}
	
	
	//CAN Network에 참여한다고 전달하기 위함 
	class SerialWrite implements Runnable {
		String data; //이 data를 스레드에서 write한다. 
		
		public SerialWrite() {
			this.data = ":G11A9\r"; //"G" : 시작문자 , "11" : 명령 , "A9": checksum , "\r":끝문자(16진수)
		}
		
		public SerialWrite(String msg) {
			this.data = convertData(msg);
		}
		
		public String convertData(String msg) {
			msg = msg.toUpperCase(); //CAN에서는 대소문자 구분이 잘 안됨
			msg = "W28"+msg;
			//W28 00000000 0000000000000000
			
			//checksum making
			char c[] = msg.toCharArray();
			int checkSum = 0;
			for (char ch:c) {
				//character array 배열 돌리기
				checkSum += ch;
				 
			}
			
			checkSum = (checkSum & 0xFF);
			
			
			String result = ":";
			result += msg+Integer.toHexString(checkSum).toUpperCase()+"\r"; // Integer.toHexString(i) : 10진수를 16진수로 변환
			//System.out.println(result);
			return result;
		}
		@Override
		public void run() {
			byte[] outData = data.getBytes();
			try {
				//CAN Network Area에 쏜다.
				out.write(outData);
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}
		
	}
	
	
	
	
	

	
	
	
	
	public static void main(String[] args) { 
		SerialReadWrite sc = null;
		String id = "00000007";
		String data = "000000000000000a";
		String msg = id+data;
		try {
			sc = new SerialReadWrite("COM9");
			Thread.sleep(100);
			sc.send(msg);
		} catch (Exception e) {
			System.out.println("Connect Fail");
			e.printStackTrace();
		}
	}

	@Override //이벤트 발생시 이 메서드가 받는다. 이 이벤트가 java application으로 전달되고, 이것이 serialEvent로 온다.
	public void serialEvent(SerialPortEvent event) {
		
		 switch (event.getEventType()) {
		  case SerialPortEvent.BI:
		  case SerialPortEvent.OE:
		  case SerialPortEvent.FE:
		  case SerialPortEvent.PE:
		  case SerialPortEvent.CD:
		  case SerialPortEvent.CTS:
		  case SerialPortEvent.DSR:
		  case SerialPortEvent.RI:
		  case SerialPortEvent.OUTPUT_BUFFER_EMPTY:
		   break;
		  case SerialPortEvent.DATA_AVAILABLE:
		   byte[] readBuffer = new byte[128];

		   try {

		    while (bin.available() > 0) {
		     int numBytes = bin.read(readBuffer);
		    }

		    String ss = new String(readBuffer);
		    if(ss.charAt(1)=='W') {
		    	  System.out.println("Send Low Data:" + ss + "||");
		    }else {
		    	System.out.println("Receive Low Data:" + ss + "||");
		    }
		  
		    
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		   break;
		  }
		 }
	
		
	

}
