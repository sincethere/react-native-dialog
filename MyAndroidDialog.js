/**
 * dialog
 * Author:honaf
 */
'use strict';

import {
    Component,
    NativeModules,
} from 'react-native';

let MyDialogModule = NativeModules.MyDialogModule;

let MyAndroidDialog = {

    /**
     * 参数方法都是以ios用法为标准（具体可参考TopicCell.js）
     * options: 要显示的数组,
     * cancelButtonIndex: 取消的索引
     * destructiveButtonIndex: 警告的索引
     * callback: 选择item的回调
     */
    showActionSheetWithOptions(obj,callback){
        MyDialogModule.actionSheet(obj.options,(index)=>{
            callback(index);
        });
    },
    /**
     * 参数方法都是以ios用法为标准（具体可参考AddPet.js）
     * title 提示标题(必须)
     * message 提示文本 (android暂时未用到)
     * callbackOrButtons   [{text:'确定',onPress:(value)=>{}}]   （必须）
     * content 输入框默认值（暂时为android添加） （可填）
     */
    prompt(title, message, callbackOrButtons, type,content){
        MyDialogModule.inputDialog({title:title,content:content,callbackOrButtons:callbackOrButtons},(msg)=>{
            callbackOrButtons[0].onPress(msg);
        },(msg)=>{
            if(callbackOrButtons[1]){
                callbackOrButtons[1].onPress(msg);
            }
        });
    },

}

module.exports = MyAndroidDialog;