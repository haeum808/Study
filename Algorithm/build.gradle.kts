plugins {
    kotlin("jvm") version "2.0.0"
}

group = "org.learning_concurrency_in_kotlin.haeum"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}