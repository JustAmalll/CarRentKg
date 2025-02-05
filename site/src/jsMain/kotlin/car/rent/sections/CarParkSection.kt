package car.rent.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import car.rent.components.SectionHeader
import car.rent.navigation.Section
import car.rent.pages.details.Car
import car.rent.pushEventToGTM
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.PointerEvents
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.backgroundImage
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.gap
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.objectFit
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.pointerEvents
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.layout.numColumns
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.rgba

enum class CarClass(val id: String, val text: String) {
    CHEAP(id = "economy", text = "ЭКОНОМ КЛАСС"),
    COMFORT(id = "comfort", text = "КОМФОРТ КЛАСС"),
    CROSSOVER(id = "crossover", text = "КРОССОВЕР")
}

@Composable
fun CarParkSection(onClick: (Car) -> Unit) {
    val breakpoint = rememberBreakpoint()
    var selectedCarClass by remember { mutableStateOf(CarClass.CHEAP) }

    val cars = remember(selectedCarClass) {
        Car.entries.filter { it.carClass == selectedCarClass }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.px)
            .id(Section.CarPark.id)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        ) {
            SectionHeader(
                title = "Автопарк",
                subtitle = "OUR CARS",
                longText = "Планируете поездку с семьёй за город или весёлые выходные с друзьями? Мы следим за трендами и спросом, чтобы предложить вам обновлённые автомобили вашей любимой марки."
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 72.px)
            ) {
                CarClass.entries.forEach { item ->
                    CarClass(
                        id = item.id,
                        text = item.text,
                        selected = selectedCarClass == item,
                        onClick = {
                            pushEventToGTM(
                                eventName = "car_class_click",
                                params = mapOf("car_class" to item.id)
                            )
                            selectedCarClass = item
                        }
                    )
                }
            }
            SimpleGrid(
                modifier = Modifier
                    .fillMaxWidth()
                    .margin(top = 24.px)
                    .gap(20.px),
                numColumns = numColumns(base = 1, md = 3)
            ) {
                cars.forEach { car ->
                    CarItem(
                        car = car,
                        breakpoint = breakpoint,
                        onClick = onClick
                    )
                }
            }
        }
    }
}

@Composable
fun CarItem(
    car: Car,
    breakpoint: Breakpoint,
    onClick: (Car) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .id(car.id)
            .thenIf(
                condition = breakpoint >= Breakpoint.MD,
                other = Modifier.size(width = 360.px, height = 272.px)
            )
            .cursor(if (car.available) Cursor.Pointer else Cursor.NotAllowed)
            .onClick { if (car.available) onClick(car) }
    ) {
        Image(
            modifier = Modifier
                .fillMaxSize()
                .objectFit(ObjectFit.Cover),
            src = car.images.first(),
            alt = "Аренда ${car.model} ${car.year} в Бишкеке от ${car.price}"
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .backgroundImage(
                    linearGradient(
                        dir = LinearGradient.Direction.ToBottom,
                        from = rgba(0, 0, 0, 0.30),
                        to = rgba(0, 0, 0, 0.70)
                    )
                )
        )
        Column(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .margin(left = 20.px, bottom = 40.px)
        ) {
            SpanText(
                text = car.model,
                modifier = Modifier
                    .fontSize(40.px)
                    .lineHeight(44.px)
                    .color(Color.white)
                    .fontWeight(FontWeight.Bold)
            )
            SpanText(
                text = if (car.available) {
                    "${car.price} сом"
                } else {
                    "Нет в наличии"
                },
                modifier = Modifier
                    .margin(top = 6.px)
                    .fontSize(20.px)
                    .color(Color.white)
                    .fontWeight(FontWeight.Bold)
            )
        }
    }
}

@Composable
fun RowScope.CarClass(
    id: String,
    text: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .id(id)
            .weight(1f)
            .cursor(Cursor.Pointer)
            .onClick { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SpanText(
            text = text,
            modifier = Modifier
                .fontSize(
                    when {
                        breakpoint > Breakpoint.MD -> 18.px
                        breakpoint == Breakpoint.MD -> 16.px
                        else -> 12.px
                    }
                )
                .margin(bottom = 16.px)
                .fontWeight(
                    if (selected) {
                        FontWeight.Bold
                    } else {
                        FontWeight.Normal
                    }
                )
                .color(Color.white)
                .userSelect(UserSelect.None)
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(if (selected) 4.px else 2.px)
                .backgroundColor(Color("#484848"))
                .margin(top = if (selected) 0.px else 1.px)
                .opacity(if (selected) 1 else 0.2)
                .borderRadius(if (selected) 4.px else 0.px)
                .pointerEvents(PointerEvents.None)
        )
    }
}