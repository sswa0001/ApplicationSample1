package com.example.swatisurisetti.applicationsample;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.example.swatisurisetti.applicationsample.utils.StaticData;
import com.example.swatisurisetti.applicationsample.utils.StaticUtils;
import com.example.swatisurisetti.applicationsample.utils.WSUtils;
import com.example.swatisurisetti.applicationsample.utils.jsonclasses.IParseListener;
import com.example.swatisurisetti.applicationsample.utils.jsonclasses.JSONRequestResponse;
import com.example.swatisurisetti.applicationsample.utils.jsonclasses.MyVolley;


@SuppressLint("ClickableViewAccessibility")
public class MainActivity extends Activity implements OnClickListener, IParseListener {
    TextView txt_login;
    String deviceId;

    TelephonyManager telephonyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyVolley.init(this);
        getAllRefferences();
        setOnClickListeners();

    }


    @Override
    protected void onResume() {
        super.onResume();
    }

    private void getAllRefferences() {
        txt_login = (TextView) findViewById(R.id.txt_login);
    }

    private void setOnClickListeners() {

        txt_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.txt_login:
                telephonyManager = (TelephonyManager) getSystemService(this.TELEPHONY_SERVICE);
                if (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                deviceId = telephonyManager.getDeviceId();
                initiateLoginWS();
                break;

            default:
                break;
        }
    }


    private void initiateLoginWS() {
        Bundle mParams = new Bundle();
        mParams.putString("email_id", "sample@gmail.com");
        mParams.putString("password", "123456");
        mParams.putString("device_token", deviceId);
        mParams.putString("device_type", "Android");

        JSONRequestResponse mObj = new JSONRequestResponse(getParent());
        mObj.getResponse(StaticUtils.encodeUrl(WSUtils.LOGIN, mParams), StaticData.LOGIN_REQUEST_CODE, this);

    }

    public void clearStack(FragmentManager fm) {
        for (int i = 0; i < fm.getBackStackEntryCount() - 1; i++)
            fm.popBackStack();
    }


    /**
     * Success Error Response Of WebService Login
     */
    @Override
    public void ErrorResponse(VolleyError error, int requestCode) {
        if (StaticUtils.isNetworkAvailable(this)) {
            Toast.makeText(this, "something_went_wrong_please_try_again_later", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "something_went_wrong_please_try_again_later", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void SuccessResponse(JSONObject response, int requestCode) {
        switch (requestCode) {
            case StaticData.LOGIN_REQUEST_CODE:
                responseForLogin(response);
                break;

            default:
                break;
        }
    }


    private void responseForLogin(JSONObject response) {
        if (response != null) {
            try {
                JSONObject mSettingObject = response.getJSONObject("settings");
                if (mSettingObject.getString("success").equalsIgnoreCase("1")) {
                    JSONArray mDataArray = new JSONArray(response.getString(StaticData.DATA));
                    storeUserInfo(mDataArray);
                } else {
                    //  hideProgress();
                    Toast.makeText(this, mSettingObject.getString("message"), Toast.LENGTH_SHORT).show();

                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void storeUserInfo(JSONArray mDataArray) {
        if (mDataArray != null && mDataArray.length() != 0) {
            try {
                JSONObject mDataObj = mDataArray.getJSONObject(0);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        // Setting Slider Data
/*
        Intent loginIntent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(loginIntent);
        finish();
        overridePendingTransition(R.anim.enter_from_right, R.anim.exit_to_left);*/
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}



