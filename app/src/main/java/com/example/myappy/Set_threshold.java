package com.example.myappy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class Set_threshold extends AppCompatActivity {
    Button btnCaidat;
    EditText edtNhietdo1, edtNhietdo2, edtDoam1, edtDoam2, edtAmthanh1, edtAmthanh2, edtAnhsang1, edtAnhsang2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.activity_set_threshold);
        anhxa();
        caidat();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void caidat() {
        btnCaidat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Set_threshold.this, Detail_device.class);
                Bundle bundle = new Bundle();
                bundle.putString("nhietdo1", edtNhietdo1.getText().toString());
                bundle.putString("nhietdo2", edtNhietdo2.getText().toString());
                bundle.putString("doam1", edtDoam1.getText().toString() );
                bundle.putString("doam2", edtDoam2.getText().toString());
                bundle.putString("amthanh1", edtAmthanh1.getText().toString());
                bundle.putString("amthanh2", edtAmthanh2.getText().toString());
                bundle.putString("anhsang1", edtAnhsang1.getText().toString());
                bundle.putString("anhsang2", edtAnhsang2.getText().toString());
                intent.putExtra("dataYen", bundle);
                startActivity(intent);
            }
        });
    }

    private void anhxa() {
        btnCaidat   = (Button)   findViewById(R.id.btnCaidat);
        edtNhietdo1 = (EditText) findViewById(R.id.edtNhietdo1);
        edtNhietdo2 = (EditText) findViewById(R.id.edtNhietdo2);
        edtAmthanh1 = (EditText) findViewById(R.id.edtAmthanh1);
        edtAmthanh2 = (EditText) findViewById(R.id.edtAmthanh2);
        edtAnhsang1 = (EditText) findViewById(R.id.edtAnhsang1);
        edtAnhsang2 = (EditText) findViewById(R.id.edtAnhsang2);
        edtDoam2    = (EditText) findViewById(R.id.edtDoam2);
        edtDoam1    = (EditText) findViewById(R.id.edtDoam1);
    }


}
