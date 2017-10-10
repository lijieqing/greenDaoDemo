package com.lee.greendaodemo.cameraModule;

import java.io.File;


import android.app.AlertDialog;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lee.greendaodemo.BitmapUtils;
import com.lee.greendaodemo.FileUtils;
import com.lee.greendaodemo.R;

public class CameraActivity extends Activity implements OnClickListener{
    Button  finish,agin,savebtn,savePic;
    ImageView  photoshow;
    RelativeLayout takephoto,imageshowlayout;
    private Button Camerabtn;
    EditText  editname;
    Bitmap bitmap,mBitmap;
    AlertDialog dialog;
    CameraRecordView cameraRecordView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
        Camerabtn=(Button) findViewById(R.id.Camerabtn);
        Camerabtn.setOnClickListener(this);
        cameraRecordView = new CameraRecordView(this,this);
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.Camerabtn:
                dialog = new AlertDialog.Builder(this)
                        .setTitle("拍照")
                        .setNegativeButton("取消",null)
                        .setCancelable(false)
                        .create();
                dialog.setView(cameraRecordView);
                dialog.show();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            cameraRecordView.takephoto.setVisibility(View.GONE);
            cameraRecordView.imageshowlayout.setVisibility(View.VISIBLE);
            Bitmap camorabitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/workupload.jpg");
            if(null != camorabitmap ){

                // 下面这两句是对图片按照一定的比例缩放，这样就可以完美地显示出来。
                bitmap = BitmapUtils.getInstance(this).getZoomBitmap(camorabitmap,500,600);

                //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常
                camorabitmap.recycle();
                //将处理过的图片显示在界面上
                cameraRecordView.photoshow.setImageBitmap(bitmap);
                if (null != cameraRecordView.bitmap)
                    cameraRecordView.bitmap.recycle();
                cameraRecordView.bitmap = bitmap;
                bitmap = null;
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) { // 监控/拦截/屏蔽返回键
            if (cameraRecordView.imageshowlayout.getVisibility() == View.VISIBLE) {
                cameraRecordView.imageshowlayout.setVisibility(View.GONE);
                cameraRecordView.takephoto.setVisibility(View.VISIBLE);
            } else {
                finish();
            }
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }

}
