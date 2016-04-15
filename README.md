# react-native-dialog

![android](https://github.com/honaf/react-native-dialog/raw/master/android_actionSheet.png) 
![ios](https://github.com/honaf/react-native-dialog/raw/master/ios_actionSheet.png) 

![android](https://github.com/honaf/react-native-dialog/raw/master/android_inputDialog.png) 
![ios](https://github.com/honaf/react-native-dialog/raw/master/ios_inputDialog.png) 




## Installation

First you need to install react-native-dialog:

```javascript
$ npm install react-native-dialog --save
```

**Add Configuration**
link
```javascript 
($ npm install rnpm --global)
$ rnpm link react-native-dialog
```

If the link fails, manually add

settings.gradle
```java
include ':react-native-dialog'
project(':react-native-dialog').projectDir = new File(rootProject.projectDir, '../node_modules/react-native-dialog/android')
```
build.gradle
```java
 dependencies {
    ...
    compile project(':react-native-dialog')
}
```
MainActivity
```java
import com.honaf.dialog.MyDialogPackage;
 @Override
    protected List<ReactPackage> getPackages() {
        return Arrays.<ReactPackage>asList(
                ...
                new MyDialogPackage(),
               );

    }
```

## Release Notes

 * 1.0.7

## Example

```js
import Dialog from ('react-native-dialog');

Dialog.showActionSheetWithOptions({
                    options: arr,
                    cancelButtonIndex: arr.length - 1,
                    destructiveButtonIndex: 0,
                },
                (buttonIndex) => {
                    if (buttonIndex == 0) {
                       ...
                    }
                });
     
                
Dialog.prompt("填写资料", null, [{
            text: '确定',
            onPress: (value) => {
                ...
            },
        }];  , undefined);


```

