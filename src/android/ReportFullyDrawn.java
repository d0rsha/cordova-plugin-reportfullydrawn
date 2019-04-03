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
    private static final String TAG = "ReportFullyDrawnTag";


    /* // ngOnInit() { ... } 
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d(TAG, "Initialize ReportFullyDrawn Plugin");
    } */
    @Override
    protected void pluginInitialize() {
        Log.d(TAG, "Starting ReportFullyDrawn Plugin");
    }        

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        Log.d(TAG, "run execute()");
        if (action.equals("report")) {
            this.report(callbackContext);
            return true;
        } else if (action.equals("coolMethod")) {
            this.coolMethod(callbackContext);
            return true;
        } else if (action.equals("echo")) {
            this.echo(callbackContext, echo);
            return true;
        } 

        Log.d(TAG, "execute() FAILED");
        return false;
    }



    private void report(final CallbackContext callbackContext) {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    Log.d(Tag, "TRY ");
                    Log.d(TAG, "report()");
                    String res = cordova.getActivity().reportFullyDrawn();
                    callbackContext.success(res);
                    Log.d(myTag, "callbackContext.success();");
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void coolMethod(final CallbackContext callbackContext) {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    Log.d(Tag, "TRY ");
                    Log.d(TAG, "coolMethod()");
                    callbackContext.success("coolMethod() done");
                    Log.d(myTag, "callbackContext.success();");
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }

    private void echo(final CallbackContext callbackContext, final String echo) {
        cordova.getThreadPool().execute(new Runnable() {
            public void run() {
                try {
                    Log.d(Tag, "TRY ");
                    Log.d(TAG, "echo()");
                    Log.d(TAG, echo);
                    callbackContext.success(echo);
                    Log.d(myTag, "callbackContext.success();");
                } catch (Exception e) {
                    callbackContext.error(e.getMessage());
                }
            }
        });
    }
}