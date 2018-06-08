package com.techhelper.permission.handler;

/**
 * Created by Mayur on 19/11/15.
 */
public interface PermissionResultListener {

    /**
     * Gets called if user grants all requested permissions.
     *
     * @param requestCode  The request code passed while requesting permission.
     * @param permissions  The requested permissions.
     * @param grantResults The grant results for the corresponding permissions which is either PERMISSION_GRANTED or PERMISSION_DENIED.
     */
    public void onAllPermissionsGranted(int requestCode,
                                        String[] permissions,
                                        int[] grantResults);

    /**
     * Gets called if user denies at least one or all requested permission(s).
     *
     * @param requestCode  The request code passed while requesting permission.
     * @param permissions  The requested permissions.
     * @param grantResults The grant results for the corresponding permissions which is either PERMISSION_GRANTED or PERMISSION_DENIED.
     */
    public void onPermissionDenied(int requestCode,
                                   String[] permissions,
                                   int[] grantResults);
}
