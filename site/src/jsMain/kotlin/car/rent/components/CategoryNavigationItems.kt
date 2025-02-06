package car.rent.components

import androidx.compose.runtime.Composable
import car.rent.navigation.Section
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.css.WhiteSpace
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.id
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.whiteSpace
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px

@Composable
fun RowScope.CategoryNavigationItems(
    vertical: Boolean = false
) {
    Section.entries.forEach { category ->
        Link(
            modifier = Modifier
                .weight(1f)
                .thenIf(
                    condition = category == Section.PhoneNumber,
                    other = Modifier.id("header_phone_number")
                )
                .thenIf(
                    condition = vertical,
                    other = Modifier.margin(bottom = 24.px)
                )
                .thenIf(
                    condition = !vertical,
                    other = Modifier.margin(left = 24.px)
                )
                .fontSize(18.px)
                .color(Color.white)
                .textDecorationLine(TextDecorationLine.None)
                .whiteSpace(WhiteSpace.NoWrap),
            path = category.path,
            text = category.text.uppercase()
        )
    }
}