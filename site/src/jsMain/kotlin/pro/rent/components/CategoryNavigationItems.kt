package pro.rent.components

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.thenIf
import com.varabyte.kobweb.silk.components.navigation.Link
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.px
import pro.rent.models.Section

@Composable
fun RowScope.CategoryNavigationItems(
    vertical: Boolean = false
) {
    Section.entries.forEach { category ->
        Link(
            modifier = Modifier
                .weight(1f)
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
                .textDecorationLine(TextDecorationLine.None),
            path = category.path,
            text = category.text.uppercase()
        )
    }
}