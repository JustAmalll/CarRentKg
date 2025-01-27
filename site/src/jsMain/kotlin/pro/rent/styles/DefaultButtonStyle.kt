package pro.rent.styles

import com.varabyte.kobweb.compose.css.BoxShadow
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.silk.style.CssStyle
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

val DefaultButtonStyle = CssStyle {
    base {
        Modifier
            .color(Color.white)
            .backgroundColor(Color("#484848"))
            .cursor(Cursor.Pointer)
            .boxShadow(
                BoxShadow.of(
                    offsetX = 2.px,
                    offsetY = 2.px,
                    blurRadius = 6.px,
                    color = rgba(0, 0, 0, 0.25)
                )
            )
    }
}