package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Button button = (Button) findViewById(R.id.btnCalculate);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                final EditText numberText = (EditText) findViewById(R.id.edtBillAmount);
                final CheckBox checkBox = (CheckBox) findViewById(R.id.chkRound);
                final TextView txtTipResult = (TextView) findViewById(R.id.txtTipResult);

                Double number = ("".equals(numberText.getText().toString())) ?
                        0 : Double.parseDouble(numberText.getText().toString());

                number *= 0.12;
                Double result = (checkBox.isChecked()) ? Math.floor(number) : number;
                txtTipResult.setText("Tip: $" + result.toString());
            }
        });
    }
}
