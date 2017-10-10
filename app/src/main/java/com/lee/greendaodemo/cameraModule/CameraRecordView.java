package com.lee.greendaodemo.cameraModule;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.lee.greendaodemo.BitmapUtils;
import com.lee.greendaodemo.FileUtils;
import com.lee.greendaodemo.R;

import java.io.File;

/**
 * Created by lijie on 2017/7/25.
 */

public class CameraRecordView extends RelativeLayout implements View.OnClickListener{
    Button finish,agin,savebtn,savePic;
    ImageView photoshow;
    RelativeLayout takephoto,imageshowlayout;
    private Button Camerabtn;
    EditText editname;
    Bitmap bitmap;
    private Context context;
    private Activity activity;
    public CameraRecordView(Context context) {
        super(context);
        this.context = context;
    }

    public CameraRecordView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public CameraRecordView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    public CameraRecordView(Context context,Activity activity) {
        super(context);
        this.activity = activity;
        this.context = context;
        initView();
    }
    private void initView(){
        View view = View.inflate(context,R.layout.fragment_camera, null);
        editname=(EditText) view.findViewById(R.id.editname);
        Camerabtn=(Button) view.findViewById(R.id.Camerabtn);
        finish=(Button) view.findViewById(R.id.finish);
        agin=(Button) view.findViewById(R.id.agin);
        savebtn=(Button) view.findViewById(R.id.savebtn);
        savePic=(Button) view.findViewById(R.id.copyPic);
        photoshow=(ImageView) view.findViewById(R.id.photoshow);
        takephoto=(RelativeLayout) view.findViewById(R.id.takephoto);
        imageshowlayout=(RelativeLayout) view.findViewById(R.id.imageshowlayout);
        Camerabtn.setOnClickListener(this);
        agin.setOnClickListener(this);
        savebtn.setOnClickListener(this);
        finish.setOnClickListener(this);
        savePic.setOnClickListener(this);
        this.addView(view);
    }
    @Override
    public void onClick(View v) {
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
                activity.startActivityForResult(cameraIntent, 1);
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
                activity.startActivityForResult(cameraIntent, 1);
                break;
            case R.id.savebtn:
                String imagename=editname.getText().toString().trim();
                if(TextUtils.isEmpty(imagename)){
                    Toast.makeText(activity, "请输入照片名称", Toast.LENGTH_LONG).show();
                    return;
                }
                String sdStatus = Environment.getExternalStorageState();
                if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
                    Log.v("TestFile",
                            "SD card is not avaiable/writeable right now.");
                    return;
                }
                String filename=Environment.getExternalStorageDirectory()+"/photograph/test/"+imagename+".png";

                boolean ok = BitmapUtils.getInstance(activity).saveBitmapForSdCard(bitmap, filename);

                Toast.makeText(activity,ok+"",Toast.LENGTH_SHORT).show();

                break;
            case R.id.copyPic:

                String name=editname.getText().toString().trim();
                if(TextUtils.isEmpty(name)){
                    Toast.makeText(activity, "请输入照片名称", Toast.LENGTH_LONG).show();
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
}
