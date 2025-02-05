package car.rent.sections

import androidx.compose.runtime.Composable
import car.rent.components.SectionHeader
import car.rent.navigation.Section
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.JustifyItems
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.justifyItems
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px

@Composable
fun AboutCompanySection(breakpoint: Breakpoint) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .id(Section.AboutCompany.id)
            .padding(top = 50.px)
    ) {
        SectionHeader(
            title = "О компании",
            subtitle = "ABOUT US"
        )
        SimpleGrid(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = if (breakpoint >= Breakpoint.MD) 60.px else 24.px)
                .gap(30.px)
                .justifyItems(JustifyItems.Center),
            numColumns = numColumns(base = 1, md = 3)
        ) {
            Item(
                title = "Низкие цены",
                description = "Мы постоянно мониторим ценовой спрос, поэтому гарантируем выгодную стоимость аренды.",
                icon = "ic_price.png",
                breakpoint = breakpoint
            )
            Item(
                title = "Выезд за пределы Бишкека",
                description = "Вы можете спокойно перемещаться на автомобиле, туда, куда требуется.",
                icon = "ic_map.png",
                breakpoint = breakpoint
            )
            Item(
                title = "Подача в любое место",
                description = "Нет времени заехать к нам? Мы привезём или заберём автомобиль сами!",
                icon = "ic_location.png",
                breakpoint = breakpoint
            )
        }
        SpanText(
            text = "С 2020 года компания CarRent.kg предоставляет в аренду широкий выбор автомобилей, отвечающих различным потребностям клиентов. В нашем автопарке только подготовленные и технически исправные машины, доступные для аренды. Гибкие тарифы и разнообразные услуги для физических и юридических лиц позволили нам занять лидирующие позиции на рынке и заслужить доверие клиентов.",
            modifier = Modifier
                .margin(top = 90.px)
                .fontSize(if (breakpoint >= Breakpoint.MD) 22.px else 20.px)
                .lineHeight(1.35)
                .color(Color.white)
                .opacity(0.7f)
                .fontWeight(FontWeight.Light)
        )
    }
}

@Composable
fun Item(
    title: String,
    description: String,
    icon: String,
    breakpoint: Breakpoint
) {
    Column(
        modifier = Modifier.width(if (breakpoint >= Breakpoint.MD) 280.px else 360.px),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(if (breakpoint >= Breakpoint.MD) 150.px else 130.px),
            src = "/about_company_icons/$icon"
        )
        SpanText(
            text = title,
            modifier = Modifier
                .margin(top = if (breakpoint >= Breakpoint.MD) 32.px else 24.px)
                .fontSize(30.px)
                .lineHeight(1.17)
                .color(Color.white)
                .textAlign(TextAlign.Center)
                .whiteSpace(WhiteSpace.PreWrap)
        )
        SpanText(
            text = description,
            modifier = Modifier
                .margin(top = 24.px)
                .fontSize(16.px)
                .lineHeight(1.55)
                .color(Color.white)
                .fontWeight(FontWeight.Light)
                .textAlign(TextAlign.Center)
                .whiteSpace(WhiteSpace.PreWrap)
        )
    }
}