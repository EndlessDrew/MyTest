package feicui.zhouqi.com.androidtest.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import feicui.zhouqi.com.androidtest.Adapter.MyAdapter;
import feicui.zhouqi.com.androidtest.Data;
import feicui.zhouqi.com.androidtest.R;

/**
 * Created by z on 2016/10/14.
 */
public class HorFragment extends Fragment {
    ListView hor_listview;
    TextView tv_hortext;
    List<Data> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hor,container,false);
        hor_listview =(ListView)view.findViewById(R.id.lv_hor_listnews);
        tv_hortext = (TextView)view.findViewById(R.id.tv_hortext);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
         list = new ArrayList<Data>();

        for (int i =0;i<10;i++){
            Data data = new Data();
            data.setNew_title("aaa"+i);
            data.setNew_content("哈哈哈哈哈"+i);
            list.add(data);
        }

        MyAdapter adapter = new MyAdapter(list,getActivity());
        hor_listview.setAdapter(adapter);
        hor_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"aaa",Toast.LENGTH_SHORT).show();
                tv_hortext.setText(list.get(position).getNew_content());

            }
        });
    }
}
