package gate365.infonam.com.gate365;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import gate365.infonam.com.adapter.HomeItemAdapter;
import gate365.infonam.com.model.HomeItem;

public class Gate365Activity extends TimeToolbar {
    private TypedArray mHomeIcons;
    private String[] mHomeTitles;
    private ArrayList<HomeItem> mHomeItems;
    private ListView mHomeList;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_gate365);
        getWidgets();
        addActionBarDrawerToggle();
        addItemToHomeList();
    }

    @Override
    protected void setTime() {
        super.setTime();
    }

    @Override
    protected void getWidgets() {
        createToolbar();
    }

    @Override
    protected void setEvents() {
    }

    protected void addActionBarDrawerToggle() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout_gate365);
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.drawer_open,
                R.string.drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                invalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    private void addItemToHomeList() {
        mHomeIcons = getResources().obtainTypedArray(R.array.home_icons);
        mHomeTitles = getResources().getStringArray(R.array.home_titles);
        mHomeItems = new ArrayList<HomeItem>();
        for (int i = 0; i < mHomeIcons.length(); i++) {
            mHomeItems.add(new HomeItem(mHomeIcons.getResourceId(i, -1), mHomeTitles[i]));
        }
        mHomeList = (ListView) findViewById(R.id.list_gate365);
        HomeItemAdapter homeItemAdapter = new HomeItemAdapter(getApplicationContext(), mHomeItems);
        mHomeList.setAdapter(homeItemAdapter);
        mHomeList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
            }
        });
    }

    private void selectItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                //fragment = new JourneysFragment();
                break;
            case 1:
                //fragment = new Fragment1();
                break;
            case 2:
                //fragment = new Fragment2();
                break;
            case 3:
                fragment = new CountryRisksFragment();
                break;
            case 4:
                //fragment = new Fragment4();

                fragment=new TravelTipsFragment();
                break;
            case 5:
                //fragment = new Fragment5();
                break;
            default:
                break;
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.frame_gate365, fragment).commit();
            mHomeList.setItemChecked(position, true);
            mHomeList.setSelection(position);
            mDrawerLayout.closeDrawer(mHomeList);
        } else {
            Log.e(Gate365Activity.class.getSimpleName(), "Error in creating fragment");
        }
    }
}

