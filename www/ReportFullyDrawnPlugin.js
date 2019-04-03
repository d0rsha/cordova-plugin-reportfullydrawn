var exec = require('cordova/exec');

// export cordova exec methods 

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'ReportFullyDrawn', 'coolMethod', [arg0]);
};


exports.report = function(success, error) {
    exec(success, error, 'ReportFullyDrawn', 'report', []);
}


exports.echo = function(success, error) {
    exec(success, error, 'ReportFullyDrawn', 'echo', [arg0]);
}

