package car.rent.sections

import androidx.compose.runtime.Composable
import car.rent.components.CategoryNavigationItems
import car.rent.components.CompanyLogo
import car.rent.pages.MAX_PAGE_WIDTH
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.css.vh

@Composable
fun HeaderSection() {

    Box(
        modifier = Modifier
            .fillMaxWidth(percent = 90.percent)
            .height(10.vh),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .maxWidth(MAX_PAGE_WIDTH.px)
                .height(10.vh),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CompanyLogo(modifier = Modifier.weight(1f))

            Row(
                modifier = Modifier.weight(1f),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                CategoryNavigationItems()
            }
        }
    }
}