package com.example.test_drawer;

import android.os.Bundle;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class NavigationDrawer extends ActionBarActivity {
	private String[] menu;
	private String Title;
	private DrawerLayout dLayout;
	private ListView dList;
	private ArrayAdapter<String> adapter;
	private ActionBarDrawerToggle mDrawerToggle;
	private Fragment fragment=null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
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
				R.drawable.ic_launcher, R.string.drawer_open,
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
	 
}
