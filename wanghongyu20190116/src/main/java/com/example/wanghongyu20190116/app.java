package com.example.wanghongyu20190116;

import android.app.Application;
import android.graphics.Bitmap;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import java.io.File;

public class app extends Application {
   /* @Override
    public void onCreate() {
        super.onCreate();
        ImageLoaderConfiguration build = new ImageLoaderConfiguration.Builder(this).build();
        ImageLoader instance = ImageLoader.getInstance();
        instance.init(build);
    }
   //原图
    public static DisplayImageOptions getDisplayImageOptions(){
        DisplayImageOptions  builder = new DisplayImageOptions.Builder()
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher_round)
                .displayer(new RoundedBitmapDisplayer(360))
                .build();
        return builder;
    }*/
    @Override
    public void onCreate() {
        super.onCreate();
        File cacheDir = new File(Environment.getExternalStorageDirectory().getPath()+"/images");

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.mipmap.ic_launcher)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .displayer(new RoundedBitmapDisplayer(40))
                .build();
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(options)
                .diskCache(new UnlimitedDiskCache(cacheDir))
                .build();

        ImageLoader.getInstance().init(configuration);
    }
    public static DisplayImageOptions getDisplayImageOptions(){
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .displayer(new RoundedBitmapDisplayer(360))
                .showImageOnFail(R.mipmap.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnLoading(R.mipmap.ic_launcher)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .cacheOnDisk(true)
                .cacheInMemory(true)
                .build();
        return options;
    }

}
