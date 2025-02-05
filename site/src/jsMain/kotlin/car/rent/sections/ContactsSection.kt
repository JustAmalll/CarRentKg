package car.rent.sections

import androidx.compose.runtime.Composable
import car.rent.Constants.PHONE_NUMBER
import car.rent.Constants.PHONE_NUMBER_FORMATTED
import car.rent.components.SectionHeader
import car.rent.navigation.Section
import car.rent.styles.DefaultButtonStyle

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import kotlinx.browser.window
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Composable
fun ContactsSection() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .id(Section.Contacts.id)
            .margin(top = 60.px, bottom = 60.px)
            .padding(top = 40.px)
    ) {
        SectionHeader(
            title = "Контакты",
            subtitle = "CONTACTS",
            longText = "Мы всегда рады видеть вас! У нас вы можете быстро и комфортно оформить все необходимое для аренды автомобиля."
        )
        Link(
            text = PHONE_NUMBER_FORMATTED,
            modifier = Modifier
                .id("contact")
                .margin(top = 42.px)
                .fontSize(if (breakpoint >= Breakpoint.MD) 90.px else 30.px)
                .color(Color.white)
                .fontWeight(FontWeight.Medium)
                .cursor(Cursor.Pointer)
                .textDecorationLine(TextDecorationLine.None),
            path = "tel:$PHONE_NUMBER"
        )
        SpanText(
            text = "Кыргызстан, г.Бишкек, Юнусалиева, 85",
            modifier = Modifier
                .margin(top = 24.px)
                .color(Color.white)
                .fontSize(if (breakpoint >= Breakpoint.MD) 30.px else 22.px)
                .lineHeight(if (breakpoint >= Breakpoint.MD) 38.px else 30.px)
                .fontWeight(FontWeight.Light)
        )
        Box(
            modifier = DefaultButtonStyle
                .toModifier()
                .id("contact")
                .align(Alignment.CenterHorizontally)
                .margin(top = if (breakpoint >= Breakpoint.MD) 100.px else 60.px)
                .padding(leftRight = 8.percent, topBottom = 2.percent)
                .borderRadius(r = 80.px)
                .fontWeight(FontWeight.Bold)
                .fontSize(if (breakpoint >= Breakpoint.MD) 24.px else 16.px)
                .letterSpacing(1.2.px)
                .onClick { window.location.href = "tel:$PHONE_NUMBER" },
            contentAlignment = Alignment.Center
        ) {
            Text(value = "ПОЗВОНИТЕ НАМ")
        }
    }
}