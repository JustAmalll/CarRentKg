package pro.rent.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.bottom
import com.varabyte.kobweb.compose.ui.modifiers.display
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
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
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.DisplayStyle
import org.jetbrains.compose.web.css.Position
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import pro.rent.models.Section
import pro.rent.pages.details.Car
import pro.rent.pages.details.CarDetailsPopup
import pro.rent.sections.BannerSection
import pro.rent.sections.CarParkSection
import pro.rent.sections.ContactsSection
import pro.rent.sections.FooterSection
import pro.rent.sections.HeaderSection
import pro.rent.sections.RentalTermsSection
import pro.rent.styles.DefaultButtonStyle

const val MAX_PAGE_WIDTH = 1240

@Page
@Composable
fun HomePage() {
    val context = rememberPageContext()
    val breakpoint = rememberBreakpoint()

    var car by remember { mutableStateOf<Car?>(null) }
    car?.let { CarDetailsPopup(car = it, onClosePopupClicked = { car = null }) }


    Column(
        modifier = Modifier
            .fillMaxSize()
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
                    condition = breakpoint >= Breakpoint.MD,
                    other = Modifier.maxWidth(
                        if (breakpoint > Breakpoint.MD) MAX_PAGE_WIDTH.px else 940.px
                    )
                )
                .padding(leftRight = 32.px)
        ) {
            CarParkSection(onClick = { car = it })
            RentalTermsSection()
            ContactsSection()
        }
        if (breakpoint >= Breakpoint.MD) {
            FooterSection()
        }
    }
    Button(
        onClick = {},
        modifier = DefaultButtonStyle
            .toModifier()
            .size(60.px)
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