plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlinx-serialization")
}

android {
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        targetSdk = 35
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
        }
        getByName("debug") {
            isMinifyEnabled = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }

    sourceSets {
        getByName("test") {
            java.srcDirs("src\\test\\resources") // Add any custom test source directories
        }
    }

    namespace = "com.gahov.data"
}

dependencies {
    dependencies {
        implementation(project(":domain"))

        implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

        implementation("org.jetbrains.kotlin:kotlin-stdlib:2.1.10")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.10.1")

        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.8.7")

        implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.9")
        implementation("com.squareup.okhttp3:okhttp:4.12.0")
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.google.code.gson:gson:2.11.0")

        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
        implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

        implementation("com.google.dagger:hilt-android:2.55")
        kapt("com.google.dagger:hilt-android-compiler:2.55")

        implementation("androidx.room:room-runtime:2.6.1")
        implementation("androidx.room:room-ktx:2.6.1")
        kapt("androidx.room:room-compiler:2.6.1")

        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")
        implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

        androidTestImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test:runner:1.6.2")
        testImplementation("junit:junit:4.13.2")
        testImplementation("com.squareup.okhttp3:mockwebserver3:5.0.0-alpha.9")
        testImplementation("org.mockito:mockito-core:4.8.1")
        testImplementation("org.mockito:mockito-inline:4.8.1")
        testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.10.1")
        testImplementation("com.google.truth:truth:1.1.3")
    }
}