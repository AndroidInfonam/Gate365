package gate365.infonam.com.gate365;

import android.app.Fragment;
import android.content.res.TypedArray;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import gate365.infonam.com.adapter.TravelTipsAdapter;
import gate365.infonam.com.model.TravelTipsItem;

public class TravelTipsFragment extends Fragment {
    private ArrayList<TravelTipsItem> mTravelTipsItems;
    private ListView mListViewTraveltips;
    private TravelTipsAdapter mAdapter;
    private String[] mCountryName;
    private TypedArray mCountryFlag;
    private TypedArray mFlightState;
    private TypedArray mIconNext;


    public TravelTipsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_travel_tips, container, false);
        mCountryFlag = getResources().obtainTypedArray(R.array.countryflag);
        mCountryName = getResources().getStringArray(R.array.countryname);
        mFlightState = getResources().obtainTypedArray(R.array.flightstate);
        mIconNext = getResources().obtainTypedArray(R.array.iconnext);
        mTravelTipsItems = new ArrayList<TravelTipsItem>();
        for (int i = 0; i < mCountryName.length; i++) {
            mTravelTipsItems.add(new TravelTipsItem(mCountryFlag.getResourceId(i, -1), mCountryName[i], mFlightState.getResourceId(i, -1), mIconNext.getResourceId(0, -1)));

        }
        mAdapter = new TravelTipsAdapter(getActivity(), R.layout.row_list_traveltips_item, mTravelTipsItems);
        mListViewTraveltips = (ListView) v.findViewById(R.id.list_traveltips);
        mListViewTraveltips.setAdapter(mAdapter);
        mListViewTraveltips.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), "position" + position, Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
