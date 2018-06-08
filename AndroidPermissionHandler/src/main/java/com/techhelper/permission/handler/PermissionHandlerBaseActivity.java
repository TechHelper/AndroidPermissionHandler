package com.techhelper.permission.handler;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mayur on 19/11/15.
 */
public abstract class PermissionHandlerBaseActivity extends Activity implements ActivityCompat.OnRequestPermissionsResultCallback {

    private PermissionResultListener permissionResultListener;
    private int[] grantResultsAllGranted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //Permission code starts here

    private void askForPermission(String[] permissions, int requestCode) {
        String permission = "";
        boolean allGranted = true;
        grantResultsAllGranted = new int[permissions.length];
        List<String> newPermissions = new ArrayList<>();
        for (int i = 0; i < permissions.length; i++) {
            permission = permissions[i];
            if (ContextCompat.checkSelfPermission(this,
                    permission)
                    != PackageManager.PERMISSION_GRANTED) {
                allGranted = false;
                newPermissions.add(permissions[i]);
//                break;
            } else {
                grantResultsAllGranted[i] = PackageManager.PERMISSION_GRANTED;
            }
        }
        permissions = new String[newPermissions.size()];
        permissions = newPermissions.toArray(permissions);
        if (allGranted) {
            if (permissionResultListener != null) {
                permissionResultListener.onAllPermissionsGranted(requestCode, permissions, grantResultsAllGranted);
            }
        } else {
            ActivityCompat.requestPermissions(this,
                    permissions, requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        boolean allGranted = true;
        for (int i = 0; i < grantResults.length; i++) {
            if (grantResults[i] == PackageManager.PERMISSION_DENIED) {
                allGranted = false;
                break;
            }
        }
        if (permissionResultListener != null) {
            if (allGranted) {
                permissionResultListener.onAllPermissionsGranted(requestCode, permissions, grantResults);
            } else {
                // permission denied, boo! Disable the
                // functionality that depends on this permission.
                permissionResultListener.onPermissionDenied(requestCode, permissions, grantResults);
            }
        }
        permissionResultListener = null;

    }

    public void requestListOfPermissions(String[] permissionsList, int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(permissionsList, requestCode);
    }

    public void requestWriteStoragePermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, requestCode);
    }

    public void requestReadStoragePermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, requestCode);
    }

    public void requestCameraPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.CAMERA}, requestCode);
    }

    public void requestAccountsPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.GET_ACCOUNTS}, requestCode);
    }

    public void requestReadCalendarPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.READ_CALENDAR}, requestCode);
    }

    public void requestWriteCalendarPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.WRITE_CALENDAR}, requestCode);
    }

    public void requestReadContactsPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.READ_CONTACTS}, requestCode);
    }

    public void requestWriteContactsPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.WRITE_CONTACTS}, requestCode);
    }

    public void requestFineLocationPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, requestCode);
    }

    public void requestCourseLocationPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, requestCode);
    }

    public void requestRecordAudioPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.RECORD_AUDIO}, requestCode);
    }

    public void requestReadPhoneStatePermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.READ_PHONE_STATE}, requestCode);
    }

    public void requestCallPhonePermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.CALL_PHONE}, requestCode);
    }

    public void requestReadCallLogPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.READ_CALL_LOG}, requestCode);
    }

    public void requestWriteCallLogPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.WRITE_CALL_LOG}, requestCode);
    }

    public void requestAddVoicemailPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.ADD_VOICEMAIL}, requestCode);
    }

    public void requestUseSipPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.USE_SIP}, requestCode);
    }

    public void requestProcessOutgoingCallsPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.PROCESS_OUTGOING_CALLS}, requestCode);
    }

    public void requestBodySensorsPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.BODY_SENSORS}, requestCode);
    }

    public void requestSendSMSPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.SEND_SMS}, requestCode);
    }

    public void requestReceiveSMSPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.RECEIVE_SMS}, requestCode);
    }

    public void requestReadSMSPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.READ_SMS}, requestCode);
    }

    public void requestReceiveWAPPushPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.RECEIVE_WAP_PUSH}, requestCode);
    }

    public void requestReceiveMMSPermission(int requestCode, PermissionResultListener permissionResultListener) {
        this.permissionResultListener = permissionResultListener;
        askForPermission(new String[]{Manifest.permission.RECEIVE_MMS}, requestCode);
    }
    //Permission code ends here
}
