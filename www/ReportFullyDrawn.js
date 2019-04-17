var exec = require("cordova/exec");

// export cordova exec methods 

exports.reportFullyDrawn = function(success, error) {
  exec(success, error, "ReportFullyDrawn", "reportFullyDrawn", []);
};

exports.printInfo = function(success, error) {
  exec(success, error, "ReportFullyDrawn", "printInfo", []);
}

exports.coolMethod = function (arg, success, error) {
    exec(success, error, 'ReportFullyDrawn', 'coolMethod', [arg]);
};

exports.echo = function(arg, success, error) {
    exec(success, error, 'ReportFullyDrawn', 'echo', [arg]);
}

