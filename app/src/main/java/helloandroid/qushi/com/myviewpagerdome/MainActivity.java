package helloandroid.qushi.com.myviewpagerdome;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
//import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    private TextView tv_item_one;
    private TextView tv_item_two;
    private TextView tv_item_three;
    private ViewPager myViewPager;
    private List<Fragment> list;
    private TabFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InitView();

// 设置菜单栏的点击事件
        tv_item_one.setOnClickListener(this);
        tv_item_two.setOnClickListener(this);
        tv_item_three.setOnClickListener(this);
        myViewPager.addOnPageChangeListener(new MyPagerChangeListener());

//把Fragment添加到List集合里面
        list = new ArrayList<>();
        list.add(new OneFragment());
        list.add(new TwoFragment());
        list.add(new ThreeFragment());

        adapter = new TabFragmentPagerAdapter(getSupportFragmentManager(), list);
        myViewPager.setAdapter(adapter);
        myViewPager.setCurrentItem(0);  //初始化显示第一个页面
        tv_item_one.setBackgroundColor(Color.RED);//被选中就为红色
    }

    private void InitView() {
        tv_item_one = (TextView) findViewById(R.id.tv_itme_one);
        tv_item_two = (TextView) findViewById(R.id.tv_itme_two);
        tv_item_three = (TextView) findViewById(R.id.tv_itme_Three);
        myViewPager = (ViewPager) findViewById(R.id.myViewPager);
    }

    /**
     * 点击事件
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_itme_one:
                myViewPager.setCurrentItem(0);
                tv_item_one.setBackgroundColor(Color.RED);
                tv_item_two.setBackgroundColor(Color.WHITE);
                tv_item_three.setBackgroundColor(Color.WHITE);
                break;
            case R.id.tv_itme_two:
                myViewPager.setCurrentItem(1);
                tv_item_one.setBackgroundColor(Color.WHITE);
                tv_item_two.setBackgroundColor(Color.RED);
                tv_item_three.setBackgroundColor(Color.WHITE);
                break;
            case R.id.tv_itme_Three:
                myViewPager.setCurrentItem(2);
                tv_item_one.setBackgroundColor(Color.WHITE);
                tv_item_two.setBackgroundColor(Color.WHITE);
                tv_item_three.setBackgroundColor(Color.RED);
                break;
        }
    }


    /**
     * 设置一个ViewPager的侦听事件，当左右滑动ViewPager时菜单栏被选中状态跟着改变
     */
    public class MyPagerChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            switch (arg0) {
                case 0:
                    tv_item_one.setBackgroundColor(Color.RED);
                    tv_item_two.setBackgroundColor(Color.WHITE);
                    tv_item_three.setBackgroundColor(Color.WHITE);
                    break;
                case 1:
                    tv_item_one.setBackgroundColor(Color.WHITE);
                    tv_item_two.setBackgroundColor(Color.RED);
                    tv_item_three.setBackgroundColor(Color.WHITE);
                    break;
                case 2:
                    tv_item_one.setBackgroundColor(Color.WHITE);
                    tv_item_two.setBackgroundColor(Color.WHITE);
                    tv_item_three.setBackgroundColor(Color.RED);
                    break;
            }
        }
    }

}