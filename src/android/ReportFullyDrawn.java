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
import android.provider.Settings;

// Tidskontroll av plugins i Cordova
import android.os.SystemClock;
import android.util.TimeUtils;


public class ReportFullyDrawn extends CordovaPlugin {

    private final String TAG = "ReportFullyDrawnPlugin";
    private long launchTime;
    /**
     * Constructor.
     */
    public ReportFullyDrawn() {
        launchTime = SystemClock.uptimeMillis();
    }


    /*
    *   Initialize necccessary things before execute call 
    *       Not necescary to implement 
    */
    @Override
    protected void pluginInitialize() {
        this.cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                final long thisTime = launchTime - SystemClock.uptimeMillis();
                final String message =  "Starting ReportFullyDrawn plugin, Initialized after: ";
                TimeUtils.formatDuration(thisTime, message);

                Log.d(TAG, message);
            }
        });
    }

    /*
    *   Execute is called from cordova API 
    * 
    *   Connects local functions to Cordova execute() calls 
    *
    * @param action            The action to execute.
    * @param args              JSONArry of arguments for the plugin.
    * @param callbackContext   The callback id used when calling back into JavaScript.
    * @return                  True if the action was valid, false if not.
    */
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("reportFullyDrawn")) {
            Log.d(TAG, "reportFullyDrawn() called");
            this.reportFullyDrawn(callbackContext);
            return true;
        }else if (action.equals("printInfo")) {
            Log.d(TAG, "printInfo() called");
            this.printInfo(callbackContext);
            return true;
        } else if (action.equals("echo")) {
            Log.d(TAG, "echo() called");
            this.echo(callbackContext, args.getString(0));
            return true;
        } else if (action.equals("coolMethod")) {
            Log.d(TAG, "coolMethod() called");
            this.coolMethod(callbackContext);
            return true;
        }

        return false;
    }




    //--------------------------------------------------------------------------
    // NATIVE DEVICE CODE 
    //--------------------------------------------------------------------------

    /*
     *   Report application to be fully responsive and fully drawn 
     */
    private void reportFullyDrawn(final CallbackContext callbackContext) {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                final long thisTime = launchTime - SystemClock.uptimeMillis();
                final String message =  "cordova.getActivity().reportFullyDrawn() called after: ";
                TimeUtils.formatDuration(thisTime, message);


                Log.d(TAG, message);
                cordova.getActivity().reportFullyDrawn();
            }
        });
    }

    /*
     * Print info about the system
     */ 
    private void printInfo(final CallbackContext callbackContext) {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                final long thisTime = launchTime - SystemClock.uptimeMillis();
                final String message =  "cordova.getActivity().printInfo() called after: ";
                TimeUtils.formatDuration(thisTime, message);
                Log.d(TAG, message);

                String deviceInfo = "device: Device {";
                deviceInfo += "approach:hybrid,";
                deviceInfo += "version:" + android.os.Build.VERSION.RELEASE + ",";
                deviceInfo += "manufacturer:" + android.os.Build.MANUFACTURER + ",";
                deviceInfo += "model:" + android.os.Build.MODEL + ",";
                deviceInfo += "platform:android,";
                // Always ask for permission
                deviceInfo += "serial:"+ android.os.Build.SERIAL + ",";
                deviceInfo += "sdk-version:" + android.os.Build.VERSION.SDK_INT + ",";
                deviceInfo += "product:" + android.os.Build.PRODUCT + ",";
                deviceInfo += "isVirtual:" + isVirtual() + ",";
                deviceInfo += "uuid:" + Settings.Secure.getString(cordova.getActivity().getContentResolver(), android.provider.Settings.Secure.ANDROID_ID) + ",";
                // Extra info 
                deviceInfo += "osversion:" + System.getProperty("os.version") + ",";
                deviceInfo += "device:" + android.os.Build.DEVICE + ",";
                deviceInfo += "product:" + android.os.Build.PRODUCT + ",";
                deviceInfo += "bootloader:" + android.os.Build.BOOTLOADER + ",";
                deviceInfo += "id:" + android.os.Build.ID + ",";

                Log.d(TAG, deviceInfo);
                callbackContext.success(deviceInfo);
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
    */
    public boolean isVirtual() {
        return android.os.Build.FINGERPRINT.contains("generic") || android.os.Build.PRODUCT.contains("sdk");
    }
}