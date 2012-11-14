package sapr.rover5rc;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class ControlActivity extends Activity {

	Button goForwardBtn;
	Button goBackBtn;
	SeekBar turnSB;

	private int maxAngle = 90;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_control);

		goForwardBtn = (Button) findViewById(R.id.goForwardBtn);
		goBackBtn = (Button) findViewById(R.id.goBackBtn);

		turnSB = (SeekBar) findViewById(R.id.turnSB);
		turnSB.setMax(2 * maxAngle);
		turnSB.setProgress(maxAngle);
		turnSB.setOnTouchListener(angleChanger);
	}

	OnTouchListener angleChanger = new OnTouchListener() {

		public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
				case MotionEvent.ACTION_DOWN:
					turnSB.onTouchEvent(event);
					break;
				case MotionEvent.ACTION_UP:
					turnSB.setProgress(maxAngle);
					break;
				case MotionEvent.ACTION_MOVE:
					turnSB.onTouchEvent(event);
					break;
				default:
					break;
				}
			return true;
		}
	};
}
