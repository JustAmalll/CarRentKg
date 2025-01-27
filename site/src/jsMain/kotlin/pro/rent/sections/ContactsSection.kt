package pro.rent.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
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
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import pro.rent.components.SectionHeader
import pro.rent.models.Constants.PHONE_NUMBER
import pro.rent.models.Constants.PHONE_NUMBER_FORMATTED
import pro.rent.models.Section
import pro.rent.styles.DefaultButtonStyle

@Composable
fun ContactsSection() {
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
                .margin(top = 42.px)
                .fontSize(90.px)
                .color(Color.white)
                .fontWeight(FontWeight.Medium)
                .textDecorationLine(TextDecorationLine.None),
            path = "tel:$PHONE_NUMBER"
        )
        SpanText(
            text = "info@rentacar.kg",
            modifier = Modifier
                .fontSize(90.px)
                .lineHeight(90.px)
                .color(Color.white)
                .fontWeight(FontWeight.Medium)
        )
        SpanText(
            text = "Кыргызстан, г.Бишкек, пр.Мира 123, здание 1, офис 4",
            modifier = Modifier
                .margin(top = 40.px)
                .color(Color.white)
                .fontSize(30.px)
                .lineHeight(30.px)
                .fontWeight(FontWeight.Light)
        )
        Box(
            modifier = DefaultButtonStyle
                .toModifier()
                .align(Alignment.CenterHorizontally)
                .margin(top = 100.px)
                .padding(leftRight = 8.percent, topBottom = 2.percent)
                .borderRadius(r = 80.px)
                .onClick {},
            contentAlignment = Alignment.Center
        ) {
            SpanText(
                text = "ПОЗВОНИТЕ НАМ",
                modifier = Modifier
                    .fontWeight(FontWeight.Bold)
                    .fontSize(24.px)
                    .letterSpacing(1.2.px)
            )
        }
    }
}