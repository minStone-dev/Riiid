import org.gradle.api.JavaVersion

object ProjectProperties {

    object Versions{
        const val BUILD_GRADLE = "4.2.1"
        const val COMPILE_SDK_VERSION = 34
        const val BUILD_TOOLS_VERSION = "32.0.0"
        const val MIN_SDK_VERSION = 26
        const val TARGET_SDK_VERSION = 34
        const val VERSION_CODE = 1
        const val VERSION_NAME = "1.0"

        val JAVA_VERSION = JavaVersion.VERSION_17
        val JVM_TARGET = JavaVersion.VERSION_17.toString()
    }

    object Gradle {
        const val APPLICATION = "com.android.application"
        const val LIBRARY = "com.android.library"
        const val KOTLIN = "org.jetbrains.kotlin.android"
        const val HILT = "com.google.dagger.hilt.android"
        const val KAPT = "kapt"
        const val GMS_GOOGLE_SERVICE = "com.google.gms.google-services"

        const val DI = "com.minstone.riiid"
        const val DATA = "com.minstone.data"
        const val DOMAIN = "com.minstone.domain"
        const val PERSENTATION = "com.minstone.presentation"
    }

    object Files {
        const val CONSUMER_PROGUARDFILES = "consumer-rules.pro"
        const val DEFAULT_PROGUARDFILES = "proguard-android-optimize.txt"
        const val PROGUARDFILES = "proguard-rules.pro"
    }

    object TestProperties {
        const val TEST_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    }

}