package gate365.infonam.com.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import gate365.infonam.com.gate365.R;
import gate365.infonam.com.model.HomeItem;

public class HomeItemAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<HomeItem> mHomeItems;

    public HomeItemAdapter(Context context, ArrayList<HomeItem> homeItems) {
        this.mContext = context;
        this.mHomeItems = homeItems;
    }

    @Override
    public int getCount() {
        return mHomeItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mHomeItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rootView = convertView;
        if (rootView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    mContext.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            rootView = mInflater.inflate(R.layout.item_home, null);
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) rootView.findViewById(R.id.image_home_icon);
            viewHolder.text = (TextView) rootView.findViewById(R.id.text_home_title);
            rootView.setTag(viewHolder);
        }
        ViewHolder viewHolder = (ViewHolder) rootView.getTag();
        viewHolder.image.setImageResource(mHomeItems.get(position).getIcon());
        viewHolder.text.setText(mHomeItems.get(position).getTitle());
        return rootView;
    }

    private static class ViewHolder {
        public ImageView image;
        public TextView text;
    }
}
