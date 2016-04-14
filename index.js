/**
 * dialog
 * Author:honaf
 */
'use strict';

import {
    Platform,
} from 'react-native';

let dialog = null;

if (Platform.OS == 'ios') {
    dialog = require('./MyIosDialog');
} else {
    dialog = require('./MyAndroidDialog');
}

module.exports = dialog;