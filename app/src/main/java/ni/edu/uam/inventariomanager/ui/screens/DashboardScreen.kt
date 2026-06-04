package ni.edu.uam.inventariomanager.ui.screens

class DashboardScreen {
}package ni.edu.uam.inventariomanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ni.edu.uam.inventariomanager.ui.components.DashboardCard
import ni.edu.uam.inventariomanager.viewmodel.DashboardViewModel

@Composable
fun DashboardScreen(

    dashboardViewModel: DashboardViewModel,

    irListaEquipos: () -> Unit,

    irPrestamos: () -> Unit,

    irHistorial: () -> Unit,

    irReportes: () -> Unit

) {

    val dashboard by
    dashboardViewModel.dashboard.collectAsStateWithLifecycle()

    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp),

        verticalArrangement =
            Arrangement.spacedBy(10.dp)

    ) {

        item {

            DashboardCard(

                titulo = "Total de equipos",

                valor = dashboard.totalEquipos

            )

        }

        item {

            DashboardCard(

                titulo = "Equipos disponibles",

                valor = dashboard.disponibles

            )

        }

        item {

            DashboardCard(

                titulo = "Equipos prestados",

                valor = dashboard.prestados

            )

        }

        item {

            Column(

                verticalArrangement =
                    Arrangement.spacedBy(10.dp)

            ) {

                androidx.compose.material3.Button(

                    onClick = irListaEquipos

                ) {

                    androidx.compose.material3.Text(

                        "Gestión de Equipos"

                    )

                }

                androidx.compose.material3.Button(

                    onClick = irPrestamos

                ) {

                    androidx.compose.material3.Text(

                        "Registrar préstamo"

                    )

                }

                androidx.compose.material3.Button(

                    onClick = irHistorial

                ) {

                    androidx.compose.material3.Text(

                        "Historial"

                    )

                }

                androidx.compose.material3.Button(

                    onClick = irReportes

                ) {

                    androidx.compose.material3.Text(

                        "Reportes"

                    )

                }

            }

        }

    }

}