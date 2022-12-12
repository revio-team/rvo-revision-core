import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
	id("org.springframework.boot") version "2.7.1"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.sofia"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {

	implementation("org.springframework.cloud:spring-cloud-starter-openfeign:3.1.4")
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-actuator:2.7.5")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb:2.7.5")
	implementation("org.springframework.boot:spring-boot-starter-validation:2.7.5")
	implementation("org.springframework.boot:spring-boot-starter-web:2.7.5")
	implementation("org.passay:passay:1.6.2")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	testImplementation("org.springframework.boot:spring-boot-starter-test")

}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
tasks.getByName<Jar>("jar") {
	enabled = false
}
tasks.withType<Test> {
	useJUnitPlatform()
}
