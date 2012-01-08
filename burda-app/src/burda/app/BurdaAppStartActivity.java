package burda.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import burda.app.activity.BrandsActivity;
import burda.app.activity.LoyaltyActivity;
import burda.app.activity.NearestShopsActivity;
import burda.app.activity.NewsActivity;
import burda.app.activity.ShopsActivity;

public class BurdaAppStartActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Find buttons
		View newsButton = findViewById(R.id.button_news);
		newsButton.setOnClickListener(this);

		View brandsButton = findViewById(R.id.button_brands);
		brandsButton.setOnClickListener(this);

		View loyaltyButton = findViewById(R.id.button_loyalty);
		loyaltyButton.setOnClickListener(this);

		View nearestShopsButton = findViewById(R.id.button_nearests_shops);
		nearestShopsButton.setOnClickListener(this);

		View shopsButton = findViewById(R.id.button_shops);
		shopsButton.setOnClickListener(this);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button_news:
			startActivity(new Intent(this, NewsActivity.class));
			break;
		case R.id.button_loyalty:
			startActivity(new Intent(this, LoyaltyActivity.class));
			break;
		case R.id.button_nearests_shops:
			startActivity(new Intent(this, NearestShopsActivity.class));
			break;
		case R.id.button_brands:
			startActivity(new Intent(this, BrandsActivity.class));
			break;
		case R.id.button_shops:
			startActivity(new Intent(this, ShopsActivity.class));
			break;
		}

	}
}