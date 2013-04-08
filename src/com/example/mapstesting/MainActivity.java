package com.example.mapstesting;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends Activity {
	
//	private GoogleMap mMap = null;

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
        
    }
}
