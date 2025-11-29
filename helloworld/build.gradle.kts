plugins {
    kotlin("jvm") version Versions.kotlin
    id("org.jetbrains.compose") version Versions.compose
    application
    id("com.github.gmazzo.buildconfig")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("file://${rootDir}/.m2repo/")
}

dependencies {
    implementation(Versions.library)
    implementation(compose.desktop.currentOs)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(Versions.jvmLevel)
}

application {
    mainClass.set("MainKt")

    buildConfig {
        packageName("me.tetiana.helloworld")  // Це виправить помилку "Unresolved reference: me"
        buildConfigField("int", "LAB_NUMBER", "2") // Вказуємо номер лабораторної
    }
}