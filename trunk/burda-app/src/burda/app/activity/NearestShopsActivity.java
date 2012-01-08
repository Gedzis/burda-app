package burda.app.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import burda.app.R;

//Via: http://www.vogella.de/articles/AndroidLocationAPI/article.html 
//http://developer.android.com/resources/tutorials/views/hello-mapview.html
//http://www.slideshare.net/Maksim_Golivkin/maps-location-api3
public class NearestShopsActivity extends Activity implements OnClickListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nearest_shops);
	}

	public void onClick(View v) {
		// TODO Auto-generated method stub

	}
}
