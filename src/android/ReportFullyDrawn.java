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
                    callbackContext.success(echo);
                    Log.d(TAG, "callbackContext.success();");
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }
}