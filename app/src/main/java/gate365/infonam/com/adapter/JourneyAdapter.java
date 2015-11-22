package gate365.infonam.com.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import gate365.infonam.com.gate365.R;
import gate365.infonam.com.model.Journey;

/**
 * Created by Neil.Tran on 11/22/2015.
 */
public class JourneyAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private ArrayList<Journey> mJourneys;

    public JourneyAdapter(Context context, ArrayList<Journey> journeys) {
        this.mContext = context;
        this.mJourneys = journeys;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.journey_item_layout, null);
        return new JourneyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Journey journey = mJourneys.get(position);
        JourneyViewHolder journeyViewHolder = (JourneyViewHolder) holder;
        Picasso.with(mContext).load(journey.getPlanState()).into(((JourneyViewHolder) holder).flightTakeOffPlaneImageView);
        journeyViewHolder.cityOfCountryTextView.setText(journey.getCityOfCountry());
        Picasso.with(mContext).load(journey.getFlightState()).into(journeyViewHolder.flightStateImageView);
        journeyViewHolder.detailJourneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Journey go to " + journey.getCityOfCountry().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mJourneys == null ? 0 : mJourneys.size();
    }

    public class JourneyViewHolder extends RecyclerView.ViewHolder {
        public ImageView flightTakeOffPlaneImageView;
        public TextView cityOfCountryTextView;
        public ImageView flightStateImageView;
        public ImageButton detailJourneyButton;

        public JourneyViewHolder(View itemView) {
            super(itemView);
            this.flightTakeOffPlaneImageView = (ImageView) itemView.findViewById(R.id.flightTakeOffPlaneImageView);
            this.cityOfCountryTextView = (TextView) itemView.findViewById(R.id.cityOfCountryTextView);
            this.flightStateImageView = (ImageView) itemView.findViewById(R.id.flightStateImageView);
            this.detailJourneyButton = (ImageButton) itemView.findViewById(R.id.detailJourneyButton);
        }
    }
}
