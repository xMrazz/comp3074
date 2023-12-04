package ca.georgebrown.com.comp3074.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FineDiningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine_dining);

        getSupportActionBar().setTitle("Fine Dining Restaurants");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        LinearLayout linearLayoutRestaurants = findViewById(R.id.linearLayoutRestaurants);
        addRestaurants(linearLayoutRestaurants);
    }

    private void addRestaurants(LinearLayout layout) {
        LayoutInflater inflater = LayoutInflater.from(this);

        Object[][] restaurantsData = {
                {"Le Petit Bistro", "French Cuisine", "4.1", "908 reviews", "Open now", R.drawable.le_petit},
                {"The Grand", "International Cuisine", "4.6", "424 reviews", "Open now", R.drawable.the_grand},
                {"Royal Feast", "Italian Cuisine", "4.2", "811 reviews", "Open now", R.drawable.royal_feast}
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
                    Intent detailIntent = new Intent(FineDiningActivity.this, RestaurantDetailsActivity.class);
                    detailIntent.putExtra("name", (String) data[0]);
                    detailIntent.putExtra("image", (Integer) data[5]);
                    detailIntent.putExtra("rating", (String) data[2]);
                    detailIntent.putExtra("reviews", (String) data[3]);
                    detailIntent.putExtra("address", "123 Main St. Toronto, ON");
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