enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("gradle/build-logic")
}

rootProject.name = "crypt-parent"

subproject("api")
subproject("bukkit")

subproject("examples/provider")
subproject("examples/user")

fun subproject(moduleName: String) {
    val name = "crypt-${moduleName.replace('/', '-')}"
    include(name)
    val proj = project(":$name")
    proj.projectDir = file(moduleName)
}
