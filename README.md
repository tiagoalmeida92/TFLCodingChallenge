# TFLCodingChallenge

The repository has the goal of showcasing my skills on Android
Development

This app allows checking the status of roads in London, including
traffic and closures for this the [TFL API](https://api.tfl.gov.uk/) was used

## Configuration

1. To build the app you need an `APP_ID` and `APP_KEY` from
   [TFL API](https://api.tfl.gov.uk/) this step requires registration.
2.  Create a file with the name `tflapi.properties` on the root of the
    project
3.  The content of the file must be the following, replace X according
    to your api credentials

        base_url="https://api.tfl.gov.uk/"
        app_id="X"
        app_key="X"


## Building

#### Running the app

1. Make sure you have Android SDK installed
2. Run the following command on a terminal to build and install the app

        ./gradlew installDebug


#### Testing


##### Unit tests

1. Run the following command on the terminal to execute all unit tests,
   this task will fail if any of the tests fail

        ./gradlew test

2. Alternatively test can be run from Android Studio using gradle task
   `test`


##### UI tests

1. Connect an Android device to your computer, disable animations
   through the device developer options
2. Run the following command on the terminal .

        ./gradlew connectedAndroidTest

#### Linting

[Ktlint](https://github.com/pinterest/ktlint) was integrated on the project to maintain consistent
codestyle throughout

This linter can be run with the following command

      ./gradlew ktlint

## Concepts and Technology used:
* Test driven development
* Clean architecture
* Dagger 2
* RxJava
* LiveData
* MVVM
* Espresso

## Author

Developed by Tiago Almeida

## License
```
MIT License


Copyright (c) 2020 Tiago Almeida

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```