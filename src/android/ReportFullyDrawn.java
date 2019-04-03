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


    // ngOnInit() { ... } 
    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d(TAG, "Initialize ReportFullyDrawn Plugin");
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("report")) {
            Log.d(TAG, "execute() report");

            try {
                // Report fully drawn 
                this.cordova.getActivity().reportFullyDrawn();
                 Log.d(TAG, "report() executed successfully");
            } catch (Exception e){
                Log.d(TAG, e);
                Log.d(TAG, e.message);
                Log.d(TAG, "execute() report", "just ", "for ", "test");
            }
            

        
        } else if (action.equals("coolMethod") {
            Log.d(TAG, "execute() coolMethod");
        } else {
            Log.d(TAG, "execute() no correct parameters");
        }
    }

}