buildscript {
  repositories {
    google()
    jcenter()
    maven {
      url = uri("https://api.mapbox.com/downloads/v2/releases/maven")
      credentials {
        username = "mapbox"
        password = "sk.eyJ1IjoidG9icnVuIiwiYSI6ImNrbnNuNXB0YzA1eTUyeHBkYzRyN2V0ZGkifQ.xTXN75Mi3OiUtiiWV7Rk1w"
      }
      authentication {
        create<BasicAuthentication>("basic")
      }
    }
    maven {
      url = uri("https://plugins.gradle.org/m2/")
    }
  }
  dependencies {
    classpath(Plugins.android)
    classpath(Plugins.kotlin)
    classpath(Plugins.jacoco)
    classpath(Plugins.license)
    classpath(Plugins.androidPublish)
    classpath(Plugins.mapboxAccessToken)
    classpath(Plugins.mapboxSdkRegistry)
  }
}

allprojects {
  repositories {
    google()
    jcenter()
    maven {
      url = uri("https://api.mapbox.com/downloads/v2/releases/maven")
      credentials {
        username = "mapbox"
        password = "sk.eyJ1IjoidG9icnVuIiwiYSI6ImNrbnNuNXB0YzA1eTUyeHBkYzRyN2V0ZGkifQ.xTXN75Mi3OiUtiiWV7Rk1w"
      }
      authentication {
        create<BasicAuthentication>("basic")
      }
    }
    maven {
      url = uri("https://oss.jfrog.org/artifactory/oss-snapshot-local/")
    }
  }
}

plugins {
  id("org.jetbrains.dokka") version Versions.pluginDokka
}
repositories {
  maven(url = "https://dl.bintray.com/kotlin/dokka")
}
tasks.withType<org.jetbrains.dokka.gradle.DokkaTask>().configureEach {
  outputDirectory.set(buildDir.resolve(this.name))
}