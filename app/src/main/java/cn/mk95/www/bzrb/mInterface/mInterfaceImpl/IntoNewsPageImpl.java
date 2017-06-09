package cn.mk95.www.bzrb.mInterface.mInterfaceImpl;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Html;
import android.text.Layout;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import cn.mk95.www.bzrb.R;
import cn.mk95.www.bzrb.activity.NewsActivity;
import cn.mk95.www.bzrb.mInterface.IntoNewsPage;
import cn.mk95.www.bzrb.model.CommentsEntity;
import cn.mk95.www.bzrb.model.IndexPageOneDataEntity;
import cn.mk95.www.bzrb.model.NewsDataEntity;
import cn.mk95.www.bzrb.utils.MyUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 睡意朦胧 on 2017/6/8.
 */

public class IntoNewsPageImpl extends Thread implements IntoNewsPage {
    public String comment_id;
    public NewsDataEntity newsDataEntity;
    public WebView webView;
    public LinearLayout layout;
    public TextView commment_count;
    public TextView hit_count;
    public CommentsEntity comments;
    public IntoNewsPageImpl(String comment_id,LinearLayout layout){
        this.comment_id=comment_id;
        this.layout=layout;
    }

    public Handler nhandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            webView=(WebView)layout.findViewById(R.id.news2);
            commment_count=(TextView)layout.findViewById(R.id.comment_count);
            hit_count=(TextView)layout.findViewById(R.id.hit_count);
            if(msg.what==0x123){
                NewsDataEntity hNewsData = (NewsDataEntity) msg.obj;
                webView.getSettings().setDefaultTextEncodingName("UTF-8");
                webView.loadData(hNewsData.getHead()+hNewsData.getBody(), "text/html; charset=UTF-8", null);
                commment_count.setText(hNewsData.getComment_count());
                hit_count.setText(hNewsData.getHit_count());
            }
            if (msg.what==0x456){
                CommentsEntity commentsEntity=(CommentsEntity)msg.obj;
                System.out.print("sdsdsdsdsdsdsdsdsdsdsdssdds"+commentsEntity.getLatest());

            }
        }

    };
    @Override
    public void findNewsDate(int commentt_id) {
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        newsDataEntity = null;
        Request request = new Request.Builder()
                .url(MyUrl.IT_url+String.valueOf(comment_id))
                .build();
        Request request1=new Request.Builder()
                .url(MyUrl.IT_url+String.valueOf(comment_id)+"comments")
                .build();

        try {
            Response response = client.newCall(request).execute();
            newsDataEntity = gson.fromJson(response.body().string(), NewsDataEntity.class);
        } catch (IOException e) {

        } finally {
            if (newsDataEntity == null) {
                System.out.println("失败");
            } else {
                Message msg=new Message();
                msg.what = 0x123;
                msg.obj=newsDataEntity;
                nhandler.sendMessage(msg);
            }
        }
        try {
            Response response1=client.newCall(request1).execute();
            comments=gson.fromJson(response1.body().string(),CommentsEntity.class);
        }catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (comments==null){
                System.out.println("失败");
            }else {
                Message message=new Message();
                message.what=0x456;
                message.obj=comments;
                nhandler.sendMessage(message);
            }
        }

    }

    @Override
    public void run(){
        Looper.prepare();
        findNewsDate(Integer.parseInt(comment_id));
        Looper.loop();
    }

}
