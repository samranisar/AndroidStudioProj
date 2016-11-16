package com.example.android.enhancedcoffeeorderingapp;

import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int quantity=0;
    String Topping;

    public void submitOrder(View view) {

        EditText name=(EditText)findViewById(R.id.Name);
        String n_ame=name.getText().toString();

        CheckBox whippedCream = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean hasWhippedCream = whippedCream.isChecked();

        CheckBox chocolate =(CheckBox) findViewById(R.id.Chocolate_checkbox);
        boolean hasChocolate = chocolate.isChecked();

        int price = calculatePrice(hasWhippedCream,hasChocolate);

        if(hasWhippedCream && hasChocolate) {

            Topping=getString(R.string.whip_choc);
        }
        else if(hasWhippedCream){

            Topping=getString(R.string.whipped_Cream);
        }
        else if(hasChocolate){

            Topping=getString(R.string.Chocolate);
        }
        else {
            Topping = getString(R.string.no_topping);
        }

        String priceMessage= createOrderSummary(n_ame,price,Topping);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.coffee_order)+" "+ n_ame);
        intent.putExtra(Intent.EXTRA_TEXT,priceMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private int calculatePrice(boolean hasWhippedCream,boolean hasChocolate)
    {
        int basePrice = 5;
        if(hasWhippedCream)
            basePrice += 1;
        if(hasChocolate)
            basePrice += 2;

        return quantity*basePrice;
    }

    private String createOrderSummary(String n_ame,int price,String Topping)
    {
        String priceMessage=getString(R.string.order_summary_name)+ n_ame +"\n"+getString(R.string.order_summary_quantity)+ quantity+"\n" +Topping+"\n"+ getString(R.string.order_summary_total)+price+"\n"+getString(R.string._thankyou);
        return priceMessage;
    }

    private void displayQuantity(int number) {

        TextView quantityTextView = (TextView) findViewById(R.id.coffee_quantity);
        quantityTextView.setText(" "+ number);

    }

    public void Increment(View view) {

        if (quantity ==100) {

            Toast.makeText(MainActivity.this, R.string.toast_inc,Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity + 1;
            displayQuantity(quantity);

    }
    public void Decrement(View view)
    {
        if (quantity==1)
        {
            Toast.makeText(MainActivity.this, R.string.toast_dec,Toast.LENGTH_SHORT).show();
            return ;
           // Toast.makeText(MainActivity.this,"You cannot order less than 1 coffee",Toast.LENGTH_SHORT).show();
        }
        quantity = quantity - 1;
        displayQuantity(quantity);

    }

}
