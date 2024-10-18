plugins {
    alias(mobilex.plugins.androidLibrary)
    alias(mobilex.plugins.kotlinAndroid)
    id("kotlin-kapt")
    alias(mobilex.plugins.androidHilt)
    `maven-publish`
}

android {
    namespace = Configs.namespace
    compileSdk = Configs.compileSdk

    defaultConfig {
        minSdk = Configs.minSdk
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Configs.javaVersion
        targetCompatibility = Configs.javaVersion
    }
    kotlinOptions {
        jvmTarget = Configs.jvmTarget
    }
    publishing {
        multipleVariants("all") {
            allVariants()
            withSourcesJar()
            withJavadocJar()
        }
    }
}

publishing {
    val ghUsername = System.getenv("GH_USERNAME")
    val ghPassword = System.getenv("GH_TOKEN")
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("${Configs.mavenDomain}/${ghUsername}/finance-navigation")
            credentials {
                username = ghUsername
                password = ghPassword
            }
        }
    }
    publications {
        create<MavenPublication>("mavenAndroid") {
            afterEvaluate {
                from(components["all"])
            }
            groupId = "vn.finance.libs" // Replace with your GitHub username
            artifactId = "navigation"
            version = "1.0.0" // Set your desired version here
        }
    }
}

dependencies {
    implementation(mobilex.bundles.coreAndroidComponents)
    implementation(mobilex.androidxHilt)
    kapt(mobilex.androidxHiltCompiler)

    testImplementation(mobilex.bundles.testComponents)
    androidTestImplementation(mobilex.bundles.androidTestComponents)
}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}