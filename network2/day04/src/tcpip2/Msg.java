package tcpip2;

import java.io.Serializable;

public class Msg implements Serializable{ 

	String id;
	String msg;
	String wUser;
	
	public Msg() {}
	
	public Msg(String id, String msg) {
		super();
		this.id = id;
		this.msg = msg;
		
	}
	

	public Msg(String id, String msg, String wUser) {
		super();
		this.id = id;
		this.msg = msg;
		this.wUser = wUser;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getwUser() {
		return wUser;
	}

	public void setwUser(String wUser) {
		this.wUser = wUser;
	}
	
	
	
	
	
	
}
