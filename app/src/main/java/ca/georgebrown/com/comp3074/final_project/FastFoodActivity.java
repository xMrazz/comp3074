package ca.georgebrown.com.comp3074.final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FastFoodActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine_dining);

        getSupportActionBar().setTitle("Fast Food Restaurants");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        LinearLayout linearLayoutRestaurants = findViewById(R.id.linearLayoutRestaurants);
        addRestaurants(linearLayoutRestaurants);
    }

    private void addRestaurants(LinearLayout layout) {
        LayoutInflater inflater = LayoutInflater.from(this);

        Object[][] restaurantsData = {
                {"Bite Haven", "Burgers & Fries", "3.9", "673 reviews", "Open now", R.drawable.bite_haven},
                {"WingMaster", "Chicken Wings", "3.5", "384 reviews", "Open now", R.drawable.wingmaster},
                {"YumRush", "Modern Fast Food", "4.1", "926 reviews", "Open now", R.drawable.yumrush}
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
                    Intent detailIntent = new Intent(FastFoodActivity.this, RestaurantDetailsActivity.class);
                    detailIntent.putExtra("name", (String) data[0]);
                    detailIntent.putExtra("image", (Integer) data[5]);
                    detailIntent.putExtra("rating", (String) data[2]);
                    detailIntent.putExtra("reviews", (String) data[3]);
                    detailIntent.putExtra("address", "317 Dundas St W. Toronto, ON");
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