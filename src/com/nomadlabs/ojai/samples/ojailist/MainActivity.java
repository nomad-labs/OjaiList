package com.nomadlabs.ojai.samples.ojailist;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {

	ArrayAdapter<String> adapter;
	ArrayList<String> listItems;
	EditText input;
	TextView emptyListTV;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		listItems = new ArrayList<String>();
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listItems);
		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(adapter);
		
		input = (EditText) findViewById(R.id.editText1);
		emptyListTV = (TextView) findViewById(R.id.textView1);
		
		Button submitButton = (Button) findViewById(R.id.button1);
		submitButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String inputValue = input.getText().toString();
				if (inputValue != "") {
					addStringToList(inputValue);
				}
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	private void addStringToList(String item) {
		listItems.add(item);
		adapter.notifyDataSetChanged();
		emptyListTV.setVisibility(View.INVISIBLE);
	}

}
