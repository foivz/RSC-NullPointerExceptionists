package com.npe.donation;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.npe.drawer.FragmentAchivments;
import com.npe.drawer.FragmentDoniraj;
import com.npe.drawer.FragmentInstitucija;
import com.npe.drawer.FragmentNovosti;
import com.npe.drawer.FragmentProfil;
import com.npe.drawer.FragmentStatistika;
import com.npe.helpers.DatabaseManager;



public class MainActivity extends ActionBarActivity {
	
	
	private DrawerLayout dLayout;
	private Fragment fragment = null;
	private ListView dList;
	
	private ArrayAdapter<String> adapter;
	private ActionBarDrawerToggle mDrawerToggle;
	
	private String[] menu;
	private String Title;
	
	private DatabaseManager database;
	

	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		database = new DatabaseManager(this);
		

		setContentView(R.layout.activity_main);

		menu = new String[] { "Doniraj", "Novosti", "Statistika", "Achivments",
				"Institucija info", "Profil" };
		dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		//list view i adapter za rad s listom
		dList = (ListView) findViewById(R.id.left_drawer);
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, menu);
		dList.setAdapter(adapter);
		dList.setSelector(android.R.color.holo_blue_dark);
		//default fragmet kod otvaranja aktivnosti
		fragment=new FragmentNovosti();
		FragmentManager fragmentManager = getFragmentManager();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, fragment).commit();
		//pozivanje pojedninog fragmenta na klik
		dList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int position,
					long id) {
				dLayout.closeDrawers();
				
				switch (position) {
				case 0:
					fragment = new FragmentDoniraj();
					break;
				case 1:
					fragment = new FragmentNovosti();
					break;
				case 2:
					fragment = new FragmentStatistika();
					break;
				case 3:
					fragment = new FragmentAchivments();
					break;
				case 4:
					fragment = new FragmentInstitucija();
					break;
				case 5:
					fragment = new FragmentProfil();
					break;

				}
				if (fragment != null) {
					FragmentManager fragmentManager = getFragmentManager();
					fragmentManager.beginTransaction()
							.replace(R.id.content_frame, fragment).commit();

				}

			}
		});
		//otvaranje nav drawera i zatvaranje
		mDrawerToggle = new ActionBarDrawerToggle(this, dLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close){
			@Override
			public void onDrawerClosed(View drawerView) {
				// TODO Auto-generated method stub
				super.onDrawerClosed(drawerView);
				 getActionBar().setTitle(Title);
				
			}
			
			@Override
					public void onDrawerOpened(View drawerView) {
						// TODO Auto-generated method stub
						super.onDrawerOpened(drawerView);
						getActionBar().setTitle(Title);
					}
			
		};
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
	}
	
	 
	    @Override
	    protected void onPostCreate(Bundle savedInstanceState) {
	        super.onPostCreate(savedInstanceState);
	        // Sync the toggle state after onRestoreInstanceState has occurred.
	        mDrawerToggle.syncState();
	    }
	 
	    @Override
	    public void onConfigurationChanged(Configuration newConfig) {
	        super.onConfigurationChanged(newConfig);
	        mDrawerToggle.onConfigurationChanged(newConfig);
	    }
	 
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Pass the event to ActionBarDrawerToggle, if it returns
	        // true, then it has handled the app icon touch event
	        if (mDrawerToggle.onOptionsItemSelected(item)) {
	            return true;
	        }
	        // Handle your other action bar items...
	 
	        return super.onOptionsItemSelected(item);
	    }
	 
	    /**
	     * Swaps fragments in the main content view
	     */
	    private void selectItem(int position) {
	        Toast.makeText(this, R.string.app_name, Toast.LENGTH_SHORT).show();
	 
	        // Highlight the selected item, update the title, and close the drawer
	        dList.setItemChecked(position, true);
	        setTitle(menu[position]);
	        dLayout.closeDrawer(dList);
	    }
	 
	    @Override
	    public void setTitle(CharSequence title) {
	        Title = (String) title;
	        getSupportActionBar().setTitle(Title);
	    }
	 
	    private class DrawerItemClickListener implements ListView.OnItemClickListener {
	        @Override
	        public void onItemClick(AdapterView parent, View view, int position, long id) {
	            selectItem(position);
	        }
	    }
	 
	    
	    
	    
	    
	    @Override
	    protected void onStart() {
	    	// TODO Auto-generated method stub
	    	super.onStart();
	    	new CheckUser().execute();
	    }
	    
	    
	    
	    
	    private class CheckUser extends AsyncTask<Void, Void, Boolean>{
	    	private ProgressDialog pd;
	    	
	    	@Override
	    	protected void onPreExecute() {
	    		// TODO Auto-generated method stub
	    		super.onPreExecute();
	    		pd = new ProgressDialog(MainActivity.this);
	    		pd.show();
	    	}
	    	
			@Override
			protected Boolean doInBackground(Void... params) {
				// TODO Auto-generated method stub				
				return database.userLoggedIn();
			}
			
			@Override
			protected void onPostExecute(Boolean result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			if(pd.isShowing())
				pd.dismiss();
			if(!result){
				Intent intent = new Intent(MainActivity.this, LoginActivity.class);
				finish();
				startActivity(intent);
				}
			}// end void onPostExecute()
	    }// end class checkUser
	    
	    
}
