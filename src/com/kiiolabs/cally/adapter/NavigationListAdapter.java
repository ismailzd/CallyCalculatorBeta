package com.kiiolabs.cally.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiiolabs.cally.R;
import com.kiiolabs.cally.model.bean.NavigationItem;

/**
 * This is the List adapter containing the items of the navigation bar
 * 
 * @author Ismail Zaidi
 *
 */
public class NavigationListAdapter extends BaseAdapter {

	private Context context;
	private ArrayList<NavigationItem> navDrawerItems;

	public NavigationListAdapter(Context context, ArrayList<NavigationItem> navDrawerItems) {
		this.context = context;
		this.navDrawerItems = navDrawerItems;
	}

	@Override
	public int getCount() {
		return navDrawerItems.size();
	}

	@Override
	public Object getItem(int position) {
		return navDrawerItems.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
			convertView = mInflater.inflate(R.layout.drawer_list_item, null);
		}

		ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
		TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
		imgIcon.setImageResource(navDrawerItems.get(position).getIcon());
		txtTitle.setText(navDrawerItems.get(position).getTitle());
		Typeface font = Typeface.createFromAsset(context.getAssets(), "MankSans-Medium.ttf");
		txtTitle.setTypeface(font);

		return convertView;
	}

}
