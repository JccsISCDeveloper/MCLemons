plugins {
    id(Dependency.pluginLibrary)
    id(Dependency.pluginKotlinApp)
    id(Dependency.pluginKotlinKapt)
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk

        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        dataBinding = true
    }
}
repositories {
    google()
    jcenter()
    mavenCentral()
    maven(url = "https://www.jitpack.io")
}
dependencies {
    //Implements
    implementation(project(":commonutils"))

    //Dependencies gradle app
  Dependency.apply {
        api(coreKtx)
        api(appcompat)
        testImplementation(testJunit)
        androidTestImplementation(testTruth)
        androidTestImplementation(testAndroidRules)
        androidTestImplementation(testAndroidJunit)
        androidTestImplementation(testAndroidRunner)
        androidTestImplementation(testAndroidJEspressoCore)
    }

    
}
