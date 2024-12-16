plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "jimenez.fernandez.manueljesus.pmdmtarea2"
    compileSdk = 34

    defaultConfig {
        applicationId = "jimenez.fernandez.manueljesus.pmdmtarea2"
        minSdk = 31
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
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

}

dependencies {
    implementation(libs.drawerlayout)
    dependencies {
        implementation (libs.drawerlayout.v111)
        implementation (libs.material.v1110)
        implementation (libs.glide)
        implementation(libs.core.splashscreen)
        implementation(libs.recyclerview)
        implementation(libs.cardview)
        implementation (libs.picasso)
        implementation (libs.navigation.fragment.ktx)
        implementation (libs.navigation.ui.ktx)

        implementation(libs.appcompat)
        implementation(libs.material)
        implementation(libs.activity)
        implementation(libs.constraintlayout)
        testImplementation(libs.junit)
        androidTestImplementation(libs.ext.junit)
        androidTestImplementation(libs.espresso.core)
    }
}