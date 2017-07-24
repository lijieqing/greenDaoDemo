package com.lee.greendaodemo.cameraModule;

import java.io.File;


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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        editname=(EditText) findViewById(R.id.editname);
        Camerabtn=(Button) findViewById(R.id.Camerabtn);
        finish=(Button) findViewById(R.id.finish);
        agin=(Button) findViewById(R.id.agin);
        savebtn=(Button) findViewById(R.id.savebtn);
        savePic=(Button) findViewById(R.id.copyPic);
        photoshow=(ImageView) findViewById(R.id.photoshow);
        takephoto=(RelativeLayout) findViewById(R.id.takephoto);
        imageshowlayout=(RelativeLayout) findViewById(R.id.imageshowlayout);
        Camerabtn.setOnClickListener(this);
        agin.setOnClickListener(this);
        savebtn.setOnClickListener(this);
        finish.setOnClickListener(this);
        savePic.setOnClickListener(this);

    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        Intent cameraIntent=null;
        Uri imageUri=null;

        switch (v.getId()) {
            case R.id.Camerabtn:
//		   Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//			startActivityForResult(intent, 1);
                cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"workupload.jpg"));
                //指定照片保存路径（SD卡），workupload.jpg为一个临时文件，每次拍照后这个图片都会被替换
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(cameraIntent, 1);
                break;
            case R.id.finish:
                takephoto.setVisibility(View.VISIBLE);
                imageshowlayout.setVisibility(View.GONE);
                break;
            case R.id.agin:
                cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                imageUri  = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),"workupload.jpg"));
                //指定照片保存路径（SD卡），workupload.jpg为一个临时文件，每次拍照后这个图片都会被替换
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
                startActivityForResult(cameraIntent, 1);
                break;
            case R.id.savebtn:
                String imagename=editname.getText().toString().trim();
                if(TextUtils.isEmpty(imagename)){
                    Toast.makeText(CameraActivity.this, "请输入照片名称", Toast.LENGTH_LONG).show();
                    return;
                }
                String sdStatus = Environment.getExternalStorageState();
                if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                    Log.v("TestFile",
                            "SD card is not avaiable/writeable right now.");
                    return;
                }
                String filename=Environment.getExternalStorageDirectory()+"/photograph/test/"+imagename+".png";

                boolean ok = BitmapUtils.getInstance(this).saveBitmapForSdCard(bitmap, filename);

                Toast.makeText(this,ok+"",Toast.LENGTH_SHORT).show();

                break;
            case R.id.copyPic:

                String name=editname.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(CameraActivity.this, "请输入照片名称", Toast.LENGTH_LONG).show();
                    return;
                }
                String Status = Environment.getExternalStorageState();
                if (!Status.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                    Log.v("TestFile",
                            "SD card is not avaiable/writeable right now.");
                    return;
                }
                String fname=Environment.getExternalStorageDirectory()+"/photograph/test/"+name+".jpg";

                File inFile = new File(Environment.getExternalStorageDirectory(),"workupload.jpg");
                File outFile = new File(fname);
                FileUtils.fileCopy(inFile,outFile);
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            takephoto.setVisibility(View.GONE);
            imageshowlayout.setVisibility(View.VISIBLE);
            Bitmap camorabitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory()+"/workupload.jpg");
            if(null != camorabitmap ){

                // 下面这两句是对图片按照一定的比例缩放，这样就可以完美地显示出来。
                bitmap = BitmapUtils.getInstance(this).getZoomBitmap(camorabitmap,500,600);

                //由于Bitmap内存占用较大，这里需要回收内存，否则会报out of memory异常
                camorabitmap.recycle();
                //将处理过的图片显示在界面上
                photoshow.setImageBitmap(bitmap);
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == KeyEvent.KEYCODE_BACK) { // 监控/拦截/屏蔽返回键
            if (imageshowlayout.getVisibility() == View.VISIBLE) {
                imageshowlayout.setVisibility(View.GONE);
                takephoto.setVisibility(View.VISIBLE);
            } else {
                finish();
            }
            return false;
        }

        return super.onKeyDown(keyCode, event);
    }

}
