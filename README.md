# MobileTestDemo
A page object test demo using MobileTestFramework and MobileTestCommon

A demo test is ready for android Calculator.apk

### Preparation
#### Clone the demo and initialize submodules
```
git submodule update --init --resurvice
```
#### Run maven install to install [MobileTestFramework](https://github.com/rayzhouzhj/MobileTestFramework) and [MobileTestCommon](https://github.com/rayzhouzhj/MobileTestCommon) in your local repository
```
mvn clean install
```

### Run test using maven command
```
PLATFORM=Android DEBUG_MODE=OFF mvn clean test -Dtest=Runner
```

### Running using eclipse, please also provide the runtime environment variable in run configuration e.g.
 - ANDROID_HOME
 - PATH
 
### You can also override any properities of [config.properties](https://github.com/rayzhouzhj/MobileTestDemo/blob/master/config.properties) in eclipse run configuration.
