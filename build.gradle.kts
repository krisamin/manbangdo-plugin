plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("kapt") version "2.1.0"
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

//sourceSets {
//    main {
//        java {
//            srcDirs("src/main/kotlin")
//        }
//    }
//}

group = "kr.isamin"
version = "0.0.1"

repositories {
    mavenCentral()

    maven {
        name = "maven-snapshots"
        url = uri("https://maven.reposilite.com/snapshots")
    }
    maven {
        name = "papermc-repo"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "sonatype"
        url = uri("https://oss.sonatype.org/content/groups/public/")
    }
}

val exposedVersion: String by project
val javalinVersion: String by project
dependencies {
    compileOnly("io.papermc.paper", "paper-api", "1.21.4-R0.1-SNAPSHOT")

    implementation("org.jetbrains.kotlin", "kotlin-stdlib-jdk8")

    implementation("net.dv8tion", "JDA", "5.2.2")

    implementation("io.javalin", "javalin", javalinVersion)
    implementation("io.javalin", "javalin-bundle", javalinVersion)
    implementation("io.javalin.community.openapi", "javalin-openapi-plugin", javalinVersion)
    implementation("io.javalin.community.openapi", "javalin-swagger-plugin", javalinVersion)
    implementation("io.javalin.community.openapi", "javalin-redoc-plugin", javalinVersion)
    annotationProcessor("io.javalin.community.openapi", "openapi-annotation-processor", javalinVersion)
    kapt("io.javalin.community.openapi", "openapi-annotation-processor", javalinVersion)

    implementation("org.jetbrains.exposed", "exposed-core", exposedVersion)
    implementation("org.jetbrains.exposed", "exposed-crypt", exposedVersion)
    implementation("org.jetbrains.exposed", "exposed-dao", exposedVersion)
    implementation("org.jetbrains.exposed", "exposed-jdbc", exposedVersion)

    implementation("org.jetbrains.exposed", "exposed-jodatime", exposedVersion)

    implementation("org.jetbrains.exposed", "exposed-json", exposedVersion)
    implementation("org.jetbrains.exposed", "exposed-money", exposedVersion)

    implementation("org.postgresql", "postgresql", "42.7.4")
    implementation("com.zaxxer", "HikariCP", "6.2.1")

    implementation("redis.clients", "jedis", "5.2.0")

    implementation("com.squareup.okhttp3", "okhttp", "3.2.0")

    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin", "2.18.2")
    implementation("com.fasterxml.jackson.core", "jackson-core", "2.18.2")
    implementation("com.fasterxml.jackson.core", "jackson-databind", "2.18.2")

    implementation("com.auth0", "java-jwt", "4.4.0")
}

val targetJavaVersion = 21
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks.build {
    dependsOn("shadowJar")
}

tasks.processResources {
    val props = mapOf("version" to version)
    inputs.properties(props)
    filteringCharset = "UTF-8"
    filesMatching("plugin.yml") {
        expand(props)
    }
}

//tasks.withType<JavaCompile>().configureEach {
//    options.annotationProcessorPath = configurations.annotationProcessor.get()
//}