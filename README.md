# AndroidPermissionHandler
[ ![Download](https://api.bintray.com/packages/mayuraouti/AndroidPermissionHandler/AndroidPermissionHandler/images/download.svg) ](https://bintray.com/mayuraouti/AndroidPermissionHandler/AndroidPermissionHandler/_latestVersion)

Request single or multiple permissions in activity or fragment at run time without any hassles.

## Gradle dependency
```
allprojects {
repositories {
    jcenter()
  }
}

compile 'com.techhelper.permission.handler:AndroidPermissionHandler:1.0.0'
```

## Steps to use this library

### 1. Add your permission in the manifest file using uses-permission tag.

### 2. Extend required Permission Handler activity in your common activity or base activity as shown:

```
class BaseActivity extends PermissionHandlerBaseAppCompatActivity{

}
```
### 3. Example to request a single permission:
```
requestWriteStoragePermission(STORAGE_PERMISSION_CODE, new PermissionResultListener() {
    @Override
    public void onAllPermissionsGranted(int requestCode, String[] permissions, int[] grantResults) {
        // Now permission is granted. Do your task here.
    }
    @Override
    public void onPermissionDenied(int requestCode, String[] permissions, int[] grantResults) {
	 // Permission is denied. Check for denied permission and show relevant message to the user.
    }
});
```
### 4. Example to request multiple permissions:
```
String[] permissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA};
requestListOfPermissions(permissions, STORAGE_CAMERA_PERMISSION_CODE, new PermissionResultListener() {
    @Override
    public void onAllPermissionsGranted(int requestCode, String[] permissions, int[] grantResults) {
        // Now all permissions are granted. Do your task here.
    }
    @Override
    public void onPermissionDenied(int requestCode, String[] permissions, int[] grantResults) {
        // Few or all permissions are denied. Check for denied permissions and show relevant message to the user.
    }
});
```
### 5. Implement PermissionHandlerConstants interface if required as shown:    
```
class SignUpActivity implements PermissionHandlerConstants{

}
```
### 6. Don't forget to set targetSDK to 23 or above to make it work properly.

## Contributing

Please feel free to contribute by following standard process of reviewing pull requests and other git commands.

## License

This project is licensed under the [Apache-2.0] - see the LICENSE file for details

