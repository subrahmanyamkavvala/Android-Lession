package com.practice.common;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * Created by inskavvala on 12/2/2016.
 */

public class StorageUtil {
    private static final String TAG = StorageUtil.class.getSimpleName();

    private Context mcontext;

    File internalCacheDir;
    File externalCacheDir;


    public StorageUtil(Context context) {

        mcontext = context;
        internalCacheDir = mcontext.getCacheDir();
        /// data/data/cache

        ///storage/sdcard/Android/data/com.practice/cache
        //externalCacheDir = mcontext.getExternalCacheDir();
        externalCacheDir = mcontext.getExternalFilesDir("practice");
        // Environment.getExternalStorageDirectory()

        //sdcatd
        Log.d(TAG,"intarnal storage Dir location "+ internalCacheDir.getAbsolutePath());
        Log.d(TAG,"exteranal storage  Dir location "+ externalCacheDir.getAbsolutePath());
        Log.d(TAG,"exteranal getExternalStorageDirectory : "+ Environment.getExternalStorageDirectory());

        //creating folder

    }

    public File getInternalStorage() {
        return internalCacheDir;

    }

    public File getExternalStorage() {
        return externalCacheDir;

    }

    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }


    public void savaTointarnalStorage(String data) {


        FileOutputStream fos;

        //data/data/com.practice
        //1.txt

        //data/data/com.practice/1.txt
        String fileName = File.separator + "TXT_"+ System.currentTimeMillis() + "."+"txt";
        //txt - "/"

        Log.d(TAG, "savaTointarnalStorage fiel Name : " + fileName);
        Log.d(TAG, " savaTointarnalStorageinternalCacheDir: " + internalCacheDir);
        try {
            File myFile = new File(internalCacheDir + fileName);

            Log.d(TAG, "Cache dir of the file : " + myFile.getAbsolutePath());
            Log.d(TAG, "Cache dir of the file : " + myFile.getPath());

            myFile.createNewFile();

            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(data);
            myOutWriter.close();
            fOut.close();

        } catch (FileNotFoundException e) {
            Log.d("", "fiel Name : " + e.getMessage());
        } catch (IOException e) {
            Log.d("", "fiel Name : " + e.getMessage());
        }

    }

    public void saveToExtarnalStorage(String data) {
        Log.d(TAG, "Save to External   : " );

        //
        FileOutputStream fos;

        String fileName = File.separator + "TXT_"+ System.currentTimeMillis() + "."+"txt";
        Log.d(TAG, "fiel Name : " + fileName);
        try {
            Log.d(TAG, "root dir :  : " + Environment.getExternalStorageDirectory());


            File myFile = new File(Environment.getExternalStorageDirectory() + fileName);

            Log.d(TAG, "New File location  : " + myFile.getAbsolutePath());

            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            myOutWriter.append(data);
            myOutWriter.close();
            fOut.close();

        } catch (FileNotFoundException e) {
            Log.d("", "fiel Name : " + e.getMessage());
        } catch (IOException e) {
            Log.d("", "fiel Name : " + e.getMessage());
        }

    }

    public void saveImage(Bitmap finalBitmap) {
        Log.d(TAG, "saveImage  : " );

        String root = Environment.getExternalStorageDirectory().toString();
        File myDir = new File(root + "/saved_images");
        Log.d(TAG, "saveImage path  : " +myDir.getAbsolutePath());
        myDir.mkdirs();
        Random generator = new Random();
        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-"+ n +".png";
        File file = new File (myDir, fname);
        if (file.exists ()) file.delete ();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}



