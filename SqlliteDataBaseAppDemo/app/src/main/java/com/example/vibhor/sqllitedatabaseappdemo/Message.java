package com.example.vibhor.sqllitedatabaseappdemo;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by vibhor on 30-Apr-16.
 */
public class Message {

    public static void message(Context context, String message)
    {
        Toast.makeText(context,message , Toast.LENGTH_LONG).show();
    }

}
