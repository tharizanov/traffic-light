plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.trafficlight"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.trafficlight"
        minSdk = 23
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.kotlinx.coroutines.android)

    // Test dependencies
    implementation(libs.androidx.compose.test.junit)
    implementation(libs.androidx.compose.test.manifest)
    testImplementation(libs.junit)
    testImplementation(libs.mockito.core)
    androidTestImplementation(libs.mockito.android)
}