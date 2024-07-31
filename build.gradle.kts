plugins {
    kotlin("jvm") version "1.9.24"
    application
    java
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "com.ramoplayz"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.4-R0.1-SNAPSHOT")
    implementation("dev.dejvokep:boosted-yaml:1.3")
}

tasks {
    shadowJar {
        relocate("dev.dejvokep.boostedyaml'", "com.ramoplayz.libs")
    }
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}