plugins {
    id("crypt.base")
    alias(libs.plugins.run.paper)
    alias(libs.plugins.shadow)
}

repositories {
    sonatype.ossSnapshots()
    maven("https://repo.papermc.io/repository/maven-public/")
}

val runServerJars by configurations.creating {
    isTransitive = false
}

dependencies {
    compileOnly(libs.paper)
    // don't shade in your plugin
    implementation(projects.cryptApi)
    implementation(libs.cloud.paper)

    runServerJars(projects.cryptBukkit)
    runServerJars(projects.cryptExamplesProvider)
}

tasks {
    runServer {
        minecraftVersion("1.21")

        pluginJars.from(runServerJars)
    }
}

indra {
    javaVersions {
        target(21)
    }
}
