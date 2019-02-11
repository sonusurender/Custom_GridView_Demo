package com.customgridview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ImageView;

public class SingleImageActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.singleimageactivity);

		// Getting Intent from MainActivity and storing in int variable
		int imagePath = getIntent().getIntExtra("image", 0);

		ImageView image = (ImageView) findViewById(R.id.singleImage);

		// Setting imagePath to image
		image.setBackgroundResource(imagePath);
	}
}
