/**
 * dialog
 * Author:honaf
 */
'use strict';

import {
    Component,
    ActionSheetIOS,
    AlertIOS
} from 'react-native';

let MyIosDialog = {

    showActionSheetWithOptions(obj,callback){
        ActionSheetIOS.showActionSheetWithOptions({
                options: obj.options,
                cancelButtonIndex: obj.cancelButtonIndex,
                destructiveButtonIndex: obj.destructiveButtonIndex,
            },
            (buttonIndex) => {
                   callback(buttonIndex)
            });
    },

    prompt(title, message, callbackOrButtons, type){
        AlertIOS.prompt(title,message,callbackOrButtons,type);
    },


}

module.exports = MyIosDialog;