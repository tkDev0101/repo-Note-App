plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")
}

android {
    namespace = "com.example.note_app_realtime_database"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.note_app_realtime_database"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        viewBinding = true
    }

}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")



    // FirebaseUI for Realtime Database
    implementation("com.firebaseui:firebase-ui-database:8.0.0")

    // FirebaseUI for Firebase Auth
    implementation("com.firebaseui:firebase-ui-auth:8.0.0")

    // FirebaseUI for Cloud Storage
    implementation("com.firebaseui:firebase-ui-storage:8.0.0")

    // Firebase BoM (Bill of Materials)
    implementation("com.google.firebase:firebase-bom:29.0.4")

    // Firebase Authentication library (ktx version)
    implementation("com.google.firebase:firebase-auth-ktx:21.0.0")

    // Firebase Realtime Database
    implementation("com.google.firebase:firebase-database:21.0.0")

    // Firebase Cloud Storage
    implementation("com.google.firebase:firebase-storage:21.0.0")

    // Firebase Firestore
    implementation("com.google.firebase:firebase-firestore:25.0.0") // Update version

    // Declare the dependency for the Google Play services library and specify its version
    implementation("com.google.android.gms:play-services-auth:20.0.1")

    // For Kotlin coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.1.1")







    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

/*
original dependencies

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")


///*

    // FirebaseUI for Realtime Database
    implementation("com.firebaseui:firebase-ui-database:8.0.0")

    // FirebaseUI for Firebase Auth
    implementation("com.firebaseui:firebase-ui-auth:8.0.0")

    // FirebaseUI for Cloud Storage
    implementation("com.firebaseui:firebase-ui-storage:8.0.0")

    // For Firebase Authentication and user
    // Firebase BoM (Bill of Materials)
    implementation("com.google.firebase:firebase-bom:29.0.4")

    // Firebase Authentication library
    implementation("com.google.firebase:firebase-auth-ktx")

    // Firebase Realtime Database
    implementation("com.google.firebase:firebase-database:21.0.0")

    // Firebase Cloud Storage
    implementation("com.google.firebase:firebase-storage:21.0.0")


    // Declare the dependency for the Google Play services library and specify its version
    implementation("com.google.android.gms:play-services-auth:20.0.1")


    // For Kotlin coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.1.1")
    implementation("com.google.firebase:firebase-auth:23.0.0")
    implementation("com.google.firebase:firebase-firestore:25.0.0")

//*/



























    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}

*/


