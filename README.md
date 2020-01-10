# Just-Java-Practice-coffee-ordering-app
Just Java coffee ordering app just created and added some function link increament, decrement and order button is working
We have added some important method in this project like
display method
 /*
    This method is called when plus button is clicked
     */
    public void increment(View view){
        quantity = quantity + 1;
        display(quantity);
    }
    /*
    This method is called when minus button is clicked
     */
    public void decrement(View view){
        quantity = quantity - 1;
        display(quantity);
    }
    
    /*
    This method is called when order button is clicked
     */
    public void submitOrder(View view){
        int price = quantity * 5;
        // We have learned lots about variable and String and String concatenation
        String priceMessage = "Total: $" + price;
        priceMessage = priceMessage + "\n Thank you!";  
        displayMessage(priceMessage);
        // displayPrice(quantity * 5);
    }
    
    /*
    This method displays the given quantity value on the screen
     */
    private void display(int number){
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    
    /*
    This method displays the given quantity value on the screen
     */
    private void displayPrice(int number){
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    
    /*
    This method displays the given text on the screen
     */
    private void displayMessage(String message){
        TextView priceTextView = findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }
    
