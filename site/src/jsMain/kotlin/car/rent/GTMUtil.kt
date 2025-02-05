package car.rent

import kotlinx.browser.window

fun pushEventToGTM(eventName: String, params: Map<String, Any?> = emptyMap()) {
    val eventObject: dynamic = js("{}")
    eventObject.event = eventName

    params.forEach { (key, value) ->
        eventObject[key] = value
    }
    window.asDynamic().dataLayer?.push(eventObject)
}