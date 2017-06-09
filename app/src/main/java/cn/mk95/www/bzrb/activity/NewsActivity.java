package cn.mk95.www.bzrb.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import cn.mk95.www.bzrb.R;
import cn.mk95.www.bzrb.mInterface.mInterfaceImpl.IntoNewsPageImpl;
import cn.mk95.www.bzrb.model.NewsDataEntity;
import cn.mk95.www.bzrb.utils.MyUrl;

/**
 * Created by 睡意朦胧 on 2017/6/8.
 */

public class NewsActivity extends Activity{
    private IntoNewsPageImpl intoNewsPage;
    private TextView tx;
    private WebView webView;
    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_layout);
        webView=(WebView)findViewById(R.id.news2);
        layout=(LinearLayout)findViewById(R.id.NewsLayout);
        Intent intent=getIntent();
        String comment_id=intent.getStringExtra("comment_id");
        intoNewsPage=new IntoNewsPageImpl(comment_id,layout);
        intoNewsPage.start();
    }
}
