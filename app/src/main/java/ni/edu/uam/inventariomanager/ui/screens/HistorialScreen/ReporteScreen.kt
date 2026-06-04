package ni.edu.uam.inventariomanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ni.edu.uam.inventariomanager.ui.components.DashboardCard
import ni.edu.uam.inventariomanager.viewmodel.DashboardViewModel

@Composable
fun ReporteScreen(

    dashboardViewModel: DashboardViewModel

) {

    val dashboard by
    dashboardViewModel.dashboard.collectAsStateWithLifecycle()

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement =
            Arrangement.spacedBy(12.dp)

    ) {

        DashboardCard(

            titulo = "Total de equipos",

            valor = dashboard.totalEquipos

        )

        DashboardCard(

            titulo = "Equipos disponibles",

            valor = dashboard.disponibles

        )

        DashboardCard(

            titulo = "Equipos prestados",

            valor = dashboard.prestados

        )

    }

}