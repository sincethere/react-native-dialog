package com.honaf.dialog;

import android.app.Activity;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import com.honaf.dialog.MyDialogModule;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by apple on 16/2/29.
 */
public class MyDialogPackage implements ReactPackage {
    public Activity mActivity;
    public MyDialogPackage(Activity activity){
        mActivity = activity;
    }
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<>();
        modules.add(new MyDialogModule(reactContext,mActivity));
        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}
