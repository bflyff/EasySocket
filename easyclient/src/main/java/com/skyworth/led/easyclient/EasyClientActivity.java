package com.skyworth.led.easyclient;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.skyworth.led.easyclient.activity.BroadcasterActivity;
import com.skyworth.led.easyclient.adapter.TestCaseAdapter;
import com.skyworth.led.easyclient.bean.TestCase;

import java.util.ArrayList;
import java.util.List;

public class EasyClientActivity extends AppCompatActivity {

    private List<TestCase> testCaseList = new ArrayList<>();
    {
        testCaseList.add(new TestCase(getString(R.string.udp_broadcast_test),
                getString(R.string.udp_broadcast_test_detail),BroadcasterActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        ListView listView = findViewById(R.id.lv_test_case);
        final TestCaseAdapter adapter = new TestCaseAdapter(this);
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
