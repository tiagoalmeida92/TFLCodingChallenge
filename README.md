# TFLCodingChallenge
Get London Road status using TFL apis

Building the project

gradlew assemble
This command will build both debug and release versions
The output is an APK located at /app/build/outputs/apk

Testing

Unit tests
gradlew test
Running the unit tests present in all the modules
This gradle task will fail if any unit test fail

Alternatively the tests can be run from Android Studio gradle task 'test'

UI tests

gradlew connectedAndroidTest

Installing the app

gradlew installDebug

Linting

Kotlin verifier with KTlint
gradlew ktlint