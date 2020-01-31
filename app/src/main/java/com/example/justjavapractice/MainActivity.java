package com.example.justjavapractice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
/*
This app displays an order form to order coffee
 */

public class MainActivity extends AppCompatActivity {
    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    This method is called when plus button is clicked
     */
    public void increment(View view){
        // To prevent too many cup of coffee order(more than 100)
        if (quantity == 100){
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    /*
    This method is called when minus button is clicked
     */
    public void decrement(View view){
        // To prevent negative number of coffee order
        if(quantity == 1){
            // Show an error message as a toast
            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
            // Exit this method early because there's nothing left to do
            return;
        }
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    /*
    This method is called when order button is clicked
     */
    public void submitOrder(View view){
        // Take customer name from the customer
        EditText nameField = findViewById(R.id.name_field);
        String name = nameField.getText().toString();

        // Figure out if the user wants whipped cream topping
        CheckBox whippedCreamCheckBox = findViewById(R.id.whipped_cream_checkBox);
        boolean hasWhippedCheckBox = whippedCreamCheckBox.isChecked();

        // Figure out if the user wants chocolate topping
        CheckBox chocolateCheckBox = findViewById(R.id.chocolate_checkBox);
        boolean hasChocolateCheckBox = chocolateCheckBox.isChecked();

        // Calculate the price
        int price = calculatePrice(hasWhippedCheckBox, hasChocolateCheckBox);

        // Display the order summary on the screen
        String priceMessage = createOrderSummary(name, price, hasWhippedCheckBox, hasChocolateCheckBox);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        //intent.putExtra(Intent.EXTRA_EMAIL, addresses); // this code is used for fix email(To,)
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /**
     * Calculates the price of the order.
     * @param addWhippedCream is whether or not the user whipped Cream toppings
     * @param  addChocolate   is whether or not the user chocolate toppings
     *
     * @quantity is the number of cups of coffee ordered
     * @return total price.
     */
    private int calculatePrice(boolean addWhippedCream, boolean addChocolate) {
        // price of 1 cup of coffee
        int basePrice = 5;
        // add $1 if the user wants whipped cream
        if (addWhippedCream){
            basePrice = basePrice + 1;
        }
        // add $2 if the user wants Chocolate
        if (addChocolate){
            basePrice = basePrice + 2;
        }
        return quantity * basePrice;

    }

    /**
     * create summary of the order.
     * @param name of the customer
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped Cream topping
     * @param addChocolate is whether or not the user wants chocolate topping
     * @return text summary.
     */
    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate){
        String priceMessage = "Name: " + name;
        priceMessage += "\nAdd whipped Cream? " + addWhippedCream;
        priceMessage += "\n Add Chocolate? " + addChocolate;
        priceMessage += "\n Quantity: " + quantity;
        priceMessage += "\n Total: $" + price;
        priceMessage += "\n" + getString(R.string.thank_you);
        return priceMessage;
    }

    /*
    This method displays the given quantity value on the screen
     */
    private void displayQuantity(int numberOfCoffee){
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }

}
