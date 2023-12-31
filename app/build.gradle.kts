plugins {
  id("com.android.application")
  id("org.jetbrains.kotlin.android")
  kotlin("kapt")
  id("dagger.hilt.android.plugin")
  id("com.google.gms.google-services")
}

android {
  namespace = "com.myprojects.pokidexiapp"
  compileSdk = 34

  defaultConfig {
    applicationId = "com.myprojects.pokidexiapp"
    minSdk = 24
    targetSdk = 33
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
      proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
    }
  }
  compileOptions {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
  }
  kotlinOptions {
    jvmTarget = "17"
  }
  buildFeatures {
    compose = true
    buildConfig = true
  }
  composeOptions {
    kotlinCompilerExtensionVersion = "1.4.3"
  }
  packaging {
    resources {
      excludes += "/META-INF/{AL2.0,LGPL2.1}"
    }
  }
}

dependencies {
  implementation("androidx.core:core-ktx:1.12.0")
  implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
  implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
  implementation("androidx.activity:activity-compose:1.7.2")
  implementation(platform("androidx.compose:compose-bom:2023.03.00"))
  implementation("androidx.compose.ui:ui")
  implementation("androidx.compose.ui:ui-graphics")
  implementation("androidx.compose.ui:ui-tooling-preview")
  implementation("androidx.compose.material3:material3")
  testImplementation("junit:junit:4.13.2")
  androidTestImplementation("androidx.test.ext:junit:1.1.5")
  androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
  androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
  androidTestImplementation("androidx.compose.ui:ui-test-junit4")
  debugImplementation("androidx.compose.ui:ui-tooling")
  debugImplementation("androidx.compose.ui:ui-test-manifest")

  debugImplementation("androidx.compose.ui:ui-tooling:1.5.1")
  implementation("androidx.compose.ui:ui-tooling-preview:1.5.1")

  implementation("com.google.code.gson:gson:2.9.1")

  // Retrofit Dependencies
  implementation("com.squareup.retrofit2:retrofit:2.9.0")
  implementation("com.squareup.retrofit2:converter-gson:2.9.0")
  implementation("com.squareup.okhttp3:okhttp:4.11.0")
  implementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
  implementation("com.jakewharton.retrofit:retrofit2-rxjava2-adapter:1.0.0")

  // Dagger Hilt Dependencies
  implementation("com.google.dagger:hilt-android:2.44")
  kapt("com.google.dagger:hilt-android-compiler:2.44")
  kapt("androidx.hilt:hilt-compiler:1.0.0")
  implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

  // RxJava Dependencies
  implementation("io.reactivex.rxjava2:rxjava:2.2.19")
  implementation("io.reactivex.rxjava2:rxandroid:2.1.1")

  // Navigation Compose
  implementation("androidx.navigation:navigation-compose:2.7.3")

  // Firebase Authentication
  implementation(platform("com.google.firebase:firebase-bom:32.2.3"))
  implementation("com.google.firebase:firebase-auth-ktx:22.1.2")
  implementation("com.google.android.gms:play-services-auth:20.7.0")

  // Constraint Layout in Compose
  implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")

  // Coil Image Loading Compose
  implementation("io.coil-kt:coil-compose:2.4.0")

  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")

}