package dependencies


object Deps {
  private const val path = "../commonFiles/gradleScript/"
  const val dependency = "./gradleScript/dependencies.gradle"
    val common = "${path}common.gradle"

  object Module {
    val domain = ":domain"
    val data = ":data"
    val cache = ":cache"
    val remote = ":remote"
  }

  object Kotlin {
    val kotlin_stdlib_jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}"
  }

  val javax = "javax.inject:javax.inject:${Version.javaxInject}"



  object AndroidX {
    val fragment = "androidx.fragment:fragment:${Version.androidx}"
    val annotation = "androidx.annotation:annotation:${Version.androidx}"
    val core = "androidx.core:core:${Version.androidx}"
    val constraintlayout = "androidx.constraintlayout:constraintlayout:${Version.androidx_113}"
    val appcompat = "androidx.appcompat:appcompat:${Version.androidx}"
    val support_recyclerview_v7 = "androidx.recyclerview:recyclerview:${Version.recyclerView}"

  }
  object RxJava {
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Version.rxAndroid}"
    val rxjava2 = "io.reactivex.rxjava2:rxjava:${Version.rx}"
    val rxBinding = "com.jakewharton.rxbinding2:rxbinding:${Version.rxBinding}"

  }
  object OkHttp3 {
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Version.retrofit_log}"
    val okHttp3 = "com.squareup.okhttp3:okhttp:3.12.1"
  }

  object Retrofit2 {
    val adapterRxjava2 = "com.squareup.retrofit2:adapter-rxjava2:${Version.retrofit}"
    val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
  }

  object Dagger {
    val dagger2 = "com.google.dagger:dagger:${Version.dagger2}"
    val daggerAndroid = "com.google.dagger:dagger-android:${Version.dagger2}"
    val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Version.dagger2}"
    val processor = "com.google.dagger:dagger-android-processor:${Version.dagger2}"
    val compiler = "com.google.dagger:dagger-compiler:${Version.dagger2}"
  }
  val lifeCycleExtension = "androidx.lifecycle:lifecycle-extensions:2.0.0"
  val work= "androidx.work:work-runtime-ktx:2.3.4"
}