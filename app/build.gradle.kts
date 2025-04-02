plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" // 确保版本与你的 Kotlin 版本兼容 // 如果你使用 KSP，添加这一行
}

android {
    namespace = "com.sunnyweather.android"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.sunnyweather.android"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    val work_version = "2.10.0" // 使用最新的稳定版本
    implementation("androidx.work:work-runtime-ktx:$work_version")  // 使用 Kotlin 扩展

    val room_version = "2.6.1" // 使用最新的稳定版本
    implementation("androidx.room:room-runtime:$room_version")
    // 仅当项目包含 Kotlin 源代码时才使用 KSP
    ksp("androidx.room:room-compiler:$room_version")
    // 可选 - Kotlin 扩展和协程支持
    implementation("androidx.room:room-ktx:$room_version")

    val lifecycle_version = "2.8.7" // 使用最新的稳定版本
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // 也可以添加 ViewModel utilities for Compose，如果你使用 Compose 的话
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    // 还可以添加 Saved State module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")

    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("com.google.code.gson:gson:2.8.6")
    implementation("com.squareup.okhttp3:okhttp:4.9.3")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}