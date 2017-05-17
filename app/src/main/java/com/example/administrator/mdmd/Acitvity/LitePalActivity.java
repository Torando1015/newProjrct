package com.example.administrator.mdmd.Acitvity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.mdmd.Model.News;
import com.example.administrator.mdmd.R;

import org.litepal.tablemanager.Connector;

import java.net.HttpCookie;
import java.util.Date;

/**
 * Created by Administrator on 2017/5/11.
 */

public class LitePalActivity extends AppCompatActivity{
    TextView tvTitle;
    TextView tvContent;
    SQLiteDatabase db;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.litepal_layout);
        db = Connector.getDatabase();
        tvTitle = (TextView) findViewById(R.id.title);
        tvContent = (TextView) findViewById(R.id.content);
        Button button = (Button) findViewById(R.id.save);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatDB();
            }
        });
    }

    private void CreatDB() {
        News news = new News();
        news.setTitle("这是个标题");
        news.setContent("这是个内容");
        news.setPublishDate(new Date());
        Log.e("TAG", "news id is " + news.getId() + " db " + db.getVersion());
        news.save();
        Log.e("TAG", "news id is " + news.getId() + " db " + db.getVersion());
        if(news.save()){
            Toast.makeText(this,"存储成功",Toast.LENGTH_SHORT).show();
            tvTitle.setText(news.getTitle());
            tvContent.setText(news.getContent());
        }else {
            Toast.makeText(this,"存储失败",Toast.LENGTH_SHORT).show();
            tvTitle.setText("失败了");
            tvContent.setText("失败了");
        }
    }
}
