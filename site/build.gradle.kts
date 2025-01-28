import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.script

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.serialization.plugin)
}

group = "car.rent"
version = "1.0.0"

kobweb {
    app {
        index {
            description.set("Широкий выбор автомобилей: эконом, комфорт, кроссоверы. Прозрачные условия аренды, без скрытых платежей. Быстрое оформление и поддержка 24/7. Забронируйте авто онлайн или по телефону +996 (772) 33-05-07.")

            head.add {
                link(rel = "stylesheet", href = "/fonts/faces.css")

                script {
                    src = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                }
                link {
                    rel = "stylesheet"
                    href = "https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
                }
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("CarRentKg", includeServer = false)

    sourceSets {
        commonMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.kotlinx.serialization)
        }
        jsMain.dependencies {
            implementation(libs.compose.runtime)
            implementation(libs.compose.html.core)
            implementation(libs.kobweb.core)
            implementation(libs.kobweb.silk)
            implementation(libs.silk.icons.fa)
            implementation(libs.kotlinx.serialization)

            implementation("net.thauvin.erik.urlencoder:urlencoder-lib:1.6.0")
        }
    }
}
