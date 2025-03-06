buildscript {
    val kotlinVersion by extra("2.1.10")

    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.9.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
        classpath("org.jetbrains.kotlin:kotlin-serialization:$kotlinVersion")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.8.8")
    }
}

plugins {
    id("com.google.dagger.hilt.android") version "2.55" apply false
    id("org.jetbrains.kotlin.android") version "2.1.10" apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
