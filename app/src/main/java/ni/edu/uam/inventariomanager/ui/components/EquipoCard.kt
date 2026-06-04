package ni.edu.uam.inventariomanager.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ni.edu.uam.inventariomanager.model.Equipo

@Composable
fun EquipoCard(
    equipo: Equipo,
    onEditar: () -> Unit,
    onEliminar: () -> Unit
) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {

        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {

            Text(
                text = equipo.nombre,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = "Marca: ${equipo.marca}"
            )

            Text(
                text = "Categoría: ${equipo.categoria}"
            )

            Text(
                text = "Serie: ${equipo.numeroSerie}"
            )

            Text(
                text = if (equipo.disponible)
                    "Disponible"
                else
                    "Prestado"
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Button(
                    onClick = onEditar
                ) {

                    Text("Editar")

                }

                Button(
                    onClick = onEliminar
                ) {

                    Text("Eliminar")

                }

            }

        }

    }

}