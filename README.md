# Real Time Chat

"Chat" is an Android application used for realtime chat, the application focuses on privacy and all your data is safe

Preview Of The App: https://youtu.be/wHdZNOOiOP0

## Installation

Clone This Repository in any folder in your pc and make sure java is installed 

```bash
java -version
```
you should be able to see your version of java installed, in case java is not installed in your pc install it using this link [java download](https://www.java.com/en/download/)

## Usage
The Project is already build for you and apk file can be downloaded from Chat>app>build>outputs>apk>debug but in case you would like to build it follow these steps

1) Open The Downloaded/Cloned Project In Your Terminal Window 
```bash
./gradlew.bat assembleDebug
```
You Should See BUILD SUCCESSFUL in your cmd, now go to Chat>app>build>outputs>apk>debug and install apk-debug.apk in your android device (Android Lollipop 5.1 or Higher)

In case You See Errors During Build Follow Steps Below

1) make sure java is installed and JAVA_HOME is added to your environment variables (windows)
2) in case of heap errors:
Anyway, here is how to fix it:

Go to Start->Control Panel->System->Advanced(tab)->Environment Variables->System Variables->New:

Variable name: _JAVA_OPTIONS

Variable value: -Xmx2512M

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.
## Images
<img src="https://github.com/sahilasopa/Chat/blob/master/Images/Screenshot_1630002400.png" width="200">
<img src="https://github.com/sahilasopa/Chat/blob/master/Images/Screenshot_1630002405.png" width="200">
<img src="https://github.com/sahilasopa/Chat/blob/master/Images/Screenshot_1630002408.png" width="200">
<img src="https://github.com/sahilasopa/Chat/blob/master/Images/Screenshot_1630002515.png" width="200">
<img src="https://github.com/sahilasopa/Chat/blob/master/Images/Screenshot_1630002521.png" width="200">
<img src="https://github.com/sahilasopa/Chat/blob/master/Images/Screenshot_1630002529.png" width="200">

## License
[MIT](https://choosealicense.com/licenses/mit/)
