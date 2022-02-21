plugins {
    kotlin("jvm") version "1.6.10"
    java
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")

    testImplementation ("org.amshove.kluent:kluent:1.68")

    testImplementation("org.spekframework.spek2:spek-dsl-jvm:2.0.17")
    testRuntimeOnly("org.spekframework.spek2:spek-runner-junit5:2.0.17")
    testRuntimeOnly("org.jetbrains.kotlin:kotlin-reflect:1.6.10")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.2")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
    finalizedBy("testReportExam")
}

tasks.register<TestReportExam>("testReportExam")