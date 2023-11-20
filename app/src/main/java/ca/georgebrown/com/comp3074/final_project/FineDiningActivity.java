package ca.georgebrown.com.comp3074.final_project;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class FineDiningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fine_dining);

        LinearLayout linearLayoutRestaurants = findViewById(R.id.linearLayoutRestaurants);
        addRestaurants(linearLayoutRestaurants);
    }

    private void addRestaurants(LinearLayout layout) {
        LayoutInflater inflater = LayoutInflater.from(this);

        // Le Petit Bistro
        View restaurantView = inflater.inflate(R.layout.restaurants, layout, false);

        TextView textViewName = restaurantView.findViewById(R.id.textViewName);
        textViewName.setText("Le Petit Bistro");

        TextView textViewCuisine = restaurantView.findViewById(R.id.textViewCuisine);
        textViewCuisine.setText("French Cuisine");

        TextView textViewRating = restaurantView.findViewById(R.id.textViewRating);
        textViewRating.setText("4.1");

        TextView textViewReviewCount = restaurantView.findViewById(R.id.textViewReviewCount);
        textViewReviewCount.setText("908 reviews");

        TextView textViewOpenNow = restaurantView.findViewById(R.id.textViewOpenNow);
        textViewOpenNow.setText("Open now");

        // Add the restaurant view to the LinearLayout
        layout.addView(restaurantView);

        // More Restaurants will be below
    }
}