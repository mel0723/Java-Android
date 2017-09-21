package com.example.melissaarellano.codesection;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.MultiAutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    String[] fruits = {"Apple", "Banana", "Cherry", "Date", "Grape", "Kiwi", "Mango", "Pear"};

        //Creating the instance of ArrayAdapter containing list of fruit names
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this, android.R.layout.select_dialog_item, fruits);
        //Getting the instance of AutoCompleteTextView
        MultiAutoCompleteTextView mactv = (MultiAutoCompleteTextView) findViewById(R.id.multiAutoCompleteTextView1);
        mactv.setThreshold(1);//will start working from first character
        mactv.setAdapter(adapter);//setting the adapter data into the AutoCompleteTextView
        mactv.setTextColor(Color.RED);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar
        // if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.open) {
            startActivity(new Intent("com.example.melissaarellano.codesection.OPEN"));
            return true;
        } else if (itemId == R.id.save_as) {
            startActivity(new Intent("com.example.melissaarellano.codesection.SAVE_AS"));
            return true;
        } else if (itemId == R.id.close) {
                startActivity( new Intent("com.example.melissaarellano.codesection.CLOSE"));
                return true;
        } else if (itemId != R.id.newfile) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            startActivity(new Intent("com.example.melissaarellano.codesection.NEWFILE"));
            return true;
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setIcon(R.drawable.icon).setCancelable(false);
            builder.setTitle("Exit?").setMessage("Do you really want to exit?");
            builder.setPositiveButton("Exit", new homeExit(this));
            builder.setNegativeButton("Cancel", new homeDoNothing(this));
            builder.setCancelable(false);
            try {
                builder.create().show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (i == 82) {
            openOptionsMenu();
        }
        return true;
    }

}