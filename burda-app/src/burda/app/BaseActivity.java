package burda.app;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class BaseActivity extends Activity implements OnClickListener {
	public void onClick(View v) {

		switch (v.getId()) {
		case R.id.home_button:
			startActivity(new Intent(this, BurdaAppStartActivity.class));
			break;
		}
	}
}
