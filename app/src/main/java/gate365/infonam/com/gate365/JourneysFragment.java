package gate365.infonam.com.gate365;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import gate365.infonam.com.adapter.JourneyAdapter;
import gate365.infonam.com.model.Journey;

/**
 * Created by Neil.Tran on 11/22/2015.
 */
public class JourneysFragment extends Fragment {
    private ArrayList<Journey> mJourneys = new ArrayList<Journey>();
    private RecyclerView mJourneyRecycleView;
    private JourneyAdapter mAdapter;

    private String[] mCityOfCountry;
    private TypedArray mTakeOffPlane;
    private TypedArray mFlightState;
    private TypedArray mDetailJourney;

    public JourneysFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_journeys_layout, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mTakeOffPlane = getResources().obtainTypedArray(R.array.take_off_plane);
        mCityOfCountry = getResources().getStringArray(R.array.cityOfCountry);
        mFlightState = getResources().obtainTypedArray(R.array.flightstate2);
        mDetailJourney = getResources().obtainTypedArray(R.array.journeyDetail);
        for (int i = 0; i < mCityOfCountry.length; i++) {
            mJourneys.add(
                    new Journey(mTakeOffPlane.getResourceId(i, -1),
                            mCityOfCountry[i],
                            mFlightState.getResourceId(i, -1),
                            mDetailJourney.getResourceId(0, -1)));
        }
        mAdapter = new JourneyAdapter(getActivity(), mJourneys);

        mJourneyRecycleView = (RecyclerView)this.getActivity().findViewById(R.id.journeysList);
        mJourneyRecycleView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mJourneyRecycleView.setLayoutManager(linearLayoutManager);
        mJourneyRecycleView.setAdapter(mAdapter);
    }
}
