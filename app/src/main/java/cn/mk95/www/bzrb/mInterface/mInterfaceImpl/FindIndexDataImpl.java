package cn.mk95.www.bzrb.mInterface.mInterfaceImpl;

import com.google.gson.Gson;

import java.io.IOException;

import cn.mk95.www.bzrb.mInterface.FindIndexData;
import cn.mk95.www.bzrb.model.IndexPageOneDataEntity;
import cn.mk95.www.bzrb.model.IndexPageTwoDataEntity;
import cn.mk95.www.bzrb.utils.MyUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 11149 on 2017/6/7.
 */

public class FindIndexDataImpl implements FindIndexData {

    @Override
    public void findIndexPageOndeData(String timestamp) {
        IndexPageOneDataEntity indexPageOneDataEntity = null;
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        String url=MyUrl.INDEX_URL;
        if(timestamp!=null){
            url+="?timestamp="+timestamp;
        }
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            indexPageOneDataEntity = gson.fromJson(response.body().string(), IndexPageOneDataEntity.class);
        } catch (IOException e) {

        } finally {
            if (indexPageOneDataEntity == null) {
                System.out.println("==========失败========");
            } else {
                System.out.println("===========成功=========");
                System.out.println(indexPageOneDataEntity.getData().toString()
//                        + "\n" + timestamp==null?"Top_stories null":indexPageOneDataEntity.getTop_stories().toString()
                        + "\n" + indexPageOneDataEntity.getTimestamp());
            }
            indexDataCallBack.indexPageOneData(indexPageOneDataEntity);
        }
    }

    @Override
    public void findIndexPageTwoData(String timestamp) {
        IndexPageTwoDataEntity indexPageTwoDataEntity = null;
        OkHttpClient client = new OkHttpClient();
        Gson gson = new Gson();
        String url=MyUrl.INDEX_PAGE_TWO_URL;
        if(timestamp!=null){
            url+="?timestamp="+timestamp;
            System.out.println("===============timestamp不为空");
        }
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            indexPageTwoDataEntity = gson.fromJson(response.body().string(), IndexPageTwoDataEntity.class);
        } catch (IOException e) {

        } finally {
            if (indexPageTwoDataEntity == null) {
                System.out.println("==========失败========");
            } else {
                System.out.println("===========成功=========");
                System.out.println(indexPageTwoDataEntity.getData().toString()
                        + "\n" + indexPageTwoDataEntity.getTimestamp());
            }
            indexPageTwoDataCallBack.indexPageTwoData(indexPageTwoDataEntity);
        }
    }

    IndexDataCallBack indexDataCallBack=null;
    IndexPageTwoDataCallBack indexPageTwoDataCallBack=null;

    public interface IndexDataCallBack{
        public void indexPageOneData(IndexPageOneDataEntity indexPageOneDataEntity);
    }

    public void setFindIndexPageOneListener(IndexDataCallBack indexDataCallBack,String timestamp){
        this.indexDataCallBack=indexDataCallBack;
        findIndexPageOndeData(timestamp);
    }

    public interface IndexPageTwoDataCallBack{
        public void indexPageTwoData(IndexPageTwoDataEntity indexPageTwoDataEntity);
    }

    public void setFindIndexPageTwoListener(IndexPageTwoDataCallBack indexPageTwoDataCallBack,String timestamp){
        this.indexPageTwoDataCallBack=indexPageTwoDataCallBack;
        findIndexPageTwoData(timestamp);
    }
}
