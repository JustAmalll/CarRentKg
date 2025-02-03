package car.rent.utils

import androidx.compose.web.events.SyntheticMouseEvent
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.onClick

fun Modifier.onClicked(action: (SyntheticMouseEvent) -> Unit): Modifier = then(
    Modifier.onClick { event ->
        event.stopPropagation()
        event.preventDefault()
        action(event)
    }
)