package com.example.swatisurisetti.applicationsample.utils.jsonclasses;

import java.io.File;
import java.util.HashMap;

import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;


@SuppressWarnings("unused")
public class JSONRequestResponse {

    private final Context mContext;
    private int reqCode;
    private IParseListener listner;

    private boolean isFile = false;
    private String file_path = "", key = "";
    private HashMap<String, File> mAttachFileList = new HashMap<String, File>();
    private String _tag_req = "mmp";

    public JSONRequestResponse(Context cntx) {
        // TODO Auto-generated constructor stub
        mContext = cntx;
    }

    public void getResponse(String url, final int requestCode,
                            IParseListener mParseListener) {
        getResponse(url, requestCode, mParseListener, null);
    }

    public void getResponse(String url, final int requestCode,
                            IParseListener mParseListener, Bundle params) {
        getResponse(url, requestCode, mParseListener, params, _tag_req);
    }

    public void getResponse(String url, final int requestCode,
                            IParseListener mParseListener, Bundle params, String TAG) {
        this.listner = mParseListener;
        this.reqCode = requestCode;


        Response.Listener<JSONObject> sListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                if (listner != null) {
                    listner.SuccessResponse(response, reqCode);
                }
            }
        };

        Response.ErrorListener eListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (listner != null) {
                    listner.ErrorResponse(error, reqCode);
                }
            }
        };

        if (!isFile) {
            JsonObjectRequest jsObjRequest = new JsonObjectRequest(
                    Request.Method.GET, url, null, sListener, eListener);
            jsObjRequest.setTag(_tag_req);
            MyVolley.getRequestQueue().add(jsObjRequest);
        } else {
            if (file_path != null) {
                if (file_path != null) {
                    String[] mary = file_path.split(",");
                    if (mary.length > 1) {
                        File mFile = new File(mary[0]);
                        MultipartRequest multipartRequest = new MultipartRequest(
                                url, eListener, sListener, key, mary, mFile,
                                params, mAttachFileList);
                        multipartRequest.setTag(_tag_req);
                        multipartRequest.setAttachFileList(mAttachFileList);
                        multipartRequest.setRetryPolicy(new DefaultRetryPolicy(80000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                        MyVolley.getRequestQueue().add(multipartRequest);
                    } else {
                        File mFile = new File(mary[0]);
                        MultipartRequest multipartRequest = new MultipartRequest(
                                url, eListener, sListener, key, mFile, params,
                                mAttachFileList);
                        multipartRequest.setTag(_tag_req);
                        multipartRequest.setAttachFileList(mAttachFileList);
                        multipartRequest.setRetryPolicy(new DefaultRetryPolicy(80000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
                        MyVolley.getRequestQueue().add(multipartRequest);
                    }
                } else {
                    throw new NullPointerException("File path is null");
                }
            } else {
                throw new NullPointerException("File path is null");
            }
        }
    }

    /**
     * @return the isFile
     */
    public boolean isFile() {
        return isFile;
    }

    /**
     * @param isFile the File to set
     */
    public void setFile(String param, String path) {
        if (path != null && param != null) {
            if (path.contains("null"))
                path = path.replace("null", "");
            key = param;
            file_path = path;
            this.isFile = true;
        }
    }

    public HashMap<String, File> getAttachFileList() {
        return mAttachFileList;
    }

    public void setAttachFileList(HashMap<String, File> mAttachFileList) {
        this.isFile = true;
        this.mAttachFileList = mAttachFileList;
    }

}