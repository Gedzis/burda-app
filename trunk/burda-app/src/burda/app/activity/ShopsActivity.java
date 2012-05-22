package burda.app.activity;

import android.os.Bundle;
import burda.app.BaseActivity;
import burda.app.R;

public class ShopsActivity extends BaseActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shops);

		this.initClickActivity();
		

	}

}
