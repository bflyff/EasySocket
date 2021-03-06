package com.skyworth.led.client;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.skyworth.led.client.activity.BroadcasterActivity;
import com.skyworth.led.client.activity.HeartActivity;
import com.skyworth.led.client.adapter.TestCaseAdapter;
import com.skyworth.led.client.bean.TestCase;

import java.util.ArrayList;
import java.util.List;

public class EasyClientActivity extends AppCompatActivity {

    private List<TestCase> testCaseList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        ListView listView = findViewById(R.id.lv_test_case);
        final TestCaseAdapter adapter = new TestCaseAdapter(this);

        {
            testCaseList.add(new TestCase(getString(R.string.udp_broadcast_test),
                    getString(R.string.udp_broadcast_test_detail),BroadcasterActivity.class));
            testCaseList.add(new TestCase(getString(R.string.tcp_connect_by_broadcast),
                    getString(R.string.tcp_connect_by_broadcast_detail),BroadcasterActivity.class));
            testCaseList.add(new TestCase(getString(R.string.tcp_connect_by_qr_code),
                    getString(R.string.tcp_connect_by_qr_code_detail),BroadcasterActivity.class));
            testCaseList.add(new TestCase(getString(R.string.tcp_comm_by_heart),
                    getString(R.string.tcp_comm_by_heart_detail),HeartActivity.class));
            testCaseList.add(new TestCase(getString(R.string.tcp_comm_by_str_package),
                    getString(R.string.tcp_comm_by_str_package_detail),BroadcasterActivity.class));
            testCaseList.add(new TestCase(getString(R.string.tcp_comm_by_file_package),
                    getString(R.string.tcp_comm_by_file_package_detail),BroadcasterActivity.class));
            testCaseList.add(new TestCase(getString(R.string.tcp_comm_by_custom_package),
                    getString(R.string.tcp_comm_by_custom_package_detail),BroadcasterActivity.class));
            testCaseList.add(new TestCase(getString(R.string.tcp_comm_by_screen_share),
                    getString(R.string.tcp_comm_by_screen_share_detail),BroadcasterActivity.class));
        }


        adapter.replaceData(testCaseList);

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(EasyClientActivity.this,adapter.getItem(position).activity);
                startActivity(intent);
            }
        });
    }
}
