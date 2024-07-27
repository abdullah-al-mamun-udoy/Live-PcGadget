plugins {
    with(libs.plugins) {
        alias(com.android.application)
        alias(org.jetbrains.kotlin.android)
    }
}

android {
    namespace = "com.pcgadget"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.pcgadget"
        minSdk = 24
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar", "*.aar", "*.so"))))
    implementation(project(":network"))
    with(libs) {

        implementation(androidx.core.ktx)
        implementation(splashscreen)
        implementation(androidx.lifecycle.runtime.ktx)
        implementation(androidx.activity.compose)
        implementation(platform(androidx.compose.bom))
        implementation(androidx.ui)
        implementation(androidx.ui.graphics)
        implementation(androidx.ui.tooling.preview)
        implementation(androidx.material3)
        testImplementation(junit)
        androidTestImplementation(androidx.junit)
        androidTestImplementation(androidx.espresso.core)
        androidTestImplementation(platform(androidx.compose.bom))
        androidTestImplementation(androidx.ui.test.junit4)
        debugImplementation(androidx.ui.tooling)
        debugImplementation(androidx.ui.test.manifest)
    }
}