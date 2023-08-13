package com.architectcoders.pinpoint

object Libs {

    object Kotlin {
        private const val version = "1.6.10"

        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"

        object Coroutines {
            private const val version = "1.6.0"

            const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
            const val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:$version"
        }
    }

    object AndroidX {
        private const val core_version = "1.10.1"

        const val androidx_core = "androidx.core:core-ktx:$core_version"

        object Activity {
            private const val version = "1.7.1"

            const val activity = "androidx.activity:activity-compose:$version"
        }

        object Lifecycle {
            private const val version = "2.6.1"

            const val viewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
            const val lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        }

        object Compose {
            private const val ui_version = "1.4.2"
            private const val material_version = "1.1.1"
            private const val navigation_version = "2.5.3"

            const val ui = "androidx.compose.ui:ui:$ui_version"
            const val debug_ui = "androidx.compose.ui:ui-tooling:$ui_version"
            const val ui_tooling = "androidx.compose.ui:ui-tooling-preview:$ui_version"
            const val material = "androidx.compose.material3:material3:$material_version"
            const val navigation = "androidx.navigation:navigation-compose:$navigation_version"
        }

        object Navigation {
            private const val version = "1.0.0"

            const val navigation = "androidx.hilt:hilt-navigation-compose:$version"
        }

        object Room {
            private const val version = "2.4.2"

            const val runtime = "androidx.room:room-runtime:$version"
            const val ktx = "androidx.room:room-ktx:$version"
            const val compiler = "androidx.room:room-compiler:$version"
        }
    }

    object JavaX {
        private const val version = "1"
        const val javax = "javax.inject:javax.inject:$version"
    }

    object Hilt {
        private const val version = "2.44"

        const val android = "com.google.dagger:hilt-android:$version"
        const val compiler = "com.google.dagger:hilt-android-compiler:$version"
        const val buildGradle = "com.google.dagger.hilt.android:$version"
    }

    object OkHttp3 {
        private const val version = "4.9.3"

        const val loginInterceptor = "com.squareup.okhttp3:logging-interceptor:$version"
        const val mockWebServer = "com.squareup.okhttp3:mockwebserver:$version"
    }

    object Retrofit {
        private const val version = "2.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val converterGson = "com.squareup.retrofit2:converter-gson:$version"
    }

    object Coil {
        private const val version = "2.3.0"

        const val coil = "io.coil-kt:coil-compose:$version"
    }
}
