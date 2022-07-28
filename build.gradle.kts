buildscript {
    repositories {
        google()
        jcenter()
        mavenCentral()
        maven (url ="https://www.jitpack.io")
    }
    dependencies {
        classpath(Dependency.classPathBuildTools)
        classpath(Dependency.classPathPluginKotlin)
        classpath(Dependency.classpathSaveArguments)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}