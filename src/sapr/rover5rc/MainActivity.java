package sapr.rover5rc;

import sapr.rover5rc.networkprocessing.Sender;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	Button connectBtn;
	Button sendBtn;
	EditText portView;
	EditText ipView;
	
	Sender sender;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		connectBtn = (Button) findViewById(R.id.connect);
		sendBtn = (Button) findViewById(R.id.send_data);
		ipView = (EditText) findViewById(R.id.ip);
		portView = (EditText) findViewById(R.id.port);

		connectBtn.setOnClickListener(setupContent);
		sendBtn.setOnClickListener(sendData);

		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
				.permitAll().build();

		StrictMode.setThreadPolicy(policy);
	}

	OnClickListener setupContent = new OnClickListener() {

		public void onClick(View v) {
			 sender = Sender.getInstance();
			 sender.connect("192.168.0.77", 7710);
			 Intent i = new Intent(MainActivity.this, ControlActivity.class);
			 startActivity(i);
		};	
	};

	OnClickListener sendData = new OnClickListener() {

		public void onClick(View v) {
			sender.send("asdf".getBytes());
		};
	};
}
