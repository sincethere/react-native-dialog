package com.honaf.dialog;



import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatEditText;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;


/**
 * Created by honaf on 16/2/29.
 * dialog
 */
public class MyDialogModule extends ReactContextBaseJavaModule
{
    public ReactContext currentReactContext = null;
    public MyDialogModule(ReactApplicationContext reactContext) {
        super(reactContext);
        currentReactContext = reactContext;
    }
    @Override
    public String getName() {
        return "MyDialogModule";
    }

    /**
     * 弹出类似于相册
     * @param array
     * @param callback
     */
    @ReactMethod
    public void actionSheet(ReadableArray array, final Callback callback){
        final String[] str = new String[array.size()];
        for (int i = 0; i<array.size(); i++ ){
            str[i] = array.getString(i);
        }
        AlertDialog.Builder dialog = new AlertDialog.Builder(this.getCurrentActivity());
        dialog.setItems(str, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        callback.invoke(i);
                    }
                }
        );
        dialog.show();
    }
    /**
     * 编辑弹出框
     */
    @ReactMethod
    public  void inputDialog(ReadableMap map,final Callback callback1,final Callback callback2) {
            if(map == null){
                return;
            }
            Activity context = this.getCurrentActivity();
            AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
            dialogBuilder.setTitle(map.getString("title"));
            final AppCompatEditText editText = new AppCompatEditText(context);
            editText.setText(map.hasKey("content") ? map.getString("content") : "");
            editText.setSingleLine(true);
            editText.setBackgroundResource(R.drawable.bg_home_search);
            editText.requestFocus();
            editText.setPadding(10, 8,
                    10, 8);
            editText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            LinearLayout layout = new LinearLayout(context);
            layout.setPadding(15, 10,
                    15, 0);
            layout.addView(editText);
            dialogBuilder.setView(layout);

            ReadableArray array = map.getArray("callbackOrButtons");
            String leftBtn = "确定";
            String rightBtn = "取消";
            if(array == null){
                return;
            }else if(array.size() == 1){
                leftBtn = array.getMap(0).getString("text");
            }else if(array.size() == 2){
                leftBtn = array.getMap(0).getString("text");
                rightBtn = array.getMap(1).getString("text");
            }
            dialogBuilder.setPositiveButton(leftBtn, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String text = editText.getText().toString().trim();
                    callback1.invoke(text);
                }
            });
            dialogBuilder.setNegativeButton(rightBtn, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    String text = editText.getText().toString().trim();
                    if (callback2 != null) {
                        callback2.invoke(text);
                    }
                }
            });
            AlertDialog dialog = dialogBuilder.create();
            dialog.getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
            dialog.show();
    }


//      @ReactMethod -> JavaScript
//    Boolean -> Bool
//    Integer -> Number
//    Double -> Number
//    Float -> Number
//    String -> String
//    Callback -> function
//    ReadableMap -> Object
//    ReadableArray -> Array


}
