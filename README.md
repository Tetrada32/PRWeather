# PlanRadarWeather
Welcome to Android "PRWeather". This is implementation of a test assessment for "Plan Radar" by 
[Danylo Hakhov](https://www.linkedin.com/in/gahov/) :)

I tried to make the implementation as cool as possible, meeting all industry standards and best 
practices in Android development.

Below you can find all the details regarding the implementation.

## Project description 
### API used: [Weather API](https://openweathermap.org)
This is a free API, that allows developers to receive weather updates in specific locations.

The main logic is based on the [Current weather data](https://openweathermap.org/current) endpoint.
The search is implemented by "CityName" manual input, which is possible with the "Geocoding" feature.

Although this built-in API is deprecated, it performed well in terms of implementing this test task.

I refused to use alternatives since the assignment condition says to use only certain requests with
certain parameters.


### Technologies: 
The application is developed in accordance with the best practices recommended in Android development.

It's based on [Clean Architecture](https://medium.com/android-dev-hacks/detailed-guide-on-android-clean-architecture-9eab262a9011).
For screen management I used "SingleActivity" approach, as one of the best practise for Android today.

Main technologies and libraries: 
- Android SDK :)
- Hilt
- Android Jetpack: ViewModel 
- Android Jetpack: LiveData 
- Android Jetpack: Navigation Component 
- Android Jetpack: Room
- Kotlin Coroutines 
- Retrofit 
- OkHttp 
- DataBinding
- Coil
- Junit 
- Mockito


# If you want to install the application via AS, or if you also want to contribute: 

## Requirements
- Android Studio version "Giraffe" | 2022.3.1 or later
- JDK version 11
- Kotlin version 1.9.20
- Gradle version 8 or later
- Android SDK version 35

Android Studio and all required tools can be downloaded here: 
`https://developer.android.com/studio`


## Code style 

##### Kotlin
- In this project, I follow [general Android code-style guide](https://source.android.com/docs/core/architecture/hidl/code-style)
and [Official Kotlin coding conventions](https://kotlinlang.org/docs/coding-conventions.html).
- The only language is 100% Kotlin, I didn't use Java. 


