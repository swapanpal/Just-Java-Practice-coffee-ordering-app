package com.example.justjavapractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;
/*
This app displays an order form to order coffee
 */

public class MainActivity extends AppCompatActivity {
    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
    This method is called when plus button is clicked
     */
    public void increment(View view){
        quantity = quantity + 1;
        displayQuantity(quantity);
    }
    /*
    This method is called when minus button is clicked
     */
    public void decrement(View view){
        quantity = quantity - 1;
        displayQuantity(quantity);
    }
    /*
    This method is called when order button is clicked
     */
    public void submitOrder(View view){
        int price = calculatePrice();
        // String priceMessage = createOrderSummary(price);
        displayMessage(createOrderSummary(price));
    }
    /**
     * Calculates the price of the order.
     *
     * @quantity is the number of cups of coffee ordered
     * @return total price.
     */
    private int calculatePrice() {
        return quantity * 5;

    }

    /**
     * create summary of the order.
     * @param price of the order
     * @return text summary.
     */
    private String createOrderSummary(int price){
        String priceMessage = "Name: Swapan Paul";
        priceMessage += "\n Quantity: " + quantity;
        priceMessage += "\n Total: $" + price;
        priceMessage += "\n Thank you!";
        return priceMessage;
    }

    /*
    This method displays the given quantity value on the screen
     */
    private void displayQuantity(int numberOfCoffee){
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffee);
    }

    /*
    This method displays the given text on the screen
     */
    private void displayMessage(String message){
        TextView orderSummaryTextView = findViewById(R.id.order_summary_text_view);
        TextView orderSummar = findViewById(R.id.order_summary_text_view);
        orderSummar.setText(message);

    }
}
