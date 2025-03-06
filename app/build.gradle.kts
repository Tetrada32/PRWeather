plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.gahov.prweather"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.gahov.prweather"
        minSdk = 28
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    kapt {
        correctErrorTypes = true
    }

    sourceSets {
        getByName("test") {
            java.srcDirs("src\\test\\resources") // Add any custom test source directories
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra.get("kotlinVersion") as String}")

    implementation("androidx.activity:activity-ktx:1.10.1")
    implementation("androidx.fragment:fragment-ktx:1.8.6")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.core:core-ktx:1.15.0")

    implementation("androidx.constraintlayout:constraintlayout:2.2.1")
    implementation("com.google.android.material:material:1.12.0")

    implementation("androidx.navigation:navigation-fragment-ktx:2.8.8")
    implementation("androidx.navigation:navigation-ui-ktx:2.8.8")

    implementation("com.google.dagger:hilt-android:2.55")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    kapt("com.google.dagger:hilt-android-compiler:2.55")

    implementation("androidx.room:room-ktx:2.6.1")
    implementation("androidx.startup:startup-runtime:1.2.0")

    implementation("io.coil-kt:coil:2.2.2")

    androidTestImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test:runner:1.6.2")
    testImplementation("junit:junit:4.13.2")
    testImplementation("com.squareup.okhttp3:mockwebserver3:5.0.0-alpha.9")
    testImplementation("org.mockito:mockito-core:4.8.1")
    testImplementation("org.mockito:mockito-inline:4.8.1")
    testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    testImplementation("com.google.truth:truth:1.1.3")
}