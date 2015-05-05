package com.andani.animesh.camera1;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;


public class MainActivity extends ActionBarActivity {
File file;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void process(View view)
    {
        Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),"test.jpg");
        Uri uri= Uri.fromFile(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);
        startActivityForResult(intent, 0);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==0)
        {
            switch (resultCode)
            {
                case Activity.RESULT_OK:
                    if (file.exists()) {
                        Toast.makeText(this, "its stored at" + file.getAbsolutePath(), Toast.LENGTH_LONG).show();

                        break;
                    }
                    else {
                        Toast.makeText(this,"not found",Toast.LENGTH_LONG).show();
                    }
                case Activity.RESULT_CANCELED:

                    break;



            }
        }
    }
}
