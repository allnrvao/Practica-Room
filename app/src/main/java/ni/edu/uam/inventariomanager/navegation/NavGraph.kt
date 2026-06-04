package ni.edu.uam.inventariomanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ni.edu.uam.inventariomanager.ui.screens.*
import ni.edu.uam.inventariomanager.viewmodel.*

@Composable
fun NavGraph(

    loginViewModel: LoginViewModel,

    dashboardViewModel: DashboardViewModel,

    equipoViewModel: EquipoViewModel,

    prestamoViewModel: PrestamoViewModel

) {

    val navController = rememberNavController()

    NavHost(

        navController = navController,

        startDestination = "login"

    ) {

        composable("login") {

            LoginScreen(

                loginViewModel = loginViewModel,

                onLoginExitoso = {

                    navController.navigate(
                        "dashboard"
                    ) {

                        popUpTo("login") {

                            inclusive = true

                        }

                    }

                }

            )

        }

        composable("dashboard") {

            DashboardScreen(

                dashboardViewModel = dashboardViewModel,

                irListaEquipos = {

                    navController.navigate(
                        "equipos"
                    )

                },

                irPrestamos = {

                    navController.navigate(
                        "prestamos"
                    )

                },

                irHistorial = {

                    navController.navigate(
                        "historial"
                    )

                },

                irReportes = {

                    navController.navigate(
                        "reportes"
                    )

                }

            )

        }

        composable("equipos") {

            ListaEquiposScreen(

                equipoViewModel = equipoViewModel,

                onAgregarEquipo = {

                    navController.navigate(
                        "agregar_equipo"
                    )

                },

                onEditarEquipo = {

                    navController.navigate(
                        "editar_equipo/$it"
                    )

                }

            )

        }

        composable(
            route = "editar_equipo/{id}",

            arguments = listOf(

                navArgument("id") {

                    type = NavType.IntType

                }

            )

        ) {

            val id =
                it.arguments?.getInt("id")
                    ?: 0

            EditarEquipoScreen(

                equipoId = id,

                equipoViewModel = equipoViewModel,

                onGuardar = {

                    navController.popBackStack()

                }

            )

        }

        composable(
            "agregar_equipo"
        ) {

            AgregarEquipoScreen(

                equipoViewModel = equipoViewModel,

                onGuardar = {

                    navController.popBackStack()

                }

            )

        }

        composable(
            "prestamos"
        ) {

            PrestamoScreen(

                equipoViewModel = equipoViewModel,

                prestamoViewModel = prestamoViewModel

            )

        }

        composable(
            "historial"
        ) {

            HistorialScreen(

                prestamoViewModel = prestamoViewModel

            )

        }

        composable(
            "reportes"
        ) {

            ReporteScreen(

                dashboardViewModel = dashboardViewModel

            )

        }

    }

}