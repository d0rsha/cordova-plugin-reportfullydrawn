var exec = require("cordova/exec");

// export cordova exec methods 

exports.reportFullyDrawn = function(success, error) {
  exec(success, error, "ReportFullyDrawn", "reportFullyDrawn", []);
};

exports.coolMethod = function (arg0, success, error) {
    exec(success, error, 'ReportFullyDrawn', 'coolMethod', [arg0]);
};

exports.echo = function(success, error) {
    exec(success, error, 'ReportFullyDrawn', 'echo', [arg0]);
}

