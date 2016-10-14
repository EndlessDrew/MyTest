package feicui.zhouqi.com.androidtest.Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import feicui.zhouqi.com.androidtest.R;

/**
 * Created by z on 2016/10/14.
 */
public class content_Fragment extends Fragment {
    TextView tv_content;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.content_fragment,container,false);
        tv_content =(TextView) view.findViewById(R.id.tv_content);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv_content.setText(getArguments().getString("content"));

    }
}
