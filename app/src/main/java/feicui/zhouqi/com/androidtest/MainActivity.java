package feicui.zhouqi.com.androidtest;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.ListView;


import feicui.zhouqi.com.androidtest.Fragment.HorFragment;
import feicui.zhouqi.com.androidtest.Fragment.VertFragment;

public class MainActivity extends Activity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int windowHeight = this.getResources().getDisplayMetrics().heightPixels; //获取当前屏幕的高
        int windowWidth = this.getResources().getDisplayMetrics().widthPixels; //获取当前屏幕的宽

        HorFragment horFragment = new HorFragment();
        VertFragment vertFragment = new VertFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if(windowWidth > windowHeight){          //横屏
            ft.replace(android.R.id.content, horFragment,"hor"); //是横屏的时候显示f1的布局

        }else {
            ft.replace(android.R.id.content, vertFragment,"ver"); //显示f2 中的布局

        }
        ft.commit();
    }
}

