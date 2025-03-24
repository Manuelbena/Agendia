
import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinKsp)
    alias(libs.plugins.mapsSecret)
    alias(libs.plugins.googleServices)
    alias(libs.plugins.hiltAndroid)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.compose.compiler)
}

android {
    namespace = "com.example.agendia"
    compileSdk = 35

    val localProportiesFile = rootProject.file("local.properties")
    val localProperties = Properties().apply {
        load(FileInputStream(localProportiesFile))
    }


    val googleWebClientId = localProperties.getProperty("GOOGLE_WEBCLIENT_ID")
        ?: throw IllegalArgumentException("GOOGLE_WEBCLIENT_ID not found in local.properties")


    signingConfigs {
        create("release") {
            val keystorePath = localProperties.getProperty("KEYSTORE_PATH") ?: System.getenv("KEYSTORE_PATH")
            val keystorePassword = localProperties.getProperty("KEYSTORE_PASSWORD") ?: System.getenv("KEYSTORE_PASSWORD")
            val keystoreAlias = localProperties.getProperty("KEYSTORE_ALIAS") ?: System.getenv("KEYSTORE_ALIAS")
            val keystoreAliasPassword = localProperties.getProperty("KEYSTORE_ALIAS_PASSWORD") ?: System.getenv("KEYSTORE_ALIAS_PASSWORD")

            keystorePath?.let {
                storeFile = File(it)
            }
            storePassword = keystorePassword
            keyAlias = keystoreAlias
            keyPassword = keystoreAliasPassword
        }
    }

    defaultConfig {
        applicationId = "com.example.agendia"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "GOOGLE_WEBCLIENT_ID", "\"$googleWebClientId\"")
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core
    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(libs.icons.extended)
    implementation(libs.accompanist.permissions)

    // Navigation
    implementation(libs.navigation.compose)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.logging.interceptor)
    implementation(libs.kotlinx.serialization)
    implementation(libs.converter.kotlinx.serialization)

    // Coil
    implementation(libs.coil.compose)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.auth)
    implementation(libs.firebase.remote.config)
    implementation(libs.play.services.auth)
    implementation(libs.credentials)
    implementation(libs.credentials.play.services.auth)
    implementation(libs.identity.googleid)

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.androidx.hilt.compiler)

    //Google Services & Maps
    implementation(libs.play.services.location)
    implementation(libs.maps.compose)
    implementation(libs.play.services.maps)
    implementation(libs.maps.ktx)
    implementation(libs.maps.utils.ktx)

    // Room
    implementation(libs.androidx.room.ktx)
    ksp(libs.room.compiler)
    implementation(libs.androidx.room.runtime)

    // Testing
    testImplementation(libs.junit)
    testImplementation(libs.mockk)
    testImplementation(libs.coroutines.test)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    androidTestImplementation(libs.androidx.core.ktx)
    androidTestImplementation(libs.androidx.rules)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    kspAndroidTest(libs.hilt.compiler)
    kspTest(libs.hilt.compiler)
    testImplementation(libs.hilt.android.testing)
    androidTestImplementation(libs.hilt.android.testing)
}