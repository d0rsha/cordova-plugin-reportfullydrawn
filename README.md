# ReportFullyDrawn plugin

version 1.1.0.
Compatible with Android

How to use

```typescript
const callbackSuccess = success => {
  console.log(success);
};
const callbackError = error => {
  console.error(error);
};

this.platform.ready().then(() => {
  window["ReportFullyDrawn"].reportFullyDrawn(callbackSuccess, callbackError);
  window["ReportFullyDrawn"].printInfo();
});


```
