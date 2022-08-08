plugins {
    id("com.android.application")
    id(Dependency.pluginKotlinApp)
    id(Dependency.pluginKotlinKapt)
}

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
