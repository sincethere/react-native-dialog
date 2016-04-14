# react-native-dialog

![android](https://github.com/honaf/react-native-dialog/raw/master/android_actionSheet.png) 
![ios](https://github.com/honaf/react-native-dialog/raw/master/ios_actionSheet.png) 

![android](https://github.com/honaf/react-native-dialog/raw/master/android_inputDialog.png) 
![ios](https://github.com/honaf/react-native-dialog/raw/master/ios_inputDialog.png) 


## Installation

First you need to install react-native-dialog:

```javascript
$ npm install react-native-dialog --save
($ npm install rnpm --global)
$ rnpm link react-native-dialog
```

## Release Notes

 * 1.0.5 

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
