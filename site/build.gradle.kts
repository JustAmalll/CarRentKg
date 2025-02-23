import com.varabyte.kobweb.gradle.application.util.configAsKobwebApplication
import kotlinx.html.link
import kotlinx.html.meta
import kotlinx.html.script

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.kobweb.application)
    alias(libs.plugins.serialization.plugin)
}

group = "car.rent"
version = "1.0.3"

kobweb {
    app {
        index {
            description.set("Широкий выбор автомобилей: эконом, комфорт, кроссоверы. Прозрачные условия аренды, без скрытых платежей. Быстрое оформление и поддержка 24/7. Забронируйте авто онлайн или по телефону +996 (772) 33-05-07.")

            head.add {
                link(rel = "icon", type = "image/png", href = "/favicon/favicon-96x96.png") {
                    sizes = "96x96"
                }
                link(rel = "icon", type = "image/svg+xml", href = "/favicon/favicon.svg")
                link(rel = "shortcut icon", type = "image/svg+xml", href = "/favicon/favicon.ico")
                link(
                    rel = "apple-touch-icon",
                    type = "image/png",
                    href = "/favicon/apple-touch-icon.png"
                ) {
                    sizes = "180x180"
                }
                meta(name = "apple-mobile-web-app-title", content = "CarRent")
                meta(name = "version", content = "1.0.3")
                link(rel = "manifest", href = "/favicon/site.webmanifest")

                script(src = "/gtm.js") {}
                link(rel = "stylesheet", href = "/fonts/faces.css")
            }
        }
    }
}

kotlin {
    configAsKobwebApplication("CarRentKg", includeServer = false)

    sourceSets {
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
