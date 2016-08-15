package com.chenyong.jeff.omnipotentadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;

import com.chenyong.jeff.omnipotentadapter.adapter.CommonAdapter;
import com.chenyong.jeff.omnipotentadapter.adapter.CommonViewHolder;
import com.chenyong.jeff.omnipotentadapter.bean.Bean;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Bean> mDatas = new ArrayList<>();
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initView() {
        listView = (ListView) findViewById(R.id.id_listview);
        listView.setAdapter(new CommonAdapter<Bean>(MainActivity.this,mDatas,R.layout.list_item) {
            @Override
            public void convert(final CommonViewHolder holder, final Bean bean) {
                //下面是直接拿到item后赋值
//                ((TextView)(holder.getView(R.id.title_text))).setText(bean.getTitle());
//                ((TextView)(holder.getView(R.id.content_text))).setText(bean.getContent());

                //下面是在CommonViewHolder给item控件再封装了一次
                holder.setText(R.id.title_text, bean.getTitle());
                holder.setText(R.id.content_text, bean.getContent());

            }
        });
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            mDatas.add(new Bean("标题 "+i,"使用Linearlayout本来利用父控件的gravity属性是很好解决的。"));
        }
    }

}
