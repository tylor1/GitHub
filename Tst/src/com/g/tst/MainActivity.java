package com.g.tst;

import android.support.v7.app.ActionBarActivity;
// import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.content.Intent;
//import android.view.View;
import android.view.View.OnClickListener;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.util.Log;

public class MainActivity extends ActionBarActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}
	

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
			startActivity(new Intent(this,Settings.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements OnClickListener {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);

			if (rootView != null){
				View continueButton = rootView.findViewById(R.id.continue_button);
				if (continueButton != null)
					continueButton.setOnClickListener(this);
				View newButton = rootView.findViewById(R.id.new_game_button);
				if (newButton != null)
					newButton.setOnClickListener(this);
				View aboutButton = rootView.findViewById(R.id.about_button);
				if (aboutButton != null)
					aboutButton.setOnClickListener(this);
				View exitButton = rootView.findViewById(R.id.exit_button);
				if (exitButton != null)
					exitButton.setOnClickListener(this);
			}

			return rootView;
		}

	    @Override
	    public void onClick(View v) {
			switch(v.getId()){
			case R.id.about_button:
				Intent i = new Intent(this.getActivity(), About.class);
				startActivity(i);
				break;
				// more button go here (if any)...
			case R.id.exit_button:
				getActivity().finish();
				break;
			case R.id.new_game_button:
				openNewGameDialog();
				break;
			}
	    }
	    
	    private static final String TAG="Sudoku";
	    private void openNewGameDialog(){
	    	new AlertDialog.Builder(getActivity())
	    	.setTitle(R.string.new_game_title)
	    	.setItems(R.array.difficulty, new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					startGame(which);
				}
			}).show();
	    }
	    
	    private void startGame(int i){
	    	Log.d(TAG,"clicked on " + i);
	    	Intent intent = new Intent(getActivity(), Game.class);
	    	intent.putExtra(Game.KEY_DIFFECULTY, i);
	    	startActivity(intent);
	    }
	}

}
