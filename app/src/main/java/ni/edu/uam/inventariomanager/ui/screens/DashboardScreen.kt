package ni.edu.uam.inventariomanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ni.edu.uam.inventariomanager.viewmodel.DashboardViewModel

@Composable
fun DashboardScreen(
    dashboardViewModel: DashboardViewModel,
    irListaEquipos: () -> Unit,
    irPrestamos: () -> Unit,
    irHistorial: () -> Unit,
    irReportes: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Text(
            text = "Dashboard",
            style = MaterialTheme.typography.headlineMedium
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Gestión de Equipos"
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = irListaEquipos
                ) {

                    Text(
                        text = "Ver Inventario"
                    )

                }

            }

        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Préstamos"
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = irPrestamos
                ) {

                    Text(
                        text = "Registrar Préstamo"
                    )

                }

            }

        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Historial"

                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = irHistorial
                ) {

                    Text(
                        text = "Ver Historial"
                    )

                }

            }

        }

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(5.dp)
        ) {

            Column(
                modifier = Modifier.padding(16.dp)
            ) {

                Text(
                    text = "Reportes"
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = irReportes
                ) {

                    Text(
                        text = "Generar Reportes"
                    )

                }

            }

        }

    }

}