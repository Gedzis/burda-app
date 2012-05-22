package burda.app.activity.shops;

import burda.app.BaseActivity;
import burda.app.R;
import android.app.Activity;
import android.os.Bundle;

public class MOPDisplayActivity extends BaseActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mop_layout);
		this.initClickActivity();

	}
}
