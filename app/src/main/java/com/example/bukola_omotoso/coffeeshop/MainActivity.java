package com.example.bukola_omotoso.coffeeshop;

import java.text.NumberFormat;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private TextView quantityTextView;
    private Button incrementButton;
    private Button decrementButton;
    private CheckBox whippedCreamCheckBox;
    private CheckBox chocolateCheckBox;
    private TextView nameTextView;
    private EditText nameEditTextView;
    private TextView whippedCreamTextView;
    private TextView chocolateTextView;
    private TextView priceTextView;
    private LinearLayout summaryLayout;
    int cups_of_coffee = 0;
    double price_per_cup = 2.50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        quantityTextView = (TextView)findViewById(R.id.quantity_text_view);
        incrementButton = (Button)findViewById(R.id.increment_button);
        decrementButton = (Button)findViewById(R.id.decrement_button);
        nameEditTextView = (EditText) findViewById(R.id.name_edit_text);
        nameTextView = (TextView) findViewById(R.id.name_text_view);
        priceTextView = (TextView) findViewById(R.id.price_text_view);
        whippedCreamTextView = (TextView) findViewById(R.id.whipped_cream_text_view);
        chocolateTextView = (TextView) findViewById(R.id.chocolate_cream_text_view);
        whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_check_box);
        chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_check_box);
        summaryLayout = (LinearLayout)findViewById(R.id.summary_layout);


    }

    public void incrementQuantity(View view)    {
        int qty = Integer.parseInt(quantityTextView.getText().toString());
        quantityTextView.setText(Integer.toString(qty+1));
    }

    public void decrementQuantity(View view)    {
        int qty = Integer.parseInt(quantityTextView.getText().toString());
        if (qty >= 1)
            quantityTextView.setText(Integer.toString(qty-1));

    }

    public  void submitOrder(View view) {
        nameTextView.setText("Name: "+nameEditTextView.getText());
        if (whippedCreamCheckBox.isChecked())   {
            whippedCreamTextView.setText("Whipped Cream? Yes");
        }else{
            whippedCreamTextView.setText("Whipped Cream? No");
        }

        if (chocolateCheckBox.isChecked())   {
            chocolateTextView.setText("Chocolate? Yes");
        }else{
            chocolateTextView.setText("Chocolate? No");
        }

        double total_price = price_per_cup * Integer.parseInt(quantityTextView.getText().toString());
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(total_price));
        summaryLayout.setVisibility(View.VISIBLE);
    }
}
