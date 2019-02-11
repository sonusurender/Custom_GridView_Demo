package com.customgridview;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomGridViewAdapter extends BaseAdapter {
	ArrayList<Items> arrayList;
	LayoutInflater inflater;
	ViewHolder holder = null;

	public CustomGridViewAdapter(Context context, ArrayList<Items> arrayList) {
		this.arrayList = arrayList;
		this.inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return arrayList.size();
	}

	@Override
	public Object getItem(int pos) {
		// TODO Auto-generated method stub
		return arrayList.get(pos);
	}

	@Override
	public long getItemId(int pos) {
		// TODO Auto-generated method stub
		return pos;
	}

	@Override
	public View getView(int pos, View view, ViewGroup root) {

		if (view == null) {

			view = inflater.inflate(R.layout.customview, root, false);
			holder = new ViewHolder();

			holder.image = (ImageView) view.findViewById(R.id.imageView);
			holder.text = (TextView) view.findViewById(R.id.textView);

			view.setTag(holder);

		} else {
			holder = (ViewHolder) view.getTag();
		}

		// Setting image and title from arraylist
		holder.image.setBackgroundResource(arrayList.get(pos).getImages());
		holder.text.setText(arrayList.get(pos).getTitle());

		return view;
	}

	// View holder class to hold the views
	public class ViewHolder {
		ImageView image;
		TextView text;
	}
}
