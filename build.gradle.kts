import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "2.0.21"
    id("org.jetbrains.intellij.platform") version "2.1.0"
}

group = "io.codetoil"
version = "0.1.1"

// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellijPlatform {
    pluginConfiguration {
        id = "unofficial-swift-plugin"
        name = "Unofficial Swift Plugin"
        version = "0.1.1"

        ideaVersion {
            sinceBuild = "243"
            untilBuild = "243.*"
        }

        vendor {
            name = "Codetoil"
            email = "ianthisawesomee@gmail.com"
            url = "https://www.codetoil.io"
        }
    }

    publishing {
        token = System.getenv("PUBLISH_TOKEN")
    }

    signing {
        privateKey = System.getenv("PRIVATE_KEY")
        password = System.getenv("PRIVATE_KEY_PASSWORD")
        certificateChain = System.getenv("CERTIFICATE_CHAIN")
    }
}

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        clion( "2024.3.1.1")

        pluginVerifier()
        zipSigner()
        instrumentationTools()
    }
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
}
