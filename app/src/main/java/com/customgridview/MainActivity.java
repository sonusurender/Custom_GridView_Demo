package com.customgridview;

import java.util.ArrayList;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	GridView grid;

	// String array for image titles
	private static final String title[] = { "Cupcake", "Donut", "Eclair",
			"Froyo", "Gingerbread", "HoneyComb" };

	// Integer array for drawable images
	private static final Integer Images[] = { R.drawable.cupcake,
			R.drawable.donut, R.drawable.eclair, R.drawable.froyo,
			R.drawable.gingerbread, R.drawable.honeycomb };

	ArrayList<Items> arrayList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		grid = (GridView) findViewById(R.id.gridView1);

		// Array list for storing data in Items class
		arrayList = new ArrayList<Items>();

		// For loop to add data in array list
		for (int i = 0; i < Images.length; i++) {
			arrayList.add(new Items(title[i], Images[i]));
		}

		// Setting data in custom adapter
		CustomGridViewAdapter adapter = new CustomGridViewAdapter(
				MainActivity.this, arrayList);

		grid.setAdapter(adapter);

		adapter.notifyDataSetChanged();

		grid.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int pos,
					long id) {

				// Starting a new activity and passing image id
				Intent in = new Intent(MainActivity.this,
						SingleImageActivity.class);
				in.putExtra("image", arrayList.get(pos).getImages());
				startActivity(in);

			}
		});
	}

}
