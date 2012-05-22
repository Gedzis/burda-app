package burda.app.activity.shops;

import android.os.Bundle;
import burda.app.BaseActivity;
import burda.app.R;

public class HouseDisplayActivity extends BaseActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.newhouse_layout);
		this.initClickActivity();

	}

}
