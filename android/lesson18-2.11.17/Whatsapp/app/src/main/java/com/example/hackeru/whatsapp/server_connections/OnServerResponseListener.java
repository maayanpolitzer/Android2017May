package com.example.hackeru.whatsapp.server_connections;

import org.json.JSONObject;

/**
 * Created by hackeru on 10/2/2017.
 */

public interface OnServerResponseListener {

    void onSuccess(JSONObject data);

    void onFailure(String error);

}
