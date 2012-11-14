package sapr.rover5rc;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public final class Sender {

	private String _ip;
	private int _port;
	private Socket s = null;

	private static Sender _sender = null;

	private Sender() {
	}

	public static Sender getInstance() {
		if (_sender == null) {
			_sender = new Sender();
		}
		return _sender;
	}

	public boolean connect(String ip, int port) {
		_ip = ip;
		_port = port;
		try {
			s = new Socket(_ip, _port);
			return true;
		} catch (UnknownHostException e) {
			return false;
		} catch (IOException e) {
			return false;
		}
	}

	public boolean closeConnection() {
		try {
			s.close();
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public boolean send(byte[] data) {
		try {
			s.getOutputStream().write(data);
			return false;
		} catch (IOException e) {
			return true;
		}
	}

}
