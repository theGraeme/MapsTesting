package com.example.mapstesting;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends Activity {

	private GoogleMap mMap = null;

	/**
	 * This is just a learning project.  From Google's Maps API documentation:
	 * "This code should not be used in a production application. 
	 * Examples of how to add more robust code appear throughout this guide and in the sample code."
	 * 
	 * Good enough for this PoC, though.  
	 * Graeme Campbell, 2013-04-08
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		//		int servicesAvailable = GooglePlayServicesUtil.isGooglePlayServicesAvailable(getApplicationContext())   ;
		//  Expected result would be ConnectionResult.SUCCESS;
		//TODO:  Other results should be checked for and handled gently.  

		setContentView(R.layout.activity_main);

		if (mMap == null) {
			mMap = ( (MapFragment)getFragmentManager().findFragmentById(R.id.map)  ).getMap();
		}


		if (mMap != null) {
			// The Map is verified. It is now safe to manipulate the map.
			drawTestJunk();
		}
	}

	
	
	private void drawTestJunk() {
		
		/**
		 *  These XML tags worked nicely in the activity_main.xml file: 
		 *   
				map:uiZoomControls="true"
				map:uiCompass="true"
				map:uiTiltGestures="false"
				map:cameraTargetLat="45.53"
				map:cameraTargetLng="-73.59"
				map:cameraZoom="14"
		 * 
		 * They've been removed from the xml.  Now, the same functionality done with code:
		 */
		
		UiSettings settings = mMap.getUiSettings();
		
		settings.setZoomControlsEnabled(true);
		settings.setCompassEnabled(true);
		settings.setTiltGesturesEnabled(false);
		
		settings.setMyLocationButtonEnabled(true);
		
		CameraUpdate camUpdate = CameraUpdateFactory.newLatLngZoom(new LatLng(45.53, -73.59), 14);
		mMap.moveCamera(camUpdate);
		
		
		
		/**
		 * "Markers" lesson
		 */
		mMap.addMarker(new MarkerOptions()
		.position(new LatLng(45.538490,-73.598480))
		.title("Hello world")
		.snippet("what does a snippet look like?")
		.draggable(true)
		.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
				);
		/**
		 * skipping other "Marker" lessons, to move on to Lines, Polygons, and Circles.
		 * Topic list for later study:
		 * 	- Customized info windows
		 *  - Marker click events
		 *  - Marker drag events
		 *  - Info window click events
		 */


		/**
		 * "Lines, Polygons, and Circles" lesson
		 */

		// LINE
		PolylineOptions route = new PolylineOptions()
		.add(new LatLng(45.538451240403596, -73.59851807077722) )
		.add(new LatLng(45.5390432, -73.5997465) )
		.add(new LatLng(45.5387234, -73.6000517) )
		.add(new LatLng(45.5389376, -73.6005275) )
		.color(Color.GREEN)
		;


		Polyline polyline = mMap.addPolyline(route);
		//you can also call PolylineOptions.addAll(Iterable<LatLng>) if the points are already in a list


		// POLYGON
		ArrayList<LatLng> hole= new ArrayList<LatLng>();
		hole.add(new LatLng(45.5275, -73.5925));
		hole.add(new LatLng(45.5225, -73.5925));
		hole.add(new LatLng(45.5225, -73.5975));
		hole.add(new LatLng(45.5275, -73.5975));

		PolygonOptions rectOptions = new PolygonOptions()
		.add(new LatLng(45.53, -73.59),
				new LatLng(45.52, -73.59),
				new LatLng(45.52, -73.60),
				new LatLng(45.53, -73.60),
				new LatLng(45.53, -73.59))
				.addHole(hole)
				.strokeColor(Color.RED)
				.fillColor(Color.BLUE);

		Polygon polygon = mMap.addPolygon(rectOptions);
		
		// And sure, why not, a CIRCLE
		CircleOptions circleOptions = new CircleOptions()
		.center(new LatLng(45.525, -73.595))
		.radius(100); 

		Circle circle = mMap.addCircle(circleOptions);

	}



}
