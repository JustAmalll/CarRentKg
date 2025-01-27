package pro.rent.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.rotate
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.layout.HorizontalDivider
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.deg
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import pro.rent.components.SectionHeader
import pro.rent.models.Section
import pro.rent.styles.DefaultButtonStyle

@Composable
fun RentalTermsSection() {
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
            text = "С какого возраста я могу арендовать автомобиль?",
            description = "Вы можете арендовать у нас автомобиль при наличии в/у, с 23 лет."
        )
        TermItem(
            text = "Что нужно для аренды автомобиля?",
            description = "Мы заключаем договор аренды, для этого от Вас потребуется: фото паспорта и прав с двух сторон."
        )
        TermItem(
            text = "Сколько километров я могу проехать на автомобиле?",
            description = ""
        )
        TermItem(
            text = "Что делать, если я получу штраф ПДД или нарушу скоростной режим?",
            description = "Все штрафы за нарушения ПДД и скоростных режимов оплачивает Арендатор."
        )
        TermItem(
            text = "Что делать если я попал в ДТП?",
            description = "Не покидайте место ДТП, необходимо сразу сообщить об этом Арендодателю."
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .margin(top = 16.px),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = DefaultButtonStyle
                    .toModifier()
                    .size(48.px)
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
                    .margin(left = 24.px)
                    .fontSize(18.px)
                    .color(Color.white)
                    .fontWeight(FontWeight.Light),
                text = "Если Вам требуется продлить срок аренды автомобиля - просто позвоните нам. Вы можете это сделать без повторного посещения сервиса аренды."
            )
        }
    }
}

@Composable
private fun TermItem(
    text: String,
    description: String
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(topBottom = 32.px)
            .cursor(Cursor.Pointer)
            .onClick { expanded = !expanded }
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            SpanText(
                modifier = Modifier
                    .weight(1f)
                    .fontSize(30.px)
                    .color(Color.white)
                    .margin(right = 16.px),
                text = text
            )
            Box(
                modifier = DefaultButtonStyle
                    .toModifier()
                    .size(48.px)
                    .borderRadius(50.percent)
                    .onClick { expanded = !expanded },
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
        if (expanded) {
            SpanText(
                modifier = Modifier
                    .margin(top = 12.px)
                    .fontSize(18.px)
                    .color(Color.white)
                    .fontWeight(FontWeight.Light),
                text = description
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