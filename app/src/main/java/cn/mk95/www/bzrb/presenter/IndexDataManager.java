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
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.mk95.www.bzrb.R;
import cn.mk95.www.bzrb.mInterface.mInterfaceImpl.FindIndexDataImpl;
import cn.mk95.www.bzrb.model.IndexDocumentModel;
import cn.mk95.www.bzrb.model.IndexPageOneDataEntity;
import cn.mk95.www.bzrb.model.IndexPageTwoDataEntity;
import cn.mk95.www.bzrb.model.IndexPageTwoModel;
import cn.mk95.www.bzrb.ui.DropDownListView;

/**
 * Created by 11149 on 2017/6/7.
 */

public class IndexDataManager {
    private ViewPager viewPager;
    //轮播图
    private RollPagerView rollPagerView;
    //首页listview
    private DropDownListView page_one_list;
    //用户投稿listview
    private DropDownListView page_two_list;

    private Handler myhandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.arg1) {
                case 0x000001:
                    System.out.println("=========msg: 0x000001");
                    if (rollViewpagerAdapter != null){
                        rollViewpagerAdapter.notifyDataSetChanged();
                        indexPageOneListAdapter.notifyDataSetChanged();
                        page_one_list.onDropDownComplete();
                        page_one_list.onBottomComplete();
                    }
                    break;
                case 0x000002:
                    System.out.println("=========msg: 0x000002");
                    if (indexPageTwoListAdapter != null) {
                        indexPageTwoListAdapter.notifyDataSetChanged();
                        page_two_list.onDropDownComplete();
                        page_two_list.onBottomComplete();
                    }
                    break;
                case 0x000003:
                    System.out.println("-------------->>>>>获取数据失败<<<<<---------");
                    break;
            }
        }
    };

    public IndexDataManager(ViewPager viewPager, RollPagerView rollPagerView, DropDownListView page_one_list, DropDownListView page_two_list) {
        this.viewPager = viewPager;
        this.rollPagerView = rollPagerView;
        this.page_one_list = page_one_list;
        this.page_two_list = page_two_list;
        init();
    }

    public IndexDataManager() {

    }

    IndexDataLoadThread myThread1 = new IndexDataLoadThread();
    IndexPageTwoDataLoadThread myThread2 = new IndexPageTwoDataLoadThread();

    public void LoadData() {
//        IndexDataLoadThread myThread1 = new IndexDataLoadThread();
//        IndexPageTwoDataLoadThread myThread2 = new IndexPageTwoDataLoadThread();
        myThread1.start();
        myThread2.start();
    }

    public class IndexDataLoadThread extends Thread {
        @Override
        public void run() {
            FindIndexDataImpl findData = new FindIndexDataImpl();
            String time=null;
            if(indexPageOneData!=null){
                time=indexPageOneData.getTimestamp();
            }
            findData.setFindIndexPageOneListener(new FindIndexDataImpl.IndexDataCallBack() {
                @Override
                public void indexPageOneData(IndexPageOneDataEntity indexPageOneDataEntity) {
                    Message msg = new Message();
                    if (indexPageOneDataEntity == null) {
                        msg.arg1 = 0x000003;
                        myhandler.sendMessage(msg);
                    } else {
                        if (indexPageOneData == null) {
                            indexPageOneData = indexPageOneDataEntity;
                        } else {
                            if(indexPageOneData.getTimestamp()!=null){
                                for (IndexDocumentModel e : indexPageOneDataEntity.getData()) {
                                    indexPageOneData.getData().add(e);
                                }
                            }else{
                                indexPageOneData.getTop_stories().removeAll(indexPageOneData.getTop_stories());
                                for (IndexDocumentModel e : indexPageOneDataEntity.getTop_stories()) {
                                    indexPageOneData.getTop_stories().add(e);
                                }
                                indexPageOneData.getData().removeAll(indexPageOneData.getData());
                                for (IndexDocumentModel e : indexPageOneDataEntity.getData()) {
                                    indexPageOneData.getData().add(e);
                                }
                            }
                            indexPageOneData.setTimestamp(indexPageOneDataEntity.getTimestamp());
                        }
                        msg.arg1 = 0x000001;
                        myhandler.sendMessage(msg);
                    }
                }
            }, time);
        }
    }

    public class IndexPageTwoDataLoadThread extends Thread {
        @Override
        public void run() {
            FindIndexDataImpl findData = new FindIndexDataImpl();
            String time=null;
            if(indexPageTwoData!=null){
                time=indexPageTwoData.getTimestamp();
            }
            findData.setFindIndexPageTwoListener(new FindIndexDataImpl.IndexPageTwoDataCallBack() {
                @Override
                public void indexPageTwoData(IndexPageTwoDataEntity indexPageTwoDataEntity) {
                    Message msg = new Message();
                    if (indexPageTwoDataEntity == null) {
                        msg.arg1 = 0x000003;
                        myhandler.sendMessage(msg);
                    } else {
                        if (indexPageTwoData == null) {
                            indexPageTwoData = indexPageTwoDataEntity;
                        } else {
                            if(indexPageTwoData.getTimestamp()!=null){
                                for (IndexPageTwoModel e : indexPageTwoDataEntity.getData()) {
                                    indexPageTwoData.getData().add(e);
                                }
                            }else{
                                indexPageTwoData.getData().removeAll(indexPageTwoData.getData());
                                for (IndexPageTwoModel e : indexPageTwoDataEntity.getData()) {
                                    indexPageTwoData.getData().add(e);
                                }
                            }
                            indexPageTwoData.setTimestamp(indexPageTwoDataEntity.getTimestamp());
                        }
                        msg.arg1 = 0x000002;
                        myhandler.sendMessage(msg);
                    }
                }
            }, time);
        }
    }

    public static IndexPageOneDataEntity indexPageOneData = null;
    public static IndexPageTwoDataEntity indexPageTwoData = null;
    private RollViewpagerAdapter rollViewpagerAdapter = null;

    private void init() {
        rollViewpagerAdapter = new RollViewpagerAdapter();
        indexPageOneListAdapter = new IndexPageOneAdapter();
        indexPageTwoListAdapter = new IndexPageTwoAdapter();
        rollPagerView.setPlayDelay(3000);//*播放间隔
        rollPagerView.setAnimationDurtion(500);//透明度
        rollPagerView.setAdapter(rollViewpagerAdapter);//配置适配器
        page_one_list.setAdapter(indexPageOneListAdapter);
        page_two_list.setAdapter(indexPageTwoListAdapter);

        page_one_list.setOnDropDownListener(new DropDownListView.OnDropDownListener() {
            @Override
            public void onDropDown() {
                indexPageOneData.setTimestamp(null);
                myThread1.start();
            }
        });
        page_one_list.setOnBottomListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myThread1.start();
            }
        });

        page_two_list.setOnDropDownListener(new DropDownListView.OnDropDownListener() {
            @Override
            public void onDropDown() {
                indexPageTwoData.setTimestamp(null);
                myThread2.start();
            }
        });
        page_two_list.setOnBottomListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myThread2.start();
            }
        });
    }

    private IndexPageOneAdapter indexPageOneListAdapter = null;
    private IndexPageTwoAdapter indexPageTwoListAdapter = null;

    //首页page1的ListView适配器
    public class IndexPageOneAdapter extends BaseAdapter {

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
            if (indexDocumentModel == null) {
                return null;
            }
            //查找布局文件
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View item = inflater.inflate(R.layout.index_page_one_list_item, null);
            ImageView image = (ImageView) item.findViewById(R.id.image);
            TextView hit_count = (TextView) item.findViewById(R.id.hit_count);
            TextView title = (TextView) item.findViewById(R.id.title);
            TextView author_name = (TextView) item.findViewById(R.id.author_name);
            TextView section_name = (TextView) item.findViewById(R.id.section_name);
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

    //首页page2的ListView适配器
    public class IndexPageTwoAdapter extends BaseAdapter {

        public List<IndexPageTwoModel> IndexPageTwoModel = indexPageTwoData == null ? null : indexPageTwoData.getData();

        @Override
        public int getCount() {
            return IndexPageTwoModel == null ? 0 : IndexPageTwoModel.size();
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
            if (IndexPageTwoModel == null) {
                return null;
            }
            //查找布局文件
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View item = inflater.inflate(R.layout.index_page_one_list_item, null);
            ImageView image = (ImageView) item.findViewById(R.id.image);
            TextView hit_count = (TextView) item.findViewById(R.id.hit_count);
            TextView title = (TextView) item.findViewById(R.id.title);
            TextView author_name = (TextView) item.findViewById(R.id.author_name);
            TextView center = (TextView) item.findViewById(R.id.center);
            Picasso.with(parent.getContext())
                    .load(IndexPageTwoModel.get(position).getAuthor_avatar())
                    .into(image);
            hit_count.setText(IndexPageTwoModel.get(position).getHit_count_string());
            title.setText(IndexPageTwoModel.get(position).getTitle());
            author_name.setText(IndexPageTwoModel.get(position).getAuthor_name());
            center.setText("");

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
            layoutParams1.setMargins(5, 5, 5, 23);
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
