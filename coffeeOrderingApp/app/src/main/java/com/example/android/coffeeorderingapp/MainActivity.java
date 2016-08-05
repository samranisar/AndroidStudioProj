package com.example.android.coffeeorderingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=0;

    public void submitOrder(View view) {

            //displayPrice(quantity * 5);
        String priceMessage = "Total : $"+(quantity*5) +"\nThank you!";
        displayMessage(priceMessage);
    }
    private void display(int number) {

            TextView quantityTextView = (TextView) findViewById(R.id.coffee_quantity);
            quantityTextView.setText(" " + number);

    }

  /*  private void displayPrice(int number){
        TextView priceTextView= (TextView) findViewById(R.id.price_in_dollars);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/

    private void displayMessage(String message){

        TextView priceTextView= (TextView)findViewById (R.id.price_in_dollars);
        priceTextView.setText(message);
    }
    public void Increment(View view){

        quantity=quantity + 1;
        display(quantity);
    }
    public void Decrement(View view)
    {
        if(quantity>=1)
        {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */

}