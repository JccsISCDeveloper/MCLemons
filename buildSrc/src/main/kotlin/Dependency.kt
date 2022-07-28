object Dependency {

    //Plugins
    const val pluginKotlinKapt = "kotlin-kapt"
    const val pluginKotlinApp = "kotlin-android"
    const val pluginLibrary = "com.android.library"
    const val pluginkotlinParcelize = "kotlin-parcelize"
    const val pluginJetbrains = "org.jetbrains.kotlin.android"
    const val pluginSafeArguments = "androidx.navigation.safeargs.kotlin"

    //Classpath dependencies
    const val classPathBuildTools = "com.android.tools.build:gradle:${Version.buildToolsVersion}"
    const val classPathPluginKotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlinVersion}"
    const val classpathSaveArguments = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.saveArgumentsVersion}"

    //Dependencies gradle app
    const val coreKtx = "androidx.core:core-ktx:${Version.coreKtxVersionVersion}"
    const val appcompat = "androidx.appcompat:appcompat:${Version.appcompatVersion}"
    const val testAndroidJunit = "androidx.test.ext:junit:${Version.androidJunitVersion}"
    const val testAndroidJEspressoCore = "androidx.test.espresso:espresso-core:${Version.espressoCoreVersion}"

    const val testJunit = "junit:junit:${Version.jUnitVersion}"
    const val testTruth = "com.google.truth:truth:${Version.testTruthVersion}"
    const val testAndroidRules = "androidx.test:rules:${Version.testAndroidRulesVersion}"
    const val testAndroidRunner = "androidx.test:runner:${Version.testAndroidRunnerVersion}"

    //NAV-COMPONENT
    const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:${Version.navUIKtxVersion}"
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Version.navFragmentKtxVersion}"

    //MVVM
    const val liveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.liveDataVersion}"
    const val lifeCicle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.lifeCycleVersion}"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.viewModelVersion}"

    //COROUTINES
    const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutinesVersion}"

    //ROOM
    const val room = "androidx.room:room-ktx:${Version.roomVersion}"
    const val roomRuntime = "ndroidx.room:room-runtime:${Version.roomRuntimeVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Version.roomCompilerVersion}"

    //DESIGN
    const val lottie = "com.airbnb.android:lottie:${Version.lottieVersion}"
    const val glide = "com.github.bumptech.glide:glide:${Version.glideVersion}"
    const val shimmer = "com.facebook.shimmer:shimmer:${Version.shimmerVersion}"
    const val circleImage = "de.hdodenhof:circleimageview:${Version.circleImageVersion}"
    const val materialDesign = "com.google.android.material:material:${Version.materialVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Version.glideCompilerVersion}"
    const val roundableLayout = "com.github.zladnrms:RoundableLayout:${Version.roundableLayoutVersion}"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:${Version.constraintlayoutVersion}"



}
