package burda.app.activity;

import android.os.Bundle;
import android.view.View;
import burda.app.BaseActivity;
import burda.app.R;

public class NewsActivity extends BaseActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.news);
		this.initClickActivity();

	}

}
