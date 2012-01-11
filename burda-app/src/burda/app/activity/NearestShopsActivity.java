package burda.app.activity;

import android.content.Context;
import android.content.res.Resources;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.Toast;
import burda.app.R;
import burda.app.map.BaloonItemOverlay;
import burda.app.map.FixedMyLocationOverlay;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.OverlayItem;

//Via: http://www.vogella.de/articles/AndroidLocationAPI/article.html 
//http://developer.android.com/resources/tutorials/views/hello-mapview.html
//http://www.slideshare.net/Maksim_Golivkin/maps-location-api3
//http://joshclemm.com/blog/?p=148
public class NearestShopsActivity extends MapActivity {
	private static final GeoPoint PC_EUROPA = new GeoPoint(
			(int) (54.69566 * 1E6), (int) (25.27722 * 1E6));

	private MapView mapView;

	private MyLocationOverlay myLocationOverlay;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nearest_shops);

		mapView = (MapView) findViewById(R.id.map_view);
		mapView.setSatellite(false);
		mapView.setBuiltInZoomControls(true);

		myLocationOverlay = new MyLocationOverlay(this, mapView);

		final Resources resources = getResources();

		BaloonItemOverlay pcEuropaOverlay = new BaloonItemOverlay(
				resources
						.getDrawable(R.drawable.ic_maps_indicator_current_position),
				mapView);

		pcEuropaOverlay.addOverlay(new OverlayItem(
				NearestShopsActivity.PC_EUROPA, "PC Europa",
				"Šioje parduotuvėje yra: Marco Polo, Gant"));

		MapController mapController = mapView.getController();
		mapController.animateTo(PC_EUROPA);
		mapController.setZoom(21);

		// add this overlay to the MapView and refresh it
		mapView.getOverlays().add(pcEuropaOverlay);
		mapView.postInvalidate();

		// /asdasd
		LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
		criteria.setAltitudeRequired(false);
		criteria.setBearingRequired(false);
		criteria.setCostAllowed(true);
		criteria.setPowerRequirement(Criteria.POWER_LOW);
		String provider = locationManager.getBestProvider(criteria, true);

		Location location = locationManager.getLastKnownLocation(provider);
		
//		GeoPoint myLoc = new GeoPoint((int) (location.getLatitude() * 1E6),
//				(int) (location.getLatitude() * 1E6));
		// call convenience method that zooms map on our location
		 zoomToMyLocation();

	}

	@Override
	protected void onResume() {
		super.onResume();
		// when our activity resumes, we want to register for location updates
		myLocationOverlay.enableMyLocation();
	}

	@Override
	protected void onPause() {
		super.onPause();
		// when our activity pauses, we want to remove listening for location
		// updates
		myLocationOverlay.disableMyLocation();
	}

	/**
	 * This method zooms to the user's location with a zoom level of 10.
	 */
	private void zoomToMyLocation() {
		GeoPoint myLocationGeoPoint = myLocationOverlay.getMyLocation();

		if (myLocationGeoPoint != null) {
			mapView.getController().animateTo(myLocationGeoPoint);
			mapView.getController().setZoom(10);
		} else {
			Toast.makeText(this, "Cannot determine location",
					Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

}
