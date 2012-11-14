package sapr.rover5rc;

public class Protocol {

	private byte[] _message = new byte[4];

	public void setRightDirection(byte d) {
		_message[0] = d;
	};

	public void setLeftDirection(byte d) {
		_message[1] = d;
	}

	public void setRigthPwm(byte pwm) {
		_message[2] = pwm;
	}

	public void setLeftPwm(byte pwm) {
		_message[3] = pwm;
	}

	public byte[] getMessage() {
		return _message;
	}
}
