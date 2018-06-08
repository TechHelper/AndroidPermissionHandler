package com.example.permission.handler;

import android.Manifest;
import android.os.Bundle;
import android.widget.Toast;

import com.techhelper.permission.handler.PermissionHandlerConstants;
import com.techhelper.permission.handler.PermissionResultListener;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        managePermissions();
    }

    private void managePermissions() {
        String[] permissions = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        requestListOfPermissions(permissions, PermissionHandlerConstants.STORAGE_CAMERA_PERMISSION_CODE, new PermissionResultListener() {
            @Override
            public void onAllPermissionsGranted(int i, String[] requestedPermissions, int[] grantResults) {
                //Open camera here or do your tasks.
                Toast.makeText(MainActivity.this, "Camera opened.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(int i, String[] requestedPermissions, int[] grantResults) {
                //Handle permission denial or show relevant error message.
                Toast.makeText(MainActivity.this, "App requires permission to capture and save images.", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void manageSinglePermission() {
        requestCourseLocationPermission(PermissionHandlerConstants.COURSE_LOCATION_PERMISSION_CODE, new PermissionResultListener() {
            @Override
            public void onAllPermissionsGranted(int i, String[] requestedPermissions, int[] grantResults) {
                //Open google map here or do your tasks.
                Toast.makeText(MainActivity.this, "Map opened.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionDenied(int i, String[] requestedPermissions, int[] grantResults) {
                //Handle permission denial or show relevant error message.
                Toast.makeText(MainActivity.this, "App requires permission to capture your current location.", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
