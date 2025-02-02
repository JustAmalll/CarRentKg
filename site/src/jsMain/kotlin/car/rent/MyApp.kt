package car.rent

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.core.App
import com.varabyte.kobweb.silk.SilkApp
import com.varabyte.kobweb.silk.components.layout.Surface
import com.varabyte.kobweb.silk.init.InitSilk
import com.varabyte.kobweb.silk.init.InitSilkContext
import com.varabyte.kobweb.silk.init.registerStyleBase
import kotlinx.browser.document
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh
import org.w3c.dom.HTMLIFrameElement

@InitSilk
fun updateTheme(ctx: InitSilkContext) {
    ctx.stylesheet.registerStyleBase("body") {
        Modifier
            .fontFamily("Geometria")
            .fontSize(16.px)
            .backgroundColor(Color.black)
    }
}

@App
@Composable
fun MyApp(content: @Composable () -> Unit) {
    SilkApp {
        LaunchedEffect(true) {
            val noscript = document.createElement("noscript")
            val iframe = document.createElement("iframe") as HTMLIFrameElement

            iframe.src = "https://www.googletagmanager.com/ns.html?id=GTM-KS945LF7"
            iframe.height = "0"
            iframe.width = "0"
            iframe.style.display = "none"
            iframe.style.visibility = "hidden"

            noscript.appendChild(iframe)
            document.body?.insertAdjacentElement("afterbegin", noscript)
        }

        Surface(
            modifier = Modifier
                .minHeight(100.vh)
                .backgroundColor(Color("#161616"))
        ) {
            content()
        }
    }
}