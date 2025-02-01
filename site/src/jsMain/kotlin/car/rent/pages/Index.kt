package car.rent.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import car.rent.Constants.PHONE_NUMBER
import car.rent.navigation.Section
import car.rent.pages.details.Car
import car.rent.pages.details.CarDetailsPopup
import car.rent.sections.BannerSection
import car.rent.sections.CarParkSection
import car.rent.sections.ContactsSection
import car.rent.sections.FooterSection
import car.rent.sections.HeaderSection
import car.rent.sections.RentalTermsSection
import car.rent.styles.DefaultButtonStyle
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.bottom
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.position
import com.varabyte.kobweb.compose.ui.modifiers.right
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import net.thauvin.erik.urlencoder.UrlEncoderUtil
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

const val MAX_PAGE_WIDTH = 1240

@JsName("gtag_report_conversion")
external fun handleContactsLink(url: String): Boolean

@Page
@Composable
fun HomePage() {
    val context = rememberPageContext()
    val breakpoint = rememberBreakpoint()

    var car by remember { mutableStateOf<Car?>(null) }
    car?.let { CarDetailsPopup(car = it, onClosePopupClicked = { car = null }) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .backgroundColor(Color("#161616"))
            .thenIf(
                condition = car != null,
                other = Modifier.display(DisplayStyle.None)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            BannerSection(onSelectCarClicked = { context.router.navigateTo(Section.CarPark.path) })

            if (breakpoint >= Breakpoint.MD) {
                HeaderSection()
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .thenIf(
                    condition = breakpoint > Breakpoint.MD,
                    other = Modifier.maxWidth(MAX_PAGE_WIDTH.px)
                )
                .padding(leftRight = 32.px),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CarParkSection(onClick = { car = it })
            RentalTermsSection()
            ContactsSection()
        }
        if (breakpoint > Breakpoint.MD) {
            FooterSection()
        }
    }
    Button(
        onClick = {
            val message = UrlEncoderUtil.encode(
                """
                    Здравствуйте! Я хочу узнать о возможности аренды машины.

                    Интересуют детали:
                     • Дата аренды: 
                     • Срок аренды: 
                     • Предпочтительный автомобиль: 

                    Если машина свободна, прошу уточнить стоимость и условия.

                    Спасибо! Жду вашего ответа.
                """.trimIndent()
            )
            handleContactsLink(url = "https://wa.me/$PHONE_NUMBER?text=$message")
        },
        modifier = DefaultButtonStyle
            .toModifier()
            .size(64.px)
            .borderRadius(50.percent)
            .position(Position.Fixed)
            .bottom(24.px)
            .right(24.px)
    ) {
        Image(
            src = "/ic_chat.svg",
            modifier = Modifier.size(32.px)
        )
    }
}