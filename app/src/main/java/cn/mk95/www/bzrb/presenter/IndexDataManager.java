package cn.mk95.www.bzrb.presenter;

import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.mk95.www.bzrb.R;
import cn.mk95.www.bzrb.mInterface.mInterfaceImpl.FindIndexDataImpl;
import cn.mk95.www.bzrb.model.IndexDocumentModel;
import cn.mk95.www.bzrb.model.IndexPageOneDataEntity;

/**
 * Created by 11149 on 2017/6/7.
 */

public class IndexDataManager {
    private ViewPager viewPager;
    //轮播图
    private RollPagerView rollPagerView;
    //首页listview
    private ListView page_one_list;
    //用户投稿listview
    private ListView page_two_list;

    private Handler myhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.arg1) {
                case 0x000001:
                    System.out.println("=========msg: 0x000001");
                    if (rollViewpagerAdapter != null)
                        rollViewpagerAdapter.notifyDataSetChanged();
                    break;
            }
        }
    };

    public IndexDataManager(ViewPager viewPager, RollPagerView rollPagerView, ListView page_one_list, ListView page_two_list) {
        this.viewPager = viewPager;
        this.rollPagerView = rollPagerView;
        this.page_one_list = page_one_list;
        this.page_two_list = page_two_list;
        init();
    }

    public IndexDataManager() {

    }

    public void LoadData() {
        IndexDataLoadThread myThread = new IndexDataLoadThread();
        myThread.start();
    }

    public class IndexDataLoadThread extends Thread {
        @Override
        public void run() {
            FindIndexDataImpl findData = new FindIndexDataImpl();
            findData.setFindIndexPageOneListener(new FindIndexDataImpl.IndexDataCallBack() {
                @Override
                public void indexPageOneData(IndexPageOneDataEntity indexPageOneDataEntity) {
                    indexPageOneData = indexPageOneDataEntity;
                }
            });
            Message msg = new Message();
            if (indexPageOneData == null) {

            } else {
                msg.arg1 = 0x000001;
                myhandler.sendMessage(msg);
            }
        }
    }

    public static IndexPageOneDataEntity indexPageOneData = null;
    private RollViewpagerAdapter rollViewpagerAdapter = null;

    private void init() {
        rollViewpagerAdapter = new RollViewpagerAdapter();
        rollPagerView.setPlayDelay(3000);//*播放间隔
        rollPagerView.setAnimationDurtion(500);//透明度
        rollPagerView.setAdapter(rollViewpagerAdapter);//配置适配器
        page_one_list.setAdapter(new IndexPageOneAdapter());
    }

    //首页page1的ListView适配器
    public class IndexPageOneAdapter extends BaseAdapter{

        public List<IndexDocumentModel> indexDocumentModel = indexPageOneData == null ? null : indexPageOneData.getData();
        @Override
        public int getCount() {
            return indexDocumentModel == null ? 0 : indexDocumentModel.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(indexDocumentModel==null){
                return null;
            }
            //查找布局文件
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View item=inflater.inflate(R.layout.index_page_one_list_item,null);
            ImageView image=(ImageView)item.findViewById(R.id.image);
            TextView hit_count=(TextView)item.findViewById(R.id.hit_count);
            TextView title=(TextView)item.findViewById(R.id.title);
            TextView author_name=(TextView)item.findViewById(R.id.author_name);
            TextView section_name=(TextView)item.findViewById(R.id.section_name);
            Picasso.with(parent.getContext())
                    .load(indexDocumentModel.get(position).getImage())
                    .into(image);
            hit_count.setText(indexDocumentModel.get(position).getHit_count_string());
            title.setText(indexDocumentModel.get(position).getTitle());
            author_name.setText(indexDocumentModel.get(position).getAuthor_name());
            section_name.setText(indexDocumentModel.get(position).getSection_name());

            return item;
        }
    }

    //轮播图适配器
    private class RollViewpagerAdapter extends StaticPagerAdapter {

        int flag = 0;
        public List<IndexDocumentModel> indexDocumentModel = indexPageOneData == null ? null : indexPageOneData.getTop_stories();

        @Override
        public View getView(ViewGroup container, int position) {
            if (indexDocumentModel == null) {
                return null;
            }

            ImageView imageView = new ImageView(container.getContext());
            TextView textView = new TextView(container.getContext());

            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            Picasso.with(container.getContext())
                    .load(indexDocumentModel.get(position).getImage())
                    .into(imageView);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setLayoutParams(layoutParams);

            LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
            layoutParams1.setMargins(5,5,5,23);
            textView.setText(indexDocumentModel.get(position).getTitle());
            textView.setLayoutParams(layoutParams1);
            textView.setTextColor(Color.WHITE);
            textView.setGravity(Gravity.BOTTOM);
            textView.setTextSize(20);

            FrameLayout frameLayout = new FrameLayout(container.getContext());
            frameLayout.addView(imageView);
            frameLayout.addView(textView);
            return frameLayout;
        }

        @Override
        public int getCount() {
            return indexDocumentModel == null ? 0 : indexDocumentModel.size();
        }
    }
}
