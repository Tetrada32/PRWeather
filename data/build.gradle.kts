plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("kotlinx-serialization")
}

android {
    compileSdk = 33

    defaultConfig {
        minSdk = 24
        targetSdk = 33
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
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
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

        coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.3")

        implementation("org.jetbrains.kotlin:kotlin-stdlib:1.9.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.6.4")

        implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")

        implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.9")
        implementation("com.squareup.okhttp3:okhttp:4.10.0")
        implementation("com.squareup.retrofit2:retrofit:2.9.0")
        implementation("com.squareup.retrofit2:converter-gson:2.9.0")
        implementation("com.google.code.gson:gson:2.9.0")

        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
        implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

        implementation("com.google.dagger:hilt-android:2.47")
        kapt("com.google.dagger:hilt-android-compiler:2.47")

        implementation("androidx.room:room-runtime:2.5.2")
        implementation("androidx.room:room-ktx:2.5.2")
        kapt("androidx.room:room-compiler:2.5.2")

        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
        implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:0.8.0")

        androidTestImplementation("junit:junit:4.13.2")
        androidTestImplementation("androidx.test:runner:1.5.2")
        testImplementation("junit:junit:4.13.2")
        testImplementation("com.squareup.okhttp3:mockwebserver3:5.0.0-alpha.9")
        testImplementation("org.mockito:mockito-core:4.8.1")
        testImplementation("org.mockito:mockito-inline:4.8.1")
        testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
        testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
        testImplementation("com.google.truth:truth:1.1.3")
    }
}