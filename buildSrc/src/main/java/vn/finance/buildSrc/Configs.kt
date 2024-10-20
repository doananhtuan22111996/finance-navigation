import org.gradle.api.JavaVersion

object Configs {
    const val namespace = "vn.finance.navigation"
    const val minSdk = 24
    const val compileSdk = 34
    val jvmTarget = JavaVersion.VERSION_21.toString()
    val javaVersion = JavaVersion.VERSION_21
    const val mavenDomain = "https://maven.pkg.github.com"

    object Artifact {
        const val groupId = "vn.finance.libs"
        const val artifactId = "navigation"
        const val version = "1.0.1"
    }
}
