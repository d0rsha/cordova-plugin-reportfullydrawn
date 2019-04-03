var exec = require('cordova/exec');

// export cordova exec methods 

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'ReportFullyDrawn', 'coolMethod', [arg0]);
};


exports.reportFullyDrawn = function(success, error) {
    exec(success, error, 'ReportFullyDrawn', 'report', []);
}
