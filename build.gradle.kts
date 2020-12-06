plugins {
    kotlin("jvm") version "1.4.20"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

val assertkJvmVersion: String by project
val junitJupiterVersion: String by project

subprojects {

    apply(plugin = "org.jetbrains.kotlin.jvm")

    dependencies {
        // Align versions of all Kotlin components
        implementation(enforcedPlatform(kotlin("bom")))

        // Use the Kotlin JDK 8 standard library.
        implementation(kotlin("stdlib-jdk8"))

        // Use the Kotlin test library.
        //testImplementation(kotlin("test"))

        // Use the Kotlin JUnit integration.
        //testImplementation(kotlin("test-junit"))

        testImplementation("com.willowtreeapps.assertk:assertk-jvm:$assertkJvmVersion")
        testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiterVersion")
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

}

