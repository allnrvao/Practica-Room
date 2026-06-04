package ni.edu.uam.inventariomanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.flow.StateFlow
import ni.edu.uam.inventariomanager.model.Dashboard
import ni.edu.uam.inventariomanager.ui.components.DashboardCard
import ni.edu.uam.inventariomanager.viewmodel.DashboardViewModel

@Composable
fun ReporteScreen(

    dashboardViewModel: DashboardViewModel

) {

    val dashboard: Dashboard by dashboardViewModel.dashboard.collectAsState()

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