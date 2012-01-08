package burda.app.activity;

import java.util.List;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Toast;
import burda.app.R;
import burda.app.map.CustomItemizedOverlay;
import burda.app.map.FixedMyLocationOverlay;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.MyLocationOverlay;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

//Via: http://www.vogella.de/articles/AndroidLocationAPI/article.html 
//http://developer.android.com/resources/tutorials/views/hello-mapview.html
//http://www.slideshare.net/Maksim_Golivkin/maps-location-api3
//http://joshclemm.com/blog/?p=148
public class NearestShopsActivity extends MapActivity {
	private MapView mapView;

	private static final int latitudeE6 = (int) (54.69566 * 1e6);
	private static final int longitudeE6 = (int) (25.27722 * 1e6);

	private MyLocationOverlay myLocationOverlay;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.nearest_shops);

		mapView = (MapView) findViewById(R.id.map_view);
		mapView.setBuiltInZoomControls(true);

		myLocationOverlay = new FixedMyLocationOverlay(this, mapView);

		List<Overlay> mapOverlays = mapView.getOverlays();
		Drawable drawable = this.getResources().getDrawable(
				R.drawable.ic_launcher);
		CustomItemizedOverlay itemizedOverlay = new CustomItemizedOverlay(
				drawable, this);

		GeoPoint point = new GeoPoint(latitudeE6, longitudeE6);
		OverlayItem overlayitem = new OverlayItem(point, "Hello",
				"I'm in Athens, Greece!");

		itemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedOverlay);

		MapController mapController = mapView.getController();

		mapController.animateTo(point);
		mapController.setZoom(21);

		// add this overlay to the MapView and refresh it
		mapView.getOverlays().add(myLocationOverlay);
		mapView.postInvalidate();

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
