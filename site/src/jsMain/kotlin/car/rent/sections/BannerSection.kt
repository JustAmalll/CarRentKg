package car.rent.sections

import androidx.compose.runtime.Composable
import car.rent.models.Section
import car.rent.pages.MAX_PAGE_WIDTH
import car.rent.styles.DefaultButtonStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.TextAlign
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
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text

@Composable
fun BannerSection(onSelectCarClicked: () -> Unit) {
    val breakpoint = rememberBreakpoint()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .id(Section.AboutCompany.id),
        contentAlignment = Alignment.Center
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .objectFit(ObjectFit.Cover),
            src = "/banner.jpg",
            alt = "Аренда автомобилей в Бишкеке"
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
                .margin(leftRight = 20.px),
            horizontalAlignment = if (breakpoint >= Breakpoint.MD) {
                Alignment.Start
            } else {
                Alignment.CenterHorizontally
            }
        ) {
            SpanText(
                text = if (breakpoint >= Breakpoint.MD) {
                    "Лидеры аренды\nавтомобилей\nв Бишкеке"
                } else {
                    "Лидеры аренды автомобилей в Бишкеке"
                },
                modifier = Modifier
                    .fontSize(
                        when {
                            breakpoint > Breakpoint.MD -> 90.px
                            breakpoint == Breakpoint.MD -> 60.px
                            else -> 30.px
                        }
                    )
                    .lineHeight(
                        when {
                            breakpoint > Breakpoint.MD -> 94.px
                            breakpoint == Breakpoint.MD -> 68.px
                            else -> 36.px
                        }
                    )
                    .fontWeight(FontWeight.Medium)
                    .color(Color.white)
                    .whiteSpace(WhiteSpace.PreWrap)
                    .textAlign(
                        if (breakpoint >= Breakpoint.MD) {
                            TextAlign.Start
                        } else {
                            TextAlign.Center
                        }
                    )
            )
            SpanText(
                text = if (breakpoint >= Breakpoint.MD) {
                    "Аренда автомобиля за\n15 минут — быстро, удобно,\nнадежно."
                } else {
                    "Аренда автомобиля за 15\nминут — быстро, удобно, надежно."
                },
                modifier = Modifier
                    .margin(
                        top = when {
                            breakpoint > Breakpoint.MD -> 42.px
                            breakpoint == Breakpoint.MD -> 30.px
                            else -> 24.px
                        }
                    )
                    .fontSize(
                        when {
                            breakpoint > Breakpoint.MD -> 30.px
                            breakpoint == Breakpoint.MD -> 20.px
                            else -> 14.px
                        }
                    )
                    .lineHeight(
                        when {
                            breakpoint > Breakpoint.MD -> 40.px
                            breakpoint == Breakpoint.MD -> 30.px
                            else -> 20.px
                        }
                    )
                    .letterSpacing(2.px)
                    .color(Color.white)
                    .whiteSpace(WhiteSpace.PreWrap)
                    .textAlign(
                        if (breakpoint >= Breakpoint.MD) {
                            TextAlign.Start
                        } else {
                            TextAlign.Center
                        }
                    )
            )
            Box(
                modifier = DefaultButtonStyle
                    .toModifier()
                    .margin(
                        top = when {
                            breakpoint > Breakpoint.MD -> 42.px
                            breakpoint == Breakpoint.MD -> 30.px
                            else -> 24.px
                        }
                    )
                    .padding(leftRight = 5.percent, topBottom = 1.5.percent)
                    .fontWeight(FontWeight.Bold)
                    .fontSize(
                        when {
                            breakpoint > Breakpoint.MD -> 22.px
                            breakpoint == Breakpoint.MD -> 18.px
                            else -> 14.px
                        }
                    )
                    .borderRadius(r = 80.px)
                    .onClick { onSelectCarClicked() },
                contentAlignment = Alignment.Center
            ) {
                Text(value = "ВЫБРАТЬ АВТОМОБИЛЬ")
            }
        }
    }
}