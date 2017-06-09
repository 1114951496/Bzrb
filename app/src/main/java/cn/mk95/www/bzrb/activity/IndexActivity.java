package cn.mk95.www.bzrb.activity;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;

import cn.mk95.www.bzrb.R;
import cn.mk95.www.bzrb.presenter.IndexDataManager;
import cn.mk95.www.bzrb.ui.DropDownListView;

public class IndexActivity extends Activity implements View.OnClickListener {

    private ViewPager viewPager;
    private ArrayList<View> pageView=new ArrayList<>();
    //首页
    private TextView page_1;
    //用户投稿
    private TextView page_2;
    //滚动条图片
    private ImageView scrollbar;
    //滚动条初始偏移量
    private  int offset=0;
    //当前页编号
    private  int currIndex=0;
    //滚动条宽度
    private int bmpW;
    //已被滚动量
    private int one;
    //轮播图
    private RollPagerView rollPagerView;
    //首页listview
    private DropDownListView page_one_list;
    //用户投稿listview
    private DropDownListView page_two_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        init();
    }

    public void init(){
        //查找布局文件
        LayoutInflater inflater=getLayoutInflater();
        View view1=inflater.inflate(R.layout.index_viewpages_1,null);
        View view2=inflater.inflate(R.layout.index_viewpages_2,null);

        viewPager=(ViewPager)findViewById(R.id.viewPager);
        page_1=(TextView)findViewById(R.id.index_nav_1);
        page_2=(TextView)findViewById(R.id.index_nav_2);
        scrollbar=(ImageView)findViewById(R.id.scrollbar);
        page_1.setOnClickListener(this);
        page_2.setOnClickListener(this);
        //添加需要切换的界面
        pageView.add(view1);
        pageView.add(view2);

        PagerAdapter pagerAdapter = new PagerAdapter(){

            int flag=0;
            @Override
            //获取当前窗体界面数
            public int getCount() {
                return pageView.size();
            }

            @Override
            //判断是否由对象生成界面
            public boolean isViewFromObject(View arg0, Object arg1) {
                return arg0==arg1;
            }
            //使从ViewGroup中移出当前View
            public void destroyItem(View arg0, int arg1, Object arg2) {
                ((ViewPager) arg0).removeView(pageView.get(arg1));
            }

            //返回一个对象，这个对象表明了PagerAdapter适配器选择哪个对象放在当前的ViewPager中
            public Object instantiateItem(View arg0, int arg1){
                ((ViewPager)arg0).addView(pageView.get(arg1));
                return pageView.get(arg1);
            }
            @Override
            public void notifyDataSetChanged() {
                System.out.println("===========notifyDataSetChanged");
                flag=getCount()+1;
                super.notifyDataSetChanged();
            }

            @Override
            public int getItemPosition(Object object) {
                System.out.println("===========getItemPosition");
                if(flag>0){
                    flag=0;
                    return POSITION_NONE;
                }
                return super.getItemPosition(object);
            }
        };

        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(new MyOnPageChangeListener());

        // 获取滚动条的宽度
        bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.scrollbar).getWidth();
        //为了获取屏幕宽度，新建一个DisplayMetrics对象
        DisplayMetrics displayMetrics = new DisplayMetrics();
        //将当前窗口的一些信息放在DisplayMetrics类中
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        //得到屏幕的宽度
        int screenW = displayMetrics.widthPixels;
        //计算出滚动条初始的偏移量
        offset = (screenW / 2 - bmpW) / 2;
        //计算出切换一个界面时，滚动条的位移量
        one = offset * 2 + bmpW;
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        //将滚动条的初始位置设置成与左边界间隔一个offset
        scrollbar.setImageMatrix(matrix);

        page_one_list=(DropDownListView)view1.findViewById(R.id.index_page1_listview);
        page_two_list=(DropDownListView)view2.findViewById(R.id.index_page2_listview);
        //首页轮播图
        rollPagerView=(RollPagerView)view1.findViewById(R.id.rollViewpager);
        IndexDataManager indexDataManager=new IndexDataManager(viewPager,rollPagerView,page_one_list,page_two_list);
        //indexDataManager.init();
    }

    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageSelected(int arg0) {
            Animation animation = null;
            switch (arg0) {
                case 0:
                    /**
                     * TranslateAnimation的四个属性分别为
                     * float fromXDelta 动画开始的点离当前View X坐标上的差值
                     * float toXDelta 动画结束的点离当前View X坐标上的差值
                     * float fromYDelta 动画开始的点离当前View Y坐标上的差值
                     * float toYDelta 动画开始的点离当前View Y坐标上的差值
                     **/
                    animation = new TranslateAnimation(one, 0, 0, 0);
                    break;
                case 1:
                    animation = new TranslateAnimation(offset, one, 0, 0);
                    break;
            }
            //arg0为切换到的页的编码
            currIndex = arg0;
            // 将此属性设置为true可以使得图片停在动画结束时的位置
            animation.setFillAfter(true);
            //动画持续时间，单位为毫秒
            animation.setDuration(200);
            //滚动条开始动画
            scrollbar.startAnimation(animation);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }




    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.index_nav_1:
                //点击"首页“时切换到第一页
                viewPager.setCurrentItem(0);
                break;
            case R.id.index_nav_2:
                //点击“用户投稿”时切换到第二页
                viewPager.setCurrentItem(1);
                break;
        }
    }

    //该方法用于测试pageview的第一页（首页）
    public void indexPageOneListClick(){

    }

    //该方法用于测试pageview的第二页（用户投稿）
    public void indexPageTwoListClick(){

    }
}
