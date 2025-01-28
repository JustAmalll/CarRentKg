package car.rent.navigation

sealed class Screen(val route: String) {
    data object HomePage : Screen(route = "/")
}