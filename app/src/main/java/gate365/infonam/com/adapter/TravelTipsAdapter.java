package gate365.infonam.com.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import gate365.infonam.com.gate365.R;
import gate365.infonam.com.model.TravelTipsItem;

/**
 * Created by thang.cai on 11/12/2015.
 */
public class TravelTipsAdapter extends BaseAdapter {
    private ArrayList<TravelTipsItem> mTravelTipsItems;
    Context mContext;
    private int mLayOutId;

    public TravelTipsAdapter(Context context, int layOutId, ArrayList<TravelTipsItem> travelTipsItems) {
        this.mContext = context;
        this.mLayOutId = layOutId;
        this.mTravelTipsItems = travelTipsItems;

    }

    @Override
    public int getCount() {
        if (mTravelTipsItems != null) {
            return mTravelTipsItems.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return mTravelTipsItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Viewholder viewholder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(mLayOutId, null);
            viewholder = new Viewholder();
            viewholder.img_CountryFlag = (ImageView) convertView.findViewById(R.id.img_countryflag);
            viewholder.tv_CountryName = (TextView) convertView.findViewById(R.id.text_countryname);
            viewholder.img_FlightState = (ImageView) convertView.findViewById(R.id.img_flightstate);
            viewholder.imgbtn_IconNext = (ImageButton) convertView.findViewById(R.id.imgbtn_iconnext);
            viewholder.imgbtn_IconNext.setOnClickListener(new View.OnClickListener() {
                private int pos = position;

                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "pressed button" + pos, Toast.LENGTH_SHORT).show();
                }
            });
            convertView.setTag(viewholder);
        } else {
            viewholder = (Viewholder) convertView.getTag();
        }
        TravelTipsItem travelTipsItem = mTravelTipsItems.get(position);
        if (travelTipsItem != null) {
            viewholder.img_CountryFlag.setImageResource(travelTipsItem.getCountryFlag());
            viewholder.tv_CountryName.setText(travelTipsItem.getCountryName());
            viewholder.img_FlightState.setImageResource(travelTipsItem.getFlightState());
            viewholder.imgbtn_IconNext.setImageResource(travelTipsItem.getIconNext());
        }
        return convertView;


    }

    static class Viewholder {
        ImageView img_CountryFlag, img_FlightState;
        ImageButton imgbtn_IconNext;
        TextView tv_CountryName;

    }
}
