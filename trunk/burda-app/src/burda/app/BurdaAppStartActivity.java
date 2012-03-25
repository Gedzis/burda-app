package burda.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import burda.app.activity.LoyaltyActivity;
import burda.app.activity.NearestShopsActivity;
import burda.app.activity.NewsActivity;
import burda.app.activity.ShopsActivity;
import burda.app.activity.shops.GantDisplayActivity;
import burda.app.activity.shops.HouseDisplayActivity;
import burda.app.activity.shops.LaurenDisplayActivity;
import burda.app.activity.shops.MOPDisplayActivity;
import burda.app.activity.shops.MoreDisplayActivity;

public class BurdaAppStartActivity extends Activity implements OnClickListener {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Find buttons
		View newsButton = findViewById(R.id.button_news);
		newsButton.setOnClickListener(this);

		View loyaltyButton = findViewById(R.id.button_loyalty);
		loyaltyButton.setOnClickListener(this);

		View nearestShopsButton = findViewById(R.id.button_nearests_shops);
		nearestShopsButton.setOnClickListener(this);

		View shopsButton = findViewById(R.id.button_shops);
		shopsButton.setOnClickListener(this);

		View mopButton = findViewById(R.id.main_button_mop);
		mopButton.setOnClickListener(this);

		View laurenButton = findViewById(R.id.main_button_lauren);
		laurenButton.setOnClickListener(this);

		View gantButton = findViewById(R.id.main_button_gant);
		gantButton.setOnClickListener(this);

		View moreButton = findViewById(R.id.main_button_more);
		moreButton.setOnClickListener(this);

		View newHouseButton = findViewById(R.id.main_button_newHouse);
		newHouseButton.setOnClickListener(this);
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
		case R.id.button_shops:
			startActivity(new Intent(this, ShopsActivity.class));
			break;
		case R.id.main_button_gant:
			startActivity(new Intent(this, GantDisplayActivity.class));
			break;

		case R.id.main_button_newHouse:
			startActivity(new Intent(this, HouseDisplayActivity.class));
			break;

		case R.id.main_button_lauren:
			startActivity(new Intent(this, LaurenDisplayActivity.class));
			break;

		case R.id.main_button_mop:
			startActivity(new Intent(this, MOPDisplayActivity.class));
			break;
		case R.id.main_button_more:
			startActivity(new Intent(this, MoreDisplayActivity.class));
			break;
		}

	}
}