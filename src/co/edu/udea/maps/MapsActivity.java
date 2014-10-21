package co.edu.udea.maps;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

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
     * function to load map. If map is not created it will create it for you
     * */
    private void initilizeMap() {
        if (googleMap == null) {
            googleMap = ((MapFragment)getFragmentManager().findFragmentById(
                    R.id.map)).getMap();
 
            // check if map is created successfully or not
            if (googleMap == null) {
                Toast.makeText(getApplicationContext(),
                        "Sorry! unable to create maps", Toast.LENGTH_SHORT)
                        .show();
            }else{
            	googleMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
            	// latitude and longitude
            	double latitude = 6.267588;
            	double longitude = -75.567722;
            	 
            	// create marker
            	MarkerOptions marker = new MarkerOptions().position(new LatLng(latitude, longitude)).title("Hello Maps ");
            	 
            	// adding marker
            	googleMap.addMarker(marker);
            }
        }
    }
 
    @Override
    protected void onResume() {
        super.onResume();
        initilizeMap();
    }
 
}

