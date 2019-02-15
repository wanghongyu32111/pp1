package com.example.wanghongyu20190116;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class fr1 extends Fragment {
   private String urlString="http://172.17.8.100/movieApi/movie/v1/findReleaseMovieList?page=1&count=10";
    private ArrayList<Json.ResultBean> list=new ArrayList<Json.ResultBean>();
    private int pag=0;
    private PullToRefreshListView pull;
    private MyAdapter adapter;
    private UserDao userDao;
    private ImageView image1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_f1_1, container, false);
        pull = view.findViewById(R.id.pull);
        pull.setMode(PullToRefreshListView.Mode.BOTH);
        adapter = new MyAdapter(list, getActivity());
        pull.setAdapter(adapter);
        userDao = new UserDao(getActivity());
       image1 = view.findViewById(R.id.image1);
        iniData(pag);
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
                list.clear();
                pag=0;
                iniData(pag);

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> pullToRefreshBase) {
              pag++;
              iniData(pag);
            }
        });

        return view;
    }
    private  class MAsycTask extends AsyncTask<String,Void,String> {

        @Override
        protected String doInBackground(String... strings) {
            //return NetWordUtils.et(strings[0]);
            String netjson = NetWorkwhy.getJson(strings[0]);
            return netjson;

        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson = new Gson();
            Json json = gson.fromJson(s, Json.class);
            List<Json.ResultBean> result = json.getResult();
            list.addAll(result);
            for (int i=0;i<list.size();i++){
                String summary = list.get(i).getSummary();
                userDao.add(summary);
            }

            adapter.notifyDataSetChanged();
            pull.onRefreshComplete();

        }


    }

    private void iniData(int pag) {
        String s = urlString + pag;
        if (NetWorkwhy.isconn(getActivity())){
            new MAsycTask().execute(s);
        }else{
            Toast.makeText(getActivity(),"没网",Toast.LENGTH_LONG).show();
            ArrayList<Json.ResultBean> list = userDao.query();
            adapter = new MyAdapter(list, getActivity());
            pull.setAdapter(adapter);
        }


    }
}
