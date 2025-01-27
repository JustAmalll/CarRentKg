package pro.rent.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.text.SpanText
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import pro.rent.models.Constants.COMPANY_NAME
import pro.rent.navigation.Screen

@Composable
fun CompanyLogo(modifier: Modifier = Modifier) {
    val context = rememberPageContext()

    SpanText(
        text = COMPANY_NAME,
        modifier = modifier
            .margin(right = 50.px)
            .onClick { context.router.navigateTo(Screen.HomePage.route) }
            .cursor(Cursor.Pointer)
            .fontSize(24.px)
            .color(Color.white)
    )
}