package car.rent.sections

import androidx.compose.runtime.Composable
import car.rent.Constants.COMPANY_NAME
import car.rent.Constants.PHONE_NUMBER
import car.rent.Constants.PHONE_NUMBER_FORMATTED
import car.rent.components.CompanyLogo
import car.rent.navigation.Section
import car.rent.pages.MAX_PAGE_WIDTH

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.navigation.Link
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px

@Composable
fun FooterSection() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(MAX_PAGE_WIDTH.px)
    ) {
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .color(Color("#484848"))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(left = 60.px, top = 42.px, bottom = 42.px)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                CompanyLogo()

                SpanText(
                    modifier = Modifier
                        .fontSize(16.px)
                        .color(Color.white)
                        .margin(top = 24.px)
                        .whiteSpace(WhiteSpace.PreWrap)
                        .fontWeight(FontWeight.Light),
                    text = "© 2025 | $COMPANY_NAME\nВсе права защищены\nMade with love for great people"
                )
            }
            Column(modifier = Modifier.weight(1f)) {
                SpanText(
                    modifier = Modifier
                        .fontSize(18.px)
                        .color(Color.white)
                        .opacity(0.7)
                        .margin(bottom = 16.px),
                    text = "МЕНЮ"
                )
                Section.entries.forEach { section ->
                    if (section == Section.PhoneNumber) return@forEach
                    FooterItem(text = section.text, path = section.path)
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                SpanText(
                    modifier = Modifier
                        .fontSize(18.px)
                        .color(Color.white)
                        .opacity(0.7)
                        .margin(bottom = 16.px),
                    text = "АВТОПАРК"
                )
                CarClass.entries.forEach {
                    FooterItem(
                        text = it.text,
                        path = Section.CarPark.path,
                        onClick = {}
                    )
                }
            }
            Column(modifier = Modifier.weight(1f)) {
                Link(
                    modifier = Modifier
                        .id("footer_phone_number")
                        .fontSize(36.px)
                        .color(Color.white)
                        .cursor(Cursor.Pointer)
                        .textDecorationLine(TextDecorationLine.None),
                    text = PHONE_NUMBER_FORMATTED,
                    path = "tel:$PHONE_NUMBER"
                )
            }
        }
    }
}

@Composable
fun FooterItem(
    modifier: Modifier = Modifier,
    text: String,
    path: String? = null,
    onClick: () -> Unit = {}
) {
    Link(
        modifier = modifier
            .margin(top = 8.px)
            .fontSize(18.px)
            .color(Color.white)
            .textDecorationLine(TextDecorationLine.None)
            .onClick { onClick() },
        text = text,
        path = path ?: ""
    )
}