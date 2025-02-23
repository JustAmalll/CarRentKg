package car.rent.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import car.rent.components.SectionHeader
import car.rent.navigation.Section
import car.rent.pushEventToGTM
import car.rent.styles.DefaultButtonStyle

import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.UserSelect
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexShrink
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.userSelect
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun RentalTermsSection() {
    val breakpoint = rememberBreakpoint()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .id(Section.RentalTerms.id)
            .margin(top = 40.px)
            .padding(top = 40.px)
    ) {
        SectionHeader(
            title = "Условия аренды",
            subtitle = "RENT TERMS"
        )
        HorizontalDivider(
            modifier = Modifier
                .fillMaxWidth()
                .color(Color.white)
                .margin(top = 32.px, bottom = 0.px)
        )
        TermItem(
            id = "rental_age",
            text = "С какого возраста я могу арендовать автомобиль?",
            description = "Вы можете арендовать у нас автомобиль если ваш возраст от 23 лет и стаж вождения от 3-х лет"
        )
        TermItem(
            id = "rental_docs",
            text = "Что нужно для аренды автомобиля?",
            description = "Мы заключаем договор аренды. Для этого от Вас потребуется: фото паспорта и прав с двух сторон, а также залог 15 000 сом."
        )
        TermItem(
            id = "rental_limit",
            text = "Сколько километров я могу проехать на автомобиле?",
            description = "У нас нет ограничений по километрам. Вы можете проезжать любое расстояние в зависимости от ваших потребностей и условий."
        )
        TermItem(
            id = "rental_fines",
            text = "Что делать, если я получу штраф ПДД или нарушу скоростной режим?",
            description = "Все штрафы за нарушения ПДД и скоростных режимов оплачивает Арендатор."
        )
        TermItem(
            id = "rental_accident",
            text = "Что делать если я попал в ДТП?",
            description = "Не покидайте место ДТП, необходимо сразу сообщить об этом Арендодателю."
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 24.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = DefaultButtonStyle
                    .toModifier()
                    .size(if (breakpoint >= Breakpoint.MD) 48.px else 34.px)
                    .flexShrink(0)
                    .borderRadius(50.percent),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    src = "/ic_info.svg",
                    modifier = Modifier
                        .color(Color.white)
                        .size(20.px)
                )
            }
            SpanText(
                modifier = Modifier
                    .margin(left = if (breakpoint >= Breakpoint.MD) 24.px else 12.px)
                    .fontSize(if (breakpoint >= Breakpoint.MD) 18.px else 12.px)
                    .color(Color.white)
                    .fontWeight(FontWeight.Light),
                text = "Если Вам требуется продлить срок аренды автомобиля - просто позвоните нам. Вы можете это сделать без повторного посещения сервиса аренды."
            )
        }
    }
}

@Composable
private fun TermItem(
    id: String,
    text: String,
    description: String
) {
    val breakpoint = rememberBreakpoint()
    var expanded by remember { mutableStateOf(false) }

    val onClick: () -> Unit = remember {
        {
            if (!expanded) {
                pushEventToGTM(
                    eventName = "faq_expand_click",
                    params = mapOf("faq_question" to id)
                )
            }
            expanded = !expanded
        }
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .id(id)
                .fillMaxWidth()
                .padding(topBottom = if (breakpoint >= Breakpoint.MD) 30.px else 18.px)
                .cursor(Cursor.Pointer)
                .userSelect(UserSelect.None)
                .onClick { onClick() }
        ) {
            SpanText(
                modifier = Modifier
                    .fontSize(if (breakpoint >= Breakpoint.MD) 30.px else 20.px)
                    .lineHeight(if (breakpoint >= Breakpoint.MD) 36.px else 26.px)
                    .color(Color.white)
                    .margin(right = 16.px),
                text = text
            )
            if (expanded) {
                SpanText(
                    modifier = Modifier
                        .margin(top = 12.px)
                        .fontSize(if (breakpoint >= Breakpoint.MD) 18.px else 12.px)
                        .color(Color.white)
                        .fontWeight(FontWeight.Light),
                    text = description
                )
            }
        }
        Box(
            modifier = DefaultButtonStyle
                .toModifier()
                .id(id)
                .size(if (breakpoint >= Breakpoint.MD) 48.px else 30.px)
                .borderRadius(50.percent)
                .flexShrink(0)
                .cursor(Cursor.Pointer)
                .onClick { onClick() },
            contentAlignment = Alignment.Center
        ) {
            Image(
                src = "/ic_plus.svg",
                modifier = Modifier
                    .size(18.px)
                    .color(Color.white)
                    .rotate(if (expanded) 45.deg else 0.deg)
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .color(Color.white)
            .margin(0.px)
    )
}