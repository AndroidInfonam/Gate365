package gate365.infonam.com.gate365;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ThanhThoai on 11/10/2015.
 */
public class JourneysFragment extends Fragment{
    public JourneysFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_journeys, container, false);

        return rootView;
    }
}
