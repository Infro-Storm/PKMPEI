package ru.pkmpei.mpei_pk;

import android.util.Base64;

import org.json.JSONObject;

public class ProtocolMPEI {
    private final static  String VERSION = "0.0.1";
    private final static  String URL = "https://infronet.ru/MPEI/auth_test.php";
    private byte[] sharedPublicKey;
    private ViewPort viewPort;

    public ProtocolMPEI(ViewPort viewPort)
    {
        this.viewPort = viewPort;
    }

    public boolean auth(String nickname, String password)
    {
        return false;
    }

    public void getSharedPublicKey(String nickname, String password)
    {
        new NetworkModel(this).sendRequest(URL, "protocolVersion="+ VERSION + "&method=helloMSG");
    }
    
    public void MessageReceiver(String message) {
        viewPort.sendToast("Test: " + message);
        try {
            JSONObject object = new JSONObject(message);
            String process = object.getString("process");
            switch (process)
            {
                case "getSharedPublicKey":
                    sharedPublicKey = Base64.decode( object.getString("sharedPublicKey"), Base64.DEFAULT );
                    break;
            }
        } catch (Exception e) {
            viewPort.sendToast(e.getMessage());
        }
    }
}
