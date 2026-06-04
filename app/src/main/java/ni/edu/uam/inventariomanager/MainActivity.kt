package ni.edu.uam.inventariomanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import kotlinx.coroutines.launch
import ni.edu.uam.inventariomanager.database.AppDatabase
import ni.edu.uam.inventariomanager.model.Administrador
import ni.edu.uam.inventariomanager.navigation.NavGraph
import ni.edu.uam.inventariomanager.repository.AdministradorRepository
import ni.edu.uam.inventariomanager.repository.DashboardRepository
import ni.edu.uam.inventariomanager.repository.EquipoRepository
import ni.edu.uam.inventariomanager.repository.PrestamoRepository
import ni.edu.uam.inventariomanager.viewmodel.AppViewModelFactory
import ni.edu.uam.inventariomanager.viewmodel.DashboardViewModel
import ni.edu.uam.inventariomanager.viewmodel.EquipoViewModel
import ni.edu.uam.inventariomanager.viewmodel.LoginViewModel
import ni.edu.uam.inventariomanager.viewmodel.PrestamoViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        val db =
            AppDatabase.obtenerBaseDatos(
                applicationContext
            )

        // Crear administrador por defecto
        lifecycleScope.launch {

            val adminExistente =
                db.administradorDao()
                    .buscarPorUsuario(
                        "admin"
                    )

            if (adminExistente == null) {

                db.administradorDao()
                    .insertar(

                        Administrador(

                            usuario = "admin",

                            password = "admin123"

                        )

                    )

            }

        }

        setContent {

            val equipoRepository =
                EquipoRepository(
                    db.equipoDao()
                )

            val prestamoRepository =
                PrestamoRepository(
                    db.prestamoDao(),
                    db.equipoDao()
                )

            val dashboardRepository =
                DashboardRepository(
                    db.equipoDao()
                )

            val administradorRepository =
                AdministradorRepository(
                    db.administradorDao()
                )

            val factory =
                AppViewModelFactory(

                    equipoRepository,

                    prestamoRepository,

                    dashboardRepository,

                    administradorRepository

                )

            val equipoViewModel: EquipoViewModel =
                viewModel(
                    factory = factory
                )

            val prestamoViewModel: PrestamoViewModel =
                viewModel(
                    factory = factory
                )

            val dashboardViewModel: DashboardViewModel =
                viewModel(
                    factory = factory
                )

            val loginViewModel: LoginViewModel =
                viewModel(
                    factory = factory
                )

            NavGraph(

                loginViewModel =
                    loginViewModel,

                dashboardViewModel =
                    dashboardViewModel,

                equipoViewModel =
                    equipoViewModel,

                prestamoViewModel =
                    prestamoViewModel

            )

        }

    }

}