package pro.rent.sections

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.letterSpacing
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text
import pro.rent.models.Section
import pro.rent.pages.MAX_PAGE_WIDTH
import pro.rent.styles.DefaultButtonStyle

@Composable
fun BannerSection(onSelectCarClicked: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .id(Section.AboutCompany.id),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .objectFit(ObjectFit.Cover),
            src = "/banner.png",
            alt = "Cover"
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .styleModifier {
                    property(
                        "background",
                        "linear-gradient(90deg, rgba(0, 0, 0, 0.8), rgba(108, 107, 103, 0), rgba(108, 107, 103, 0))"
                    )
                }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth(percent = 90.percent)
                .maxWidth(MAX_PAGE_WIDTH.px)
                .padding(topBottom = 50.px)
                .margin(leftRight = 20.px)
        ) {
            SpanText(
                text = "Лидеры аренды\nавтомобилей\nв Бишкеке",
                modifier = Modifier
                    .fontSize(90.px)
                    .lineHeight(94.px)
                    .fontWeight(FontWeight.Medium)
                    .color(Color.white)
                    .whiteSpace(WhiteSpace.PreWrap)
            )
            SpanText(
                text = "Аренда автомобиля за\n15 минут — быстро, удобно,\nнадежно.",
                modifier = Modifier
                    .margin(top = 42.px)
                    .fontSize(30.px)
                    .lineHeight(40.px)
                    .letterSpacing(2.px)
                    .color(Color.white)
                    .whiteSpace(WhiteSpace.PreWrap)
            )
            Box(
                modifier = DefaultButtonStyle
                    .toModifier()
                    .margin(top = 32.px)
                    .padding(leftRight = 5.percent, topBottom = 1.5.percent)
                    .fontWeight(FontWeight.Bold)
                    .fontSize(24.px)
                    .borderRadius(r = 80.px)
                    .onClick { onSelectCarClicked() },
                contentAlignment = Alignment.Center
            ) {
                Text(value = "ВЫБРАТЬ АВТОМОБИЛЬ")
            }
        }
    }
}