package feicui.zhouqi.com.androidtest.Fragment;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import feicui.zhouqi.com.androidtest.Adapter.MyAdapter;
import feicui.zhouqi.com.androidtest.Data;
import feicui.zhouqi.com.androidtest.NewsActivity;
import feicui.zhouqi.com.androidtest.R;

/**
 * Created by z on 2016/10/14.
 */
public class VertFragment extends Fragment {
    ListView lv_newList;
     List<Data>list;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vert,container,false);
        lv_newList=(ListView) view.findViewById(R.id.lv_vert_newList);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        list = new ArrayList<Data>();
        for (int i =0;i<10;i++){
            Data data = new Data();
            data.setNew_title("aaa"+i);
            data.setNew_content("哈哈哈"+i);
            list.add(data);
        }

        MyAdapter adapter = new MyAdapter(list,getActivity());
        lv_newList.setAdapter(adapter);
        lv_newList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                FragmentManager manager = getFragmentManager();
                FragmentTransaction transaction =manager.beginTransaction();
                content_Fragment content_fragment = new content_Fragment();
                Bundle bd = new Bundle();
                bd.putString("content",list.get(position).getNew_content());
                content_fragment.setArguments(bd);
                transaction.replace(android.R.id.content,content_fragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
    }
}
