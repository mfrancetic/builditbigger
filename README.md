Build It Bigger

"Build It Bigger" project for the Udacity Android Developer Nanodegree program

The application for displaying jokes, consisting of four modules: a Java library that provides jokes, a Google Cloud Endpoints (GCE) project that serves the jokes, an Android Library containing an activity for displaying jokes, and the Android app that fetches jokes from the GCE module and passes them to the Android Library for display.

The application has a free flavor that displays an ad, and a paid flavor without the ads.

Instructions to set up Google Cloud Endpoints (GCE):

Before going ahead you will need to be able to run a local instance of the GCE server. 
In order to do that you will have to install the Cloud SDK:

https://cloud.google.com/sdk/docs/

Once installed, you will need to follow the instructions in the Setup Cloud SDK section at:

https://cloud.google.com/endpoints/docs/frameworks/java/migrating-android

Note: You do not need to follow the rest of steps in the migration guide, only the Setup Cloud SDK.

Start or stop your local server by using the gradle tasks "appengineStart" and "appengineStop", located at "Gradle" --> ":backend" --> ":Tasks" --> "app engine standard environment".

Once your local GCE server is started you should see a "Hello, Endpoints!" website at localhost:8080.
