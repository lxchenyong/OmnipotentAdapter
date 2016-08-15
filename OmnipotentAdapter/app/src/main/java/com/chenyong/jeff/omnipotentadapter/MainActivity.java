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
            final List<Integer> mPos = new ArrayList<>();
            @Override
            public void convert(final CommonViewHolder holder, final Bean bean) {
                //下面是直接拿到item后赋值
//                ((TextView)(holder.getView(R.id.title_text))).setText(bean.getTitle());
//                ((TextView)(holder.getView(R.id.content_text))).setText(bean.getContent());

                //下面是在CommonViewHolder给item控件再封装了一次
                holder.setText(R.id.title_text,bean.getTitle());
                holder.setText(R.id.content_text,bean.getContent());

                //下面是解决CheckBox错位的问题
                //方法一：直接在Bean中定义一个属性纪录选中状态
                //方法二：是把的当前状态保存在一个集合List里面
                final CheckBox checkBox = holder.getView(R.id.cb);
                //方1
//                checkBox.setChecked(bean.isChecked());、

                //方2
                checkBox.setChecked(false);
                if (mPos.contains(holder.getPosition())){
                    checkBox.setChecked(true);
                }

                checkBox.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //方1
//                        bean.setChecked(checkBox.isChecked());

                        //方2
                        if (checkBox.isClickable()){
                            mPos.add(holder.getPosition());
                        }else {
                            mPos.remove((Integer) holder.getPosition());
                        }
                    }
                });
            }
        });
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            mDatas.add(new Bean("标题 "+i,"使用Linearlayout本来利用父控件的gravity属性是很好解决的。"));
        }
    }

}
