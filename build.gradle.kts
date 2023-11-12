plugins {
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
    id("eclipse")
}

repositories {
    mavenCentral()
}

dependencies {
}

javafx {
    version = "21.0.1"
    modules("javafx.controls", "javafx.fxml")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("oberflache.Start")
}
