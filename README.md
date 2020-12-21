# GANTest

## Introduction

* This is a smalle Kotlin application in which calling an Networking API through Retrofit2 and show result in Recyclerview. 
* Showing image in imageview load image URL using piccaso.
* Search functionality search item by name.
* Navigation between two activities.
* Sending Parcable object through Intent.

## Tools 

* Windows 10
* Android Studio (version 4.0).
* If kotlin plugin is not installed in Android Studio.
* install Kotlin plugin in Android Studio.

 File-> Setting-> plugin -> MarketPlace -> type kotlin in search bar -> Install -> Apply-> ok.
 
* Minimum SDK version 21.
* Compile SDK version 29.
* Testing Mobile Device (Android version 10).

## Declaring dependencies

## Piccaso 
A powerful image downloading and caching library for Android.

```
implementation 'com.squareup.picasso:picasso:2.71828'
```

## RecyclerView
RecyclerView makes it easy to efficiently display large sets of data. We can perform many operation in recyclerview.

```
implementation 'androidx.recyclerview:recyclerview:1.1.0'
```

## Retrofit2
Retrofit is used for calling networking API through request URL and getting result in a response in gson. 

```
   implementation 'com.squareup.retrofit2:retrofit:2.5.0'
   implementation 'com.squareup.retrofit2:converter-gson:2.5.0'
```

## Matarial Desingn
Material Design uses more grid-based layouts, responsive animations and transitions, padding, and depth effects such as lighting and shadows.

```
implementation 'androidx.recyclerview:recyclerview:1.1.0'
```
## JUnit & Espresso
JUnit and Espresso are used for unit testing and instrumental testing. By default, these libraries are implemented in the Android build.gradle file.

``` 
    testImplementation 'junit:junit:4.13'
    androidTestImplementation 'androidx.test.ext:junit:1.1.2'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.3.0'
```

## Get Clone and run project in Android Studio
Use Git commands for clone code from the repository.
Clone
Use git clone command to clone repository
```
git clone https://github.com/Neha-Rajput/GANTest.git
```
After successful cloning of project open project in Android Studio.

Android Studio -> File -> Open
select file "GAN TestApplication" -> OK

Run Project 
Android Studio -> Run -> Run "app"

Select emulator or connect a real Android device and if you run the app in real Android Device make debugging mode ON.

Mobile Debugging select below option in phone.

Setting -> Additional Setting -> Developer Option - > USB Debugging 

make USB Debuggin ON.

Finally App run in you phone and its look like


* Gridview of Breaking Character with image and name is showing in the recyclerview by calling Networking API through Retrofit.
  ![](/Screenshot_2020-12-18-18-05-35-737_com.example.gantestapplication.jpg)
  
* Search option is available in ActionBar search Breaking Bad Character by typing the name on the search bar and tap on search key in keypad.
![](/Screenshot_2020-12-18-18-05-50-375_com.example.gantestapplication.jpg)

* Tap in list item in gridview for showing details of character.
![](/Screenshot_2020-12-18-18-05-41-064_com.example.gantestapplication.jpg)


  
  
  
  






 
 
 
 
 

















