package co.edu.udea.maps;

import android.app.Activity;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

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
	/**
	 * funcion de onClick para poner el mapa de tipo normal
	 * @param view
	 */
	public void setNormalType(View view){
		
		googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
	}
	/**
	 * funcion de onClick para poner el mapa de tipo Híbrido
	 * @param view
	 */
	public void setHybridType(View view){
		googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		
	}
	/**
	 * funcion de onClick para poner el mapa de tipo Satelite
	 * @param view
	 */
	public void setSatelliteType(View view){
		googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
	}
	/**
	 * funcion de onClick para poner el mapa de tipo Tierra
	 * @param view
	 */
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
				googleMap.setMyLocationEnabled(true);
				
				CameraPosition cameraPosition = new CameraPosition.Builder().target(
		                new LatLng(17.385044, 78.486671)).zoom(12).build();
		 
				googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
				
				googleMap.getUiSettings().setMyLocationButtonEnabled(true);
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
