import Dependency.appcompat
import Dependency.coreKtx

plugins {
    id("com.android.application")
    id(Dependency.pluginKotlinApp)
    id(Dependency.pluginkotlinParcelize)
}

/*apply {
    plugin(Dependency.pluginKotlinApp)
    plugin(Dependency.pluginKotlinKapt)
}*/

repositories {
    google()
    jcenter()
    mavenCentral()
    maven(url = "https://www.jitpack.io")
}

android {

    signingConfigs {
        getByName("debug") {
           /* val properties =
                org.jetbrains.kotlin.konan.properties.loadProperties(project.rootProject.file("local.properties").path)
            storeFile = file("../gradle/keystoreboreal.jks")
            storePassword = properties.getProperty("STORE_PASSWORD")
            keyAlias = properties.getProperty("KEY_ALIAS")
            keyPassword = properties.getProperty("KEY_PASSWORD")*/
        }
        create("release") {
           /* val properties =
                org.jetbrains.kotlin.konan.properties.loadProperties(project.rootProject.file("local.properties").path)
            storeFile = file("../gradle/keystoreboreal.jks")
            storePassword = properties.getProperty("STORE_PASSWORD")
            keyPassword = properties.getProperty("KEY_PASSWORD")
            keyAlias = properties.getProperty("KEY_ALIAS")*/
        }
    }

    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        applicationId = AndroidConfig.appId
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        signingConfig = signingConfigs.getByName("release")
        testInstrumentationRunner = AndroidConfig.testRunner
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = true
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


dependencies {

    //Implements
    implementation(project(":commonutils"))
    implementation(project(":library:core"))
    implementation(project(":features:home"))
    implementation(project(":features:login"))
    implementation(project(":features:signin"))
    implementation(project(":library:ui-system"))

    //Dependencies gradle app
    api(coreKtx)
    api(appcompat)
    testImplementation(Dependency.testJunit)
    androidTestImplementation(Dependency.testTruth)
    androidTestImplementation(Dependency.testAndroidRules)
    androidTestImplementation(Dependency.testAndroidJunit)
    androidTestImplementation(Dependency.testAndroidRunner)
    androidTestImplementation(Dependency.testAndroidJEspressoCore)

    //NAV-COMPONENT
    Dependency.apply {
        implementation(navigationUIKtx)
        implementation(navigationFragmentKtx)
    }

    //DESIGN
    api(Dependency.constraintlayout)
    implementation(Dependency.materialDesign)
}
