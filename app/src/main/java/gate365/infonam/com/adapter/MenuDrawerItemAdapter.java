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
import gate365.infonam.com.model.MenuDrawerItemModel;

/**
 * Created by Thoai Bui on 11/9/2015.
 */
public class MenuDrawerItemAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<MenuDrawerItemModel> mMenuDrawerItemModels;

    public MenuDrawerItemAdapter(Context context, ArrayList<MenuDrawerItemModel> navDrawerItems) {
        this.context = context;
        this.mMenuDrawerItemModels = navDrawerItems;
    }

    @Override
    public int getCount() {
        return mMenuDrawerItemModels.size();
    }

    @Override
    public Object getItem(int position) {
        return mMenuDrawerItemModels.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.row_listview_menu_item, null);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.imageViewIcon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.textViewTitle);
        imgIcon.setImageResource(mMenuDrawerItemModels.get(position).getIcon());
        txtTitle.setText(mMenuDrawerItemModels.get(position).getTitle());

        return convertView;
    }
}
