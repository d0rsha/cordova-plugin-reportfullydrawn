var exec = require("cordova/exec");

exports.reportFullyDrawn = function(success, error) {
  exec(success, error, "ReportFullyDrawn", "reportFullyDrawn", []);
};
