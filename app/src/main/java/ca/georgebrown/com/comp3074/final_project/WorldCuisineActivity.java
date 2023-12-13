package ca.georgebrown.com.comp3074.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class WorldCuisineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_world_cuisine);

        getSupportActionBar().setTitle("World Cuisine");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        LinearLayout linearLayoutRestaurants = findViewById(R.id.linearLayoutRestaurants);
        addRestaurants(linearLayoutRestaurants);
    }

    private void addRestaurants(LinearLayout layout) {
        LayoutInflater inflater = LayoutInflater.from(this);

        Object[][] restaurantsData = {
                {"Polskie Smaki Tavern", "Polish Cuisine", "4.9", "672 reviews", "Open now", R.drawable.polskie_smaki},
                {"Dim Sum Dynasty", "Chinese Cuisine", "4.3", "762 reviews", "Open now", R.drawable.dim_dum},
                {"Bratwurst Bliss Bistro", "German Cuisine", "4.2", "441 reviews", "Open now", R.drawable.bratwurst_bliss},
                {"Bread Meat n Cheese", "American Cuisine", "3.4", "875 reviews", "Open now", R.drawable.bread_meatncheese},
                {"Falafel Oasis", "Middle Eastern Cuisine", "4.7", "681 reviews", "Open now", R.drawable.falafel_oasis}
        };

        for (Object[] data : restaurantsData) {
            View restaurantView = inflater.inflate(R.layout.restaurant_item, layout, false);

            TextView textViewName = restaurantView.findViewById(R.id.textViewName);
            textViewName.setText((String) data[0]);

            TextView textViewCuisine = restaurantView.findViewById(R.id.textViewCuisine);
            textViewCuisine.setText((String) data[1]);

            TextView textViewRating = restaurantView.findViewById(R.id.textViewRating);
            textViewRating.setText((String) data[2]);

            TextView textViewReviewCount = restaurantView.findViewById(R.id.textViewReviewCount);
            textViewReviewCount.setText((String) data[3]);

            TextView textViewOpenNow = restaurantView.findViewById(R.id.textViewOpenNow);
            textViewOpenNow.setText((String) data[4]);

            ImageView imageViewRestaurant = restaurantView.findViewById(R.id.imageViewRestaurant);
            imageViewRestaurant.setImageResource((Integer) data[5]);

            restaurantView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Launch the RestaurantDetailsActivity, it will pass the details of the restaurant clicked
                    Intent detailIntent = new Intent(WorldCuisineActivity.this, RestaurantDetailsActivity.class);
                    detailIntent.putExtra("name", (String) data[0]);
                    detailIntent.putExtra("image", (Integer) data[5]);
                    detailIntent.putExtra("rating", (String) data[2]);
                    detailIntent.putExtra("reviews", (String) data[3]);
                    detailIntent.putExtra("address", "40 Bay St. Toronto, ON");
                    startActivity(detailIntent);
                }
            });

            layout.addView(restaurantView);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
