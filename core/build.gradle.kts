// Portable Æsc core: agent loop, LLM runtimes, config stores.
// Plain JVM Kotlin so the same code runs in the Android app and natively on Linux (Jetson).
plugins {
    kotlin("jvm") version "2.1.0"
}

repositories { mavenCentral() }

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
    implementation("org.json:json:20240303")
}

kotlin { jvmToolchain(17) }
