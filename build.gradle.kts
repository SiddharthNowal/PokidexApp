// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
  id("com.android.application") version "8.1.1" apply false
  id("org.jetbrains.kotlin.android") version "1.8.10" apply false
}

buildscript {
  dependencies {
    classpath("com.android.tools.build:gradle:4.2.2")
    classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.30")
    classpath("com.google.dagger:hilt-android-gradle-plugin:2.44")
  }
}