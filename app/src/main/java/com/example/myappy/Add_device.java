package com.example.myappy;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_device extends AppCompatActivity {
    EditText edtTenthietbi, edtMathietbi, edtMatkhauthietbi;
    Button btnQuetthietbi, btnThemthietbi;
    private Uri fileUri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_device);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        anhxa();
        btnThemthietbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(Add_device.this, List_deviceFragment.class);
                Bundle bundle = new Bundle();
                Thietbi thietbi= new Thietbi();
                String name =  edtTenthietbi.getText().toString();
                String ma =  edtMathietbi.getText().toString();
                String pw = edtMatkhauthietbi.getText().toString();
                int hinh = R.drawable.wifimodem;
                thietbi = new Thietbi(name, ma, pw, hinh);
                if(name.equals("") || ma.equals("") || pw.equals("")){
                    Toast.makeText(Add_device.this, "Bạn nhập chưa đủ thông tin", Toast.LENGTH_SHORT).show();
                }
                bundle.putSerializable("doituong",thietbi);
                it.putExtra("dulieu",bundle);
                setResult(111,it);
                finish();
            }
        });
        btnQuetthietbi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getApplicationContext().getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
                    startActivityForResult(intent, 100);
                }
                else Toast.makeText(Add_device.this, "Camera không được hỗ trợ", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void anhxa() {
        edtTenthietbi     = (EditText) findViewById(R.id.edtAddTenthietbi);
        edtMathietbi      = (EditText) findViewById(R.id.edtAddMathietbi);
        edtMatkhauthietbi = (EditText) findViewById(R.id.edtAddMkthietbi);
        btnQuetthietbi    = (Button)   findViewById(R.id.btnQuetthietbi);
        btnThemthietbi    = (Button)   findViewById(R.id.btnAdd);
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

}
