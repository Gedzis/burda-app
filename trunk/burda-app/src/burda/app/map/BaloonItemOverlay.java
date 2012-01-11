package burda.app.map;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.Drawable;

import com.google.android.maps.MapView;
import com.google.android.maps.OverlayItem;
import com.readystatesoftware.mapviewballoons.BalloonItemizedOverlay;

public class BaloonItemOverlay extends BalloonItemizedOverlay<OverlayItem> {

	public List<OverlayItem> list = new ArrayList<OverlayItem>();
	
	public BaloonItemOverlay(Drawable defaultMarker, MapView mapView) {
		super(boundCenterBottom(defaultMarker), mapView);

		populate();
	}

	@Override
	protected OverlayItem createItem(int i) {
		return list.get(i);
		
	}

	public void addOverlay(OverlayItem item) {
		list.add(item);
		populate();
	}
	
	@Override
	public int size() {
		return list.size();
	}

	public void removeAll() {
		list.clear();
		populate();
	}
}
