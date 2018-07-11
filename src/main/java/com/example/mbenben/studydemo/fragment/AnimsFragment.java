package com.example.mbenben.studydemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mbenben.studydemo.App;
import com.example.mbenben.studydemo.R;
import com.example.mbenben.studydemo.anim.AnimatorActivity;
import com.example.mbenben.studydemo.anim.ValueAnimActivity;
import com.example.mbenben.studydemo.anim.camera.CameraAnimActivity;
import com.example.mbenben.studydemo.anim.circularanim.CircleAnimActivity;
import com.example.mbenben.studydemo.anim.lodinganim.LoadingAnimActivity;
import com.example.mbenben.studydemo.anim.path.RightMarkActivity;
import com.example.mbenben.studydemo.anim.swipbackhelper.activity.SwipeBackActivity;
import com.example.mbenben.studydemo.anim.voiceAnim.VoiceAnimActivity;
import com.example.mbenben.studydemo.base.CommonAdapter;
import com.example.mbenben.studydemo.base.OnItemClickListener;
import com.example.mbenben.studydemo.base.ViewHolder;
import com.example.mbenben.studydemo.db.SearchBean;
import com.example.mbenben.studydemo.db.SearchDBManager;
import com.example.mbenben.studydemo.model.HashSetSearchBean;
import com.example.mbenben.studydemo.view.pathview.PathViewActivity;
import com.example.mbenben.studydemo.view.pathview.svgpath.SVGPathActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MDove on 2017/1/17.
 */

public class AnimsFragment extends Fragment {
    @BindView(R.id.rlv_main)
    RecyclerView rlvMain;
    @BindView(R.id.tv_desc)
    TextView tvDesc;

    private static final String KEY = "anims";
    private List<String> datas;
    private Map<String, String> mapTitle;
    private SearchDBManager manager;

    private CommonAdapter<String> adapter;

    public static AnimsFragment newInstance(String desc) {

        Bundle args = new Bundle();
        args.putString(KEY, desc);
        AnimsFragment fragment = new AnimsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main_layout, container, false);
        manager = new SearchDBManager();
        initView(view);
        initRlv();
//        addDB();
        return view;
    }

    private void initRlv() {
        adapter = new CommonAdapter<String>(App.getInstance().getContext(), R.layout.item_info, datas) {
            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.id_info, mapTitle.get(s));
            }
        };
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(ViewGroup parent, View view, Object o, int position) {
                switch (o.toString()) {
                    case "PathViewActivity":
                        Intent intentNav = new Intent(getActivity(), PathViewActivity.class);
                        startActivity(intentNav);
                        break;
                    case "ValueAnimActivity":
                        Intent intentView = new Intent(getActivity(), ValueAnimActivity.class);
                        startActivity(intentView);
                        break;
                    case "SVGPathActivity":
                        Intent intentNestedScroll = new Intent(getActivity(), SVGPathActivity.class);
                        startActivity(intentNestedScroll);
                        break;
                    case "CircleAnimActivity":
                        Intent intentCircleAnim = new Intent(getActivity(), CircleAnimActivity.class);
                        startActivity(intentCircleAnim);
                        break;
                    case "SwipeBackActivity":
                        Intent intentSwipeBack = new Intent(getActivity(), SwipeBackActivity.class);
                        startActivity(intentSwipeBack);
                        break;
                    case "LoadingAnimActivity":
                        Intent intentLoadingAnim = new Intent(getActivity(), LoadingAnimActivity.class);
                        startActivity(intentLoadingAnim);
                        break;
                    case "CameraAnimActivity":
                        Intent intentCameraAnim = new Intent(getActivity(), CameraAnimActivity.class);
                        startActivity(intentCameraAnim);
                        break;
                    case "AnimatorActivity":
                        Intent intentAnimator = new Intent(getActivity(), AnimatorActivity.class);
                        startActivity(intentAnimator);
                        break;
                    case "RightMarkActivity":
                        Intent intentRightMark = new Intent(getActivity(), RightMarkActivity.class);
                        startActivity(intentRightMark);
                        break;
                    case "VoiceAnimActivity": {
                        VoiceAnimActivity.start(getActivity(), "声波规律缩放式动画");
                    }
                    default:
                        break;
                }
            }

            @Override
            public boolean onItemLongClick(ViewGroup parent, View view, Object o, int position) {
                return false;
            }
        });
        rlvMain.setAdapter(adapter);
    }

    private void initView(View view) {
        ButterKnife.bind(this, view);

        rlvMain.setLayoutManager(new LinearLayoutManager(App.getInstance().getContext()));

        Bundle bundle = getArguments();
        String string = bundle.getString(KEY);
        tvDesc.setText(string);

        if (datas == null) {
            datas = new ArrayList<>();
            mapTitle = new HashMap<>();

            datas.add("PathViewActivity");
            mapTitle.put("PathViewActivity", "PathView效果");
            App.addData(new HashSetSearchBean("PathViewActivity", PathViewActivity.class));

            datas.add("ValueAnimActivity");
            mapTitle.put("ValueAnimActivity", "属性动画实例");
            App.addData(new HashSetSearchBean("ValueAnimActivity", ValueAnimActivity.class));

            datas.add("SVGPathActivity");
            mapTitle.put("SVGPathActivity", "SVG-Path动画实例");
            App.addData(new HashSetSearchBean("SVGPathActivity", SVGPathActivity.class));

            datas.add("CircleAnimActivity");
            mapTitle.put("CircleAnimActivity", "圆形扩散是动画效果");
            App.addData(new HashSetSearchBean("CircleAnimActivity", CircleAnimActivity.class));

            datas.add("SwipeBackActivity");
            mapTitle.put("SwipeBackActivity", "滑动退出Activity");
            App.addData(new HashSetSearchBean("SwipeBackActivity", SwipeBackActivity.class));

            datas.add("LoadingAnimActivity");
            mapTitle.put("LoadingAnimActivity", "老版58动画实现Loading");
            App.addData(new HashSetSearchBean("LoadingAnimActivity", LoadingAnimActivity.class));

            datas.add("CameraAnimActivity");
            mapTitle.put("CameraAnimActivity", "Camera+属性动画");
            App.addData(new HashSetSearchBean("CameraAnimActivity", CameraAnimActivity.class));

            datas.add("AnimatorActivity");
            mapTitle.put("AnimatorActivity", "属性的各种基础用法动画");
            App.addData(new HashSetSearchBean("AnimatorActivity", AnimatorActivity.class));

            datas.add("RightMarkActivity");
            mapTitle.put("RightMarkActivity", "Path对号动画");
            App.addData(new HashSetSearchBean("RightMarkActivity", RightMarkActivity.class));

            datas.add("VoiceAnimActivity");
            mapTitle.put("VoiceAnimActivity", "声波规律缩放式动画");
            App.addData(new HashSetSearchBean("VoiceAnimActivity", VoiceAnimActivity.class));
        }
    }

    private void addDB() {
        for (String name : datas) {
            SearchBean searchBean = new SearchBean();
            searchBean.setActivity(name);
            searchBean.setTitle(mapTitle.get(name));
            manager.insert(searchBean);
        }
    }
}
