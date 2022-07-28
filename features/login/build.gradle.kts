plugins {
    id(Dependency.pluginLibrary)
    id(Dependency.pluginKotlinApp)
    id(Dependency.pluginKotlinKapt)
    id(Dependency.pluginkotlinParcelize)
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

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
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
    implementation(project(":library:core"))
    implementation(project(":library:ui-system"))

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

    //NAV-COMPONENT
    Dependency.apply {
        implementation(navigationUIKtx)
        implementation(navigationFragmentKtx)
    }

    //DESIGN
    Dependency.apply {
        api(constraintlayout)
        implementation(materialDesign)
    }
}