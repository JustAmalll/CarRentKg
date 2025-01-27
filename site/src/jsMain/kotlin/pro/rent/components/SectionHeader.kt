package pro.rent.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexWrap
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.justifyContent
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.FlexWrap
import org.jetbrains.compose.web.css.JustifyContent
import org.jetbrains.compose.web.css.px

@Composable
fun SectionHeader(
    modifier: Modifier = Modifier,
    title: String,
    subtitle: String,
    longText: String? = null
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .display(DisplayStyle.Flex)
            .flexWrap(FlexWrap.Wrap)
            .justifyContent(JustifyContent.SpaceBetween)
    ) {
        Column(
            modifier = Modifier
                .padding(topBottom = 7.px)
                .margin(right = 24.px)
        ) {
            SpanText(
                modifier = Modifier
                    .fontSize(82.px)
                    .lineHeight(84.px)
                    .fontWeight(FontWeight.Medium)
                    .color(Color.white),
                text = title
            )
            Row(
                modifier = Modifier.margin(top = 4.px),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(60.px)
                        .width(6.px)
                        .backgroundColor(Color("#484848"))
                        .borderRadius(6.px)
                )
                SpanText(
                    modifier = Modifier
                        .margin(left = 10.px)
                        .fontSize(34.px)
                        .lineHeight(36.px)
                        .color(Color.white),
                    text = subtitle
                )
            }
        }
        longText?.let {
            SpanText(
                modifier = Modifier
                    .maxWidth(460.px)
                    .fontSize(20.px)
                    .lineHeight(30.px)
                    .padding(top = 8.px, bottom = 6.px)
                    .fontWeight(FontWeight.Light)
                    .color(Color.white),
                text = longText
            )
        }
    }
}