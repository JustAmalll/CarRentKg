package pro.rent.models

import kotlinx.serialization.Serializable
import pro.rent.models.Constants.PHONE_NUMBER

@Serializable
enum class Section(
    val id: String,
    val text: String,
    val path: String,
) {
    AboutCompany(text = "О компании", path = "#about_company", id = "about_company"),
    CarPark(text = "Автопарк", path = "#carpark", id = "carpark"),
    RentalTerms(text = "Условия", path = "#rental_terms", id = "rental_terms"),
    Contacts(text = "Контакты", path = "#contacts", id = "contacts"),
    PhoneNumber(text = Constants.PHONE_NUMBER_FORMATTED, path = "tel:$PHONE_NUMBER", id = "")
}