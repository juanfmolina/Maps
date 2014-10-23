package co.edu.udea.maps;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;

public class MapsActivity extends Activity {

	private GoogleMap googleMap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_maps);

		try {
			// Loading map
			initilizeMap();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void setNormalType(View view){
		
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	}
	public void setHybridType(View view){
		googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		
	}
	public void setSatelliteType(View view){
		googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	}
	public void setTerrainType(View view){
		googleMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);
	}

	/**
	 * function to load map. If map is not created it will create it for you
	 * */
	private void initilizeMap() {
		
		if (googleMap == null) {
			googleMap = ((MapFragment) getFragmentManager().findFragmentById(
					R.id.map)).getMap();

			// check if map is created successfully or not
			if (googleMap == null) {
				Toast.makeText(getApplicationContext(),
						"Sorry! unable to create maps", Toast.LENGTH_SHORT)
						.show();
			} else {
				googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
							
			}
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		initilizeMap();
	}

}
