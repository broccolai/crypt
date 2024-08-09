plugins {
    id("crypt.base")
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly(libs.paper)
    compileOnly(projects.cryptApi)
}
