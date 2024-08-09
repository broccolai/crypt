plugins {
    id("java-library")
    id("net.kyori.indra")
    id("net.kyori.indra.checkstyle")
}

group = rootProject.group
version = rootProject.version
description = rootProject.description

indra {
    javaVersions {
        minimumToolchain(21)
        target(8)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    compileOnly(libs.jspecify)
}

java {
    disableAutoTargetJvm()
}

tasks.withType(JavaCompile::class).configureEach {
    options.compilerArgs.add("-Xlint:-processing,-classfile,-serial")
}
