plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.example.cryptotrackerapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.cryptotrackerapp"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {

        // Use buildConfigField for BASE_URL you can specify different base URLs for different build types for depug and realse
        //Code Cleanliness , Easier Access through BuildConfig buildConfigField creates a constant field in the BuildConfig class
        // , which you can access anywhere in your code as BuildConfig.BASE_URL.
       // Security and Flexibility for API Keys and URL

        debug {
            buildConfigField("String", "BASE_URL", "\"https://api.coincap.io/v2/\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
                buildConfigField("String", "BASE_URL", "\"https://api.coincap.io/v2/\"")

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
        buildConfig = true
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

//    implementation(libs.androidx.core.ktx)
//    implementation(libs.androidx.lifecycle.runtime.ktx)
//    implementation(libs.androidx.activity.compose)
//    implementation(platform(libs.androidx.compose.bom))
//    implementation(libs.androidx.ui)
//    implementation(libs.androidx.ui.graphics)
//    implementation(libs.androidx.ui.tooling.preview)
//    implementation(libs.androidx.material3)
//    implementation(libs.androidx.credentials)
//    testImplementation(libs.junit)
//    androidTestImplementation(libs.androidx.junit)
//    androidTestImplementation(libs.androidx.espresso.core)
//    androidTestImplementation(platform(libs.androidx.compose.bom))
//    androidTestImplementation(libs.androidx.ui.test.junit4)
//    debugImplementation(libs.androidx.ui.tooling)
//    debugImplementation(libs.androidx.ui.test.manifest)
//
//
////    // koin and ktor
////    implementation(libs.koin.compose)
////    implementation(libs.koin.compose.viewmodel)
////    implementation(libs.koin.compose.viewmodel.navigation)
////    implementation(libs.koin.androidx.compose)
////    implementation(libs.koin.androidx.compose.navigation)
//
//    // Koin for Ktor
//    implementation(libs.ktor.client.core)
//    implementation(libs.ktor.client.okhttp)
//    implementation(libs.ktor.client.core)
//    implementation(libs.kotlinx.coroutines.core)
//
//    implementation(libs.kotlinx.coroutines.android)
//
//    implementation ("com.google.code.gson:gson:2.11.0")
//
//
//
//// Ktor core client
//    implementation("io.ktor:ktor-client-core:3.0.0")
//
//    // CIO engine for Ktor client
//    implementation("io.ktor:ktor-client-cio:2.3.12")
//
//    // Gson support for Ktor client ContentNegotiation
//    implementation("io.ktor:ktor-client-content-negotiation:2.3.12")
//
//    // Gson library for serialization
//    implementation("io.ktor:ktor-serialization-gson:2.3.4")
//
//    implementation("io.ktor:ktor-client-logging:2.3.12")
//
//    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.4") // For JSON serialization support
//
//    // Kotlinx serialization library
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.0")

//    // koin
//    implementation(libs.koin.android)
//    // Java Compatibility
//    implementation(libs.koin.android.compat)
//    // Jetpack WorkManager
//    implementation(libs.koin.androidx.workmanager)
//    // Navigation Graph
//    implementation(libs.koin.androidx.navigation)
//    // App Startup
//    implementation(libs.koin.androidx.startup)
//    implementation ("io.insert-koin:koin-androidx-viewmodel:3.4.0") // ViewModel support


//    // Koin main features for Android
//    implementation(libs.bundles.koin)
//
//    implementation(libs.bundles.ktor)

//    implementation(libs.bundles.koin)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.compose)
    debugImplementation(libs.bundles.compose.debug)

    coreLibraryDesugaring(libs.desugar.jdk.libs)

    implementation(libs.bundles.koin)

    implementation(libs.bundles.ktor)

    testImplementation(libs.junit)

    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)


}