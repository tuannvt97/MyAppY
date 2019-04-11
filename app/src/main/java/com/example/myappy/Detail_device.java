package com.example.myappy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Detail_device extends AppCompatActivity {

    Button btnCaidatnguong;
    TextView twTenthietbi, twNhietdo1, twNhietdo2, twDoam1, twDoam2, twAmthanh1, twAmthanh2, twAnhsang1, twAnhsang2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_device);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        anhxa();
        caidatnguong();
        nhandata();
        nhandatalistdevice();
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

    private void nhandatalistdevice() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("321");
        if (bundle != null) {
            String ten = bundle.getString("ten");
            twTenthietbi.setText(ten);
        }
    }

    private void caidatnguong() {
        btnCaidatnguong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Detail_device.this, Set_threshold.class);
                startActivity(it);
            }
        });
    }

    private void nhandata() {
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("dataYen");
        if (bundle != null) {
            twNhietdo1.setText(bundle.getString("nhietdo1"));
            twNhietdo2.setText(bundle.getString("nhietdo2"));
            twDoam1.setText(bundle.getString("doam1"));
            twDoam2.setText(bundle.getString("doam2"));
            twAmthanh1.setText(bundle.getString("amthanh1"));
            twAmthanh2.setText(bundle.getString("amthanh1"));
            twAnhsang1.setText(bundle.getString("anhsang1"));
            twAnhsang2.setText(bundle.getString("anhsang2"));
        } else Toast.makeText(this, "goi du lieu rong", Toast.LENGTH_SHORT);

    }


    private void anhxa() {
        btnCaidatnguong = (Button) findViewById(R.id.btnCaidatnguong);
        twNhietdo1 = (TextView) findViewById(R.id.twNhietdo1);
        twNhietdo2 = (TextView) findViewById(R.id.twNhietdo2);
        twAmthanh1 = (TextView) findViewById(R.id.twAmthanh1);
        twAmthanh2 = (TextView) findViewById(R.id.twAmthanh2);
        twAnhsang1 = (TextView) findViewById(R.id.twAnhsang1);
        twAnhsang2 = (TextView) findViewById(R.id.twAnhsang2);
        twDoam1 = (TextView) findViewById(R.id.twDoam1);
        twDoam2 = (TextView) findViewById(R.id.twDoam2);
        twTenthietbi = (TextView) findViewById(R.id.twTenthietbichitiet);
    }
}