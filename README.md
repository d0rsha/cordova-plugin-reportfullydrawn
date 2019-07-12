# ReportFullyDrawn plugin

version 1.1.0.
Compatible with Android

Install
```bash
npm i cordova-plugin-reportfullydrawn
ionic cordova plugin add cordova-plugin-reportfullydrawn
```

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
qwe qwe qwe
