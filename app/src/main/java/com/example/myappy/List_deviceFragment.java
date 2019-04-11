package com.example.myappy;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class List_deviceFragment extends Fragment {


    ListView listView_device ;
    Button btn_add_device;
    ArrayList<Thietbi> arrayList = new ArrayList<>();
    Custom_listview adapter;
    Thietbi thietbi = new Thietbi();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_list_device, container, false);
        listView_device = (ListView) view.findViewById(R.id.list_device);
        getActivity().setTitle("Danh sách thiết bị");
        adapter = new Custom_listview(this.getActivity(), R.layout.activity_custom_listview, arrayList);
        listView_device.setAdapter(adapter);

        thietbi = new Thietbi("aaa", "bbb", "ccc", R.drawable.phong);
        arrayList.add(thietbi);
        adapter.notifyDataSetChanged();

        listView_device.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it = new Intent(getContext(), Detail_device.class);
                Bundle bundle = new Bundle();
                String ten = arrayList.get(position).getName();
                bundle.putString("ten",ten);
                it.putExtra("321",bundle);
                startActivity(it);
            }
        });
        btn_add_device = (Button) view.findViewById(R.id.add_device);
        btn_add_device.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getContext(), Add_device.class);
                startActivityForResult(it, 100);
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==100){
            switch (resultCode){
                case 111:
                    thietbi = (Thietbi)  data.getBundleExtra("dulieu").getSerializable("doituong");
                    arrayList.add(thietbi);
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    }

}
