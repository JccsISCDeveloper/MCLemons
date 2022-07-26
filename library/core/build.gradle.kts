plugins {
    id(Dependency.pluginLibrary)
    id(Dependency.pluginKotlinApp)
    id(Dependency.pluginKotlinKapt)
    id("org.jetbrains.kotlin.android")
}

repositories {
    google()
    jcenter()
    mavenCentral()
    maven(url = "https://www.jitpack.io")
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
        val properties =
            org.jetbrains.kotlin.konan.properties.loadProperties(project.rootProject.file("local.properties").path)
        getByName("debug") {
            isMinifyEnabled = false
            /*buildConfigField(type = "String", name = "ENVIRONMENT_ABSOLUTE", value = "\"DEBUG\"")
            buildConfigField(type = "String", name = "ENVIRONMENT", value = "\"DEBUG/\"")
            buildConfigField(
                type = "String",
                name = "CONEKTA_PUBLIC_KEY",
                value = "\"${properties.getProperty("CONEKTA_DEBUG_PUBLIC_KEY")}\""
            )
            buildConfigField(
                type = "String",
                name = "MAPS_API_KEY",
                value = "\"${properties.getProperty("GOOGLE_MAPS_KEY")}\""
            )
            buildConfigField(
                type = "String",
                name = "DEFAULT_EMAIL",
                value = "\"administrator@borealnetwork.org/\""
            )//obtener desde RemoteConfig
            buildConfigField(type = "String", name = "EVENTS", value = "\"/Events\"")
            buildConfigField(type = "String", name = "TICKETS", value = "\"Tickets\"")
            buildConfigField(
                type = "String",
                name = "BASE_URL",
                value = "\"https://us-central1-borealpuertocorazon.cloudfunctions.net/\""
            )//obtener desde RemoteConfig
            buildConfigField(
                type = "String",
                name = "VERSION_NAME",
                value = "\"AndroidConfig.versionName\""
            )*/
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
        getByName("release") {
            isMinifyEnabled = false
           /* buildConfigField(type = "String", name = "ENVIRONMENT", value = "\"RELEASE/\"")
            buildConfigField(
                type = "String",
                name = "CONEKTA_PUBLIC_KEY",
                value = "\"${properties.getProperty("CONEKTA_RELEASE_PUBLIC_KEY")}\""
            )
            buildConfigField(
                type = "String",
                name = "MAPS_API_KEY",
                value = "\"${properties.getProperty("GOOGLE_MAPS_KEY")}\""
            )
            buildConfigField(
                type = "String",
                name = "DEFAULT_EMAIL",
                value = "\"administrator@borealnetwork.org/\""
            )//obtener desde RemoteConfig
            buildConfigField(
                type = "String",
                name = "BASE_URL",
                value = "\"https://us-central1-borealpuertocorazon.cloudfunctions.net/\""
            )//obtener desde RemoteConfig
            buildConfigField(type = "String", name = "EVENTS", value = "\"/Events\"")
            buildConfigField(type = "String", name = "TICKETS", value = "\"Tickets\"")
            buildConfigField(
                type = "String",
                name = "VERSION_NAME",
                value = "\"AndroidConfig.versionName\""
            )*/
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

}