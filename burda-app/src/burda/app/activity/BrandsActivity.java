package burda.app.activity;

import android.os.Bundle;
import burda.app.BaseActivity;
import burda.app.R;

public class BrandsActivity extends BaseActivity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.brands);
		this.initClickActivity();
	}

}
