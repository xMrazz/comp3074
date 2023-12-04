package ca.georgebrown.com.comp3074.final_project;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RestaurantDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        getSupportActionBar().setTitle("Restaurant Details");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // This part gets the data from the previous activity
        String name = getIntent().getStringExtra("name");
        int imageResource = getIntent().getIntExtra("image", 0);
        String rating = getIntent().getStringExtra("rating");
        String address = getIntent().getStringExtra("address");

        // Set data to views in order to display it when clicked
        ((TextView) findViewById(R.id.textViewRestaurantName)).setText(name);
        ((ImageView) findViewById(R.id.imageViewRestaurant)).setImageResource(imageResource);
        ((TextView) findViewById(R.id.textViewRating)).setText("Rating: " + rating + "/5");
        ((TextView) findViewById(R.id.textViewAddress)).setText(address);
        ((TextView) findViewById(R.id.textViewAddress)).setText(address);

        // Get Directions button
        findViewById(R.id.buttonGetDirections).setOnClickListener(view -> {
            Uri gmmIntentUri = Uri.parse("google.navigation:q=" + Uri.encode(address));
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            if (mapIntent.resolveActivity(getPackageManager()) != null) {
                startActivity(mapIntent);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}