package pro.rent.pages.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.overflow
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowLeft
import com.varabyte.kobweb.silk.components.icons.fa.FaArrowRight
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Text
import pro.rent.sections.CarClass
import pro.rent.styles.DefaultButtonStyle

enum class Car(
    val model: String,
    val year: Int,
    val specs: String,
    val price: Int,
    val description: String,
    val carClass: CarClass,
    val detailsPrices: List<String>,
    val images: List<String>
) {
    SONATA_2018_GRAY(
        model = "Hyundai Sonata",
        year = 2018,
        specs = "2.0 | 245 л.c | Газ | Передний привод | Цвет: Серебристый",
        price = 3500,
        description = "Элегантный дизайн, комфорт и надежность — всё, что нужно для идеального вождения. Современный облик и продуманная комплектация этого седана обеспечат вам удовольствие от каждой поездки, а мощный и экономичный двигатель подарит уверенность на любой дороге.",
        detailsPrices = listOf(
            "1-3 суток | 3500 сом",
            "4-20 суток | 3000 сом",
            "20+ суток | 2800 сом"
        ),
        carClass = CarClass.CHEAP,
        images = listOf(
            "/sonata_2018_silver/2018-Hyundai-Sonata-107.jpg",
            "/sonata_2018_silver/2018-Hyundai-Sonata-111.jpg",
            "/sonata_2018_silver/2018-Hyundai-Sonata-117.jpg",
            "/sonata_2018_silver/2018-Hyundai-Sonata-118.jpg",
            "/sonata_2018_silver/2018-Hyundai-Sonata-121.jpg"
        )
    ),
    SONATA_2018_BLACK(
        model = "Hyundai Sonata",
        year = 2018,
        specs = "2.0 | 245 л.c | Газ | Передний привод | Цвет: Черный",
        price = 3500,
        description = "Элегантный дизайн, комфорт и надежность — всё, что нужно для идеального вождения. Современный облик и продуманная комплектация этого седана обеспечат вам удовольствие от каждой поездки, а мощный и экономичный двигатель подарит уверенность на любой дороге.",
        detailsPrices = listOf(
            "1-3 суток | 3500 сом",
            "4-20 суток | 3000 сом",
            "20+ суток | 2800 сом"
        ),
        carClass = CarClass.CHEAP,
        images = listOf(
            "/sonata_2018_black/9cd7c0b9-8914-41cc-b36d-11007bfd78f8-2018HyundaiSonata5.jpg",
            "/sonata_2018_black/90432e9b-672c-4014-a6d0-a93fa6058114-2018HyundaiSonata7.jpg",
            "/sonata_2018_black/2018-Hyundai-Sonata-118.jpg",
            "/sonata_2018_black/2018-Hyundai-Sonata-121.jpg"
        )
    ),
    SONATA_2020(
        model = "Hyundai Sonata",
        year = 2020,
        specs = "2.0 | 245 л.c | Газ | Передний привод | Цвет: Черный",
        price = 4000,
        description = "Элегантный дизайн, комфорт и надежность — всё, что нужно для идеального вождения. Современный облик и продуманная комплектация этого седана обеспечат вам удовольствие от каждой поездки, а мощный и экономичный двигатель подарит уверенность на любой дороге.",
        detailsPrices = listOf(
            "1-3 суток | 4000 сом",
            "4-20 суток | 3500 сом",
            "20+ суток | 3000 сом"
        ),
        carClass = CarClass.COMFORT,
        images = listOf(
            "/sonata_2020_black/eb373aa9-1b59-4cba-b4a9-ef17a90648ae-2020HyundaiSonataLimited28.jpg",
            "/sonata_2020_black/461aa20a-a794-45e6-9ba0-22e7ba7b0dd7-2020HyundaiSonataLimited21.jpg",
            "/sonata_2020_black/3d33738e-7dcb-49cc-aea3-f5a053214dcd-2020HyundaiSonataLimited24.jpg",
            "/sonata_2020_black/2020-hyundai-sonata-hybrid-109-1580948070.jpg"
        )
    ),
    TUSCON_2019(
        model = "Hyundai Tucson",
        year = 2019,
        specs = "2.0 | 245 л.c | Дизель | Полный привод | Цвет: Серый",
        price = 4000,
        description = "Элегантный дизайн, комфорт и надежность — всё, что нужно для идеального вождения. Современный облик и продуманная комплектация этого седана обеспечат вам удовольствие от каждой поездки, а мощный и экономичный двигатель подарит уверенность на любой дороге.",
        detailsPrices = listOf(
            "1-3 суток | 4000 сом",
            "4-20 суток | 3500 сом",
            "20+ суток | 3000 сом"
        ),
        carClass = CarClass.CROSSOVER,
        images = listOf(
            "/tucson_2019_grey/2019-Hyundai-Tucson-HTRAC-front-three-quarter-in-motion-1.jpg",
            "/tucson_2019_grey/2019-Hyundai-Tucson-HTRAC-rear-three-quarter-in-motion.jpg",
            "/tucson_2019_grey/2019-hyundai-tucson-ultimate-106-1566578587.jpg",
            "/tucson_2019_grey/2019-hyundai-tucson-ultimate-113-1566578591.jpg",
            "/tucson_2019_grey/2019-hyundai-tucson-ultimate-118-1566578593.jpg"
        )
    )
}

@Composable
fun CarDetailsPopup(car: Car, onClosePopupClicked: () -> Unit) {
    val breakpoint = rememberBreakpoint()

    Box(
        modifier = Modifier
            .width(100.percent)
            .height(100.percent)
            .backgroundColor(Color("#161616"))
            .position(Position.Fixed)
            .overflow(overflow = Overflow.Auto)
            .padding(topBottom = 40.px, leftRight = 20.px),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .cursor(Cursor.Pointer)
                .onClick { onClosePopupClicked() }
        )
        SimpleGrid(
            numColumns = numColumns(base = 1, md = 2),
            modifier = Modifier
                .fillMaxWidth()
                .thenIf(
                    condition = breakpoint >= Breakpoint.MD,
                    other = Modifier.maxWidth(1200.px)
                )
                .gap(if (breakpoint > Breakpoint.MD) 40.px else 20.px)
        ) {
            CarDetailedImage(breakpoint = breakpoint, images = car.images)
            CarDetailsText(car = car)
        }
    }
}

@Composable
fun CarDetailedImage(
    images: List<String>,
    breakpoint: Breakpoint
) {
    var selectedCarImageIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.thenIf(
            condition = breakpoint >= Breakpoint.MD,
            other = Modifier.size(width = 760.px, height = 570.px)
        )
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .objectFit(ObjectFit.Cover),
            src = images[selectedCarImageIndex],
            alt = ""
        )
        if (selectedCarImageIndex != images.lastIndex) {
            Box(
                modifier = DefaultButtonStyle
                    .toModifier()
                    .margin(all = 16.px)
                    .size(40.px)
                    .borderRadius(50.percent)
                    .align(Alignment.CenterEnd)
                    .onClick { selectedCarImageIndex += 1 },
                contentAlignment = Alignment.Center
            ) {
                FaArrowRight(modifier = Modifier.color(Color.white))
            }
        }
        if (selectedCarImageIndex != 0) {
            Box(
                modifier = DefaultButtonStyle
                    .toModifier()
                    .margin(all = 16.px)
                    .size(40.px)
                    .borderRadius(50.percent)
                    .align(Alignment.CenterStart)
                    .onClick { selectedCarImageIndex -= 1 },
                contentAlignment = Alignment.Center
            ) {
                FaArrowLeft(modifier = Modifier.color(Color.white))
            }
        }
    }
}

@Composable
fun CarDetailsText(car: Car) {
    Column(modifier = Modifier.maxWidth(440.px)) {
        SpanText(
            modifier = Modifier
                .fontSize(30.px)
                .color(Color.white),
            text = "${car.model} ${car.year}"
        )
        SpanText(
            modifier = Modifier
                .fontSize(12.px)
                .margin(top = 2.px)
                .color(Color.white),
            text = car.specs
        )
        SpanText(
            modifier = Modifier
                .fontSize(18.px)
                .fontWeight(FontWeight.Medium)
                .margin(top = 16.px)
                .color(Color.white),
            text = "${car.price} сом"
        )
        Button(
            onClick = {},
            modifier = DefaultButtonStyle
                .toModifier()
                .margin(top = 16.px)
                .borderRadius(24.px)
                .padding(leftRight = 42.px)
        ) {
            Text(value = "АРЕНДОВАТЬ")
        }
        SpanText(
            modifier = Modifier
                .margin(top = 24.px, bottom = 16.px)
                .color(Color.white)
                .fontSize(14.px)
                .fontWeight(FontWeight.Light),
            text = car.description
        )
        car.detailsPrices.forEach { price ->
            SpanText(
                modifier = Modifier
                    .margin(top = 6.px)
                    .color(Color.white)
                    .fontSize(18.px)
                    .fontWeight(FontWeight.Medium),
                text = price
            )
        }
    }
}