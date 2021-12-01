import io.kotless.plugin.gradle.dsl.kotless
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.31"
    id("io.kotless") version "0.2.0" apply true
}

group = "com.yt8492"
version = "1.0.0"

repositories {
    mavenCentral()
    maven(url = uri("https://packages.jetbrains.team/maven/p/ktls/maven"))
}

dependencies {
    implementation("io.kotless:ktor-lang:0.2.0")
    implementation("io.kotless:ktor-lang-aws:0.2.0")
    testImplementation(kotlin("test"))
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}

kotless {
    config {
        aws {
            storage {
                bucket = "todo.kotless.bucket"
            }
            profile = "todo.kotless.user"
            region = "ap-northeast-1"
        }
    }
    webapp {
        lambda {
            kotless {
                packages = setOf("com.yt8492.todokotless")
            }
        }
    }
    extensions {
        local {
            useAWSEmulation = true
        }
        terraform {
            allowDestroy = true
        }
    }
}
