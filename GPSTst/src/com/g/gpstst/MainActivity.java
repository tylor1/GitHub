package com.g.gpstst;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.widget.TextView;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity implements LocationListener {

	private static final String[] A = { "n/a", "fine", "coarse" };
	private static final String[] P = { "n/a", "low", "medium",
		"high" };
	private static final String[] S = { "out of service",
		"temporarily unavailable", "available" };
	
	private LocationManager mgr;
	private TextView output;
	private String best;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);

		mgr = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
		//View rootView = findViewById(R.layout.fragment_main);
		output = (TextView)findViewById(R.id.output);

		log("\nLocation providers:");
		dumpProviders();
		Criteria criteria = new Criteria();
		criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(true);
        criteria.setBearingRequired(true);
        criteria.setCostAllowed(true);
        criteria.setPowerRequirement(Criteria.POWER_LOW);

		if (mgr != null)
			best = mgr.getBestProvider(criteria, true);
		log("\nBest provider is: " + best);
		log("\nLocations (starting with last know):");
		Location location;
		if (best != null)
		if (mgr != null){
			location = mgr.getLastKnownLocation(best);
			dumpLocation(location);
		}
		mgr.requestLocationUpdates(best, 2000, 10, this);
/**/
	}
/*
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
*/
	/**
	 * A placeholder fragment containing a simple view.
	 */
/*	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
*/

	@Override
	public void onLocationChanged(Location arg0) {
		// TODO Auto-generated method stub

		dumpLocation(arg0);
/**/
	}

	@Override
	public void onProviderDisabled(String arg0) {
		// TODO Auto-generated method stub

		log("\nProvider disabled: " + arg0);
/**/
	}

	@Override
	public void onProviderEnabled(String arg0) {
		// TODO Auto-generated method stub

		log("\nProvider enabled: " + arg0);
/**/
	}

	@Override
	public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
		// TODO Auto-generated method stub

		log("\nProvider status changed: " + arg0 + ", status="
	            + S[arg1] + ", extras=" + arg2);
/**/
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
/*		
		if (mgr != null)
			mgr.removeUpdates(this);
*/
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
/*
		if (best != null)
		if (mgr != null)
			mgr.requestLocationUpdates(best, 15000, 1, this);
*/
	}

	private void log(String string) {

		if (output != null)
			output.append(string + "\n");
/**/
	}

	private void dumpProviders() {
	
		if (mgr == null)
			return;
/*		
		List<String> providers = mgr.getAllProviders();
		for (String provider : providers) {
			dumpProvider(provider);
		}
*/
	}

	private void dumpProvider(String provider) {

		if (mgr == null)
			return;

		LocationProvider info = mgr.getProvider(provider);
		StringBuilder builder = new StringBuilder();
		builder.append("LocationProvider[")
		.append("name=")
		.append(info.getName())
		.append(",enabled=")
		.append(mgr.isProviderEnabled(provider))
		.append(",getAccuracy=")
		.append(A[info.getAccuracy()])
		.append(",getPowerRequirement=")
		.append(P[info.getPowerRequirement()])
		.append(",hasMonetaryCost=")
		.append(info.hasMonetaryCost())
	    .append(",requiresCell=")
	    .append(info.requiresCell())
	    .append(",requiresNetwork=")
	    .append(info.requiresNetwork())
	    .append(",requiresSatellite=")
	    .append(info.requiresSatellite())
	    .append(",supportsAltitude=")
	    .append(info.supportsAltitude())
	    .append(",supportsBearing=")
	    .append(info.supportsBearing())
	    .append(",supportsSpeed=")
	    .append(info.supportsSpeed())
	    .append("]");
		log(builder.toString());
/**/
	}

	private void dumpLocation(Location location) {

		if (location == null)
			log("\nLocation[unknown]");
		else
			log("\n" + location.toString());
/**/
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

		if (mgr != null)
			mgr.removeUpdates(this);
/**/
	}
}
