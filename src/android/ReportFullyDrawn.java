package org.apache.cordova.avrethem;

import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CordovaWebView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Android Manifest && PackageManager
import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class ReportFullyDrawn extends CordovaPlugin {

    private final String TAG = "ReportFullyDrawnPlugin";

    /*
    *   Initialize necccessary things before execute call 
    *       Not necescary toi implement 
    */
    @Override
    protected void pluginInitialize() {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                Log.d(TAG, "Starting ReportFullyDrawn plugin");
            }
        });
    }

    /*
    *   Execute is called from cordova API 
    *
    *   @param  action 
    *   @param  args
    *   @param  callbackContext 
    */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("reportFullyDrawn")) {
            Log.d(TAG, "reportFullyDrawn() called");
            this.reportFullyDrawn(callbackContext);
            return true;
        } 

        return false;
    }


    private void reportFullyDrawn(final CallbackContext callbackContext) {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                Log.d(TAG, "cordova.getActivity().reportFullyDrawn() called");
                cordova.getActivity().reportFullyDrawn();
            }
        });
    }

    private void printInfo(final CallbackContext callbackContext) {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                //
                //  Print info about the system
                //
                Log.d(TAG, "cordova.getActivity().printInfo() called");
                String deviceInfo = "device: Device {";
                deviceInfo += "approach:native,";
                deviceInfo += "version:" + android.os.Build.VERSION.RELEASE + ",";
                deviceInfo += "manufacturer:" + android.os.Build.MANUFACTURER + ",";
                deviceInfo += "model:" + android.os.Build.MODEL + ",";
                deviceInfo += "platform:android,";
                // Always ask for permission
                if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    deviceInfo += "serial:" + android.os.Build.getSerial() + ",";

                } else {
                    deviceInfo += "serial:"+ android.os.Build.SERIAL + ",";
                }
                deviceInfo += "android-api:" + android.os.Build.VERSION.SDK_INT + ",";
                deviceInfo += "product:" + android.os.Build.PRODUCT + ",";
                deviceInfo += "isVirtual:" + isEmulator() + ",";


                // Extra info 
                deviceInfo += "device:" + android.os.Build.DEVICE + ",";
                deviceInfo += "product:" + android.os.Build.PRODUCT + ",";
                deviceInfo += "bootloader:" + android.os.Build.BOOTLOADER + ",";
                deviceInfo += "os:" + System.getProperty("os.version") + ",";
                deviceInfo += "bootloader:" + android.os.Build.ID + ",";


                Log.d(TAG, deviceInfo);
            }
        });
    }


    private void coolMethod(final CallbackContext callbackContext) {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    Log.d(TAG, "TRY ");
                    Log.d(TAG, "coolMethod()");
                    callbackContext.success("coolMethod() done");
                    Log.d(TAG, "callbackContext.success();");
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void echo(final CallbackContext callbackContext, final String echoCall) {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    Log.d(TAG, "TRY ");
                    Log.d(TAG, "echo()");
                    Log.d(TAG, echoCall);
                    callbackContext.success(echoCall);
                    Log.d(TAG, "callbackContext.success();");
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }


    /*
    *   Helper function
    *
    */
    public static String isEmulator() {
        if (Build.FINGERPRINT.startsWith("generic")
                || Build.FINGERPRINT.startsWith("unknown")
                || Build.MODEL.contains("google_sdk")
                || Build.MODEL.contains("Emulator")
                || Build.MODEL.contains("Android SDK built for x86")
                || Build.MANUFACTURER.contains("Genymotion")
                || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
                || "google_sdk".equals(Build.PRODUCT))
            return "true";
        else
            return "false";
    }

    /*
    *  Helper function
    *
    */
/*     public static final String PHONE_STATE_PERMISSION =
            Manifest.permission.READ_PHONE_STATE;

    public static boolean checkPermission(String permission, Activity activity) {
        return ContextCompat.checkSelfPermission(activity, permission) ==
                PackageManager.PERMISSION_GRANTED;
    } */
}

//cordova plugin add cordova-plugin-android-support-v4