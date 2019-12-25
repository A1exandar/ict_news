package com.reader.ictnews;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class StartON extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_layout);

		ImageButton hardwareButton = (ImageButton) findViewById(R.id.imageButtonHardware);
		hardwareButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent hardintent = new Intent(v.getContext(), ITNewsHardwareActivity.class);
				startActivity(hardintent);				
			}
		});
		
		ImageButton softwareButton = (ImageButton) findViewById(R.id.imageButtonSoftware);
		softwareButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent softintent = new Intent(v.getContext(), ITNewsSoftwareActivity.class);
			startActivity(softintent);				
		}
	});
		
		ImageButton mobileButton = (ImageButton) findViewById(R.id.imageButtonMobile);
		mobileButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent mobintent = new Intent(v.getContext(), ITNewsMobileActivity.class);
			startActivity(mobintent);		
		}
		});
		
		ImageButton businessButton = (ImageButton) findViewById(R.id.imageButtonITBusiness);
		businessButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent bizintent = new Intent(v.getContext(), ITNewsBusinessActivity.class);
			startActivity(bizintent);		
		}
		});
		
		ImageButton securityButton = (ImageButton) findViewById(R.id.imageButtonSecurity);
		securityButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent secintent = new Intent(v.getContext(), ITNewsSecurityActivity.class);
			startActivity(secintent);		
		}
		});
		
		ImageButton webButton = (ImageButton) findViewById(R.id.imageButtonInternet);
		webButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent webintent = new Intent(v.getContext(), ITNewsWebActivity.class);
			startActivity(webintent);		
		}
		});
	}
}
