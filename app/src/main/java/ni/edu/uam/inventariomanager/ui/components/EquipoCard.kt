package ni.edu.uam.inventariomanager.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ni.edu.uam.inventariomanager.model.Prestamo

@Composable
fun PrestamoCard(

    prestamo: Prestamo,

    onDevolver: () -> Unit

) {

    Card(

        modifier = Modifier.fillMaxWidth()

    ) {

        Column(

            modifier = Modifier.padding(16.dp),

            verticalArrangement =
                Arrangement.spacedBy(6.dp)

        ) {

            Text(

                text = "Equipo ID: ${prestamo.equipoId}",

                style =
                    MaterialTheme.typography.titleMedium

            )

            Text(

                text = "Solicitante: ${prestamo.solicitante}"

            )

            Text(

                text = "Fecha préstamo: ${prestamo.fechaPrestamo}"

            )

            Text(

                text =
                    "Fecha devolución: ${
                        prestamo.fechaDevolucion ?: "Pendiente"
                    }"

            )

            if (prestamo.fechaDevolucion == null) {

                Button(

                    onClick = onDevolver

                ) {

                    Text(
                        "Registrar devolución"
                    )

                }

            }

        }

    }

}