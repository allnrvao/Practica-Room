package ni.edu.uam.inventariomanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ni.edu.uam.inventariomanager.model.Prestamo
import ni.edu.uam.inventariomanager.viewmodel.PrestamoViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun HistorialScreen(

    prestamoViewModel: PrestamoViewModel

) {

    val historial by
    prestamoViewModel.historial.collectAsStateWithLifecycle()

    LazyColumn(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement =
            Arrangement.spacedBy(8.dp)

    ) {

        items(historial) { prestamo ->

            PrestamoCard(

                prestamo = prestamo,

                onDevolver = {

                    if (prestamo.fechaDevolucion == null) {

                        val fechaActual =
                            SimpleDateFormat(
                                "dd/MM/yyyy",
                                Locale.getDefault()
                            ).format(
                                Date()
                            )

                        val actualizado =
                            prestamo.copy(
                                fechaDevolucion =
                                    fechaActual
                            )

                        prestamoViewModel
                            .registrarDevolucion(
                                actualizado
                            )

                    }

                }

            )

        }

    }

}

@Composable
fun PrestamoCard(

    prestamo: Prestamo,

    onDevolver: () -> Unit

) {

    Card(

        modifier = Modifier.fillMaxWidth()

    ) {

        Column(

            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),

            verticalArrangement =
                Arrangement.spacedBy(8.dp)

        ) {

            Text(

                text =
                    "Equipo ID: ${prestamo.equipoId}",

                style =
                    MaterialTheme.typography.titleMedium

            )

            Text(

                text =
                    "Solicitante: ${prestamo.solicitante}"

            )

            Text(

                text =
                    "Fecha de préstamo: ${prestamo.fechaPrestamo}"

            )

            Text(

                text =
                    "Fecha de devolución: ${
                        prestamo.fechaDevolucion
                            ?: "Pendiente"
                    }"

            )

            if (

                prestamo.fechaDevolucion == null

            ) {

                Button(

                    onClick = onDevolver

                ) {

                    Text(

                        text =
                            "Registrar devolución"

                    )

                }

            }

        }

    }

}