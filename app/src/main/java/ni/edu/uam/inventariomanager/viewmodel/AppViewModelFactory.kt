package ni.edu.uam.inventariomanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ni.edu.uam.inventariomanager.repository.AdministradorRepository
import ni.edu.uam.inventariomanager.repository.DashboardRepository
import ni.edu.uam.inventariomanager.repository.PrestamoRepository
import ni.edu.uam.inventariomanager.repository.EquipoRepository

class AppViewModelFactory(
    private val equipoRepository: EquipoRepository,
    private val prestamoRepository: PrestamoRepository,
    private val dashboardRepository: DashboardRepository,
    private val administradorRepository: AdministradorRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        return when {

            modelClass.isAssignableFrom(
                EquipoViewModel::class.java
            ) -> {

                EquipoViewModel(
                    equipoRepository
                ) as T

            }

            modelClass.isAssignableFrom(
                PrestamoViewModel::class.java
            ) -> {

                PrestamoViewModel(
                    prestamoRepository
                ) as T

            }

            modelClass.isAssignableFrom(
                DashboardViewModel::class.java
            ) -> {

                DashboardViewModel(
                    dashboardRepository
                ) as T

            }

            modelClass.isAssignableFrom(
                LoginViewModel::class.java
            ) -> {

                LoginViewModel(
                    administradorRepository
                ) as T

            }

            else -> throw IllegalArgumentException(
                "ViewModel desconocido"
            )

        }

    }

}