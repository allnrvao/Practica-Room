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
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ni.edu.uam.inventariomanager.model.Prestamo
import ni.edu.uam.inventariomanager.viewmodel.EquipoViewModel
import ni.edu.uam.inventariomanager.viewmodel.PrestamoViewModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun PrestamoScreen(

    equipoViewModel: EquipoViewModel,

    prestamoViewModel: PrestamoViewModel

) {

    val equipos by
    equipoViewModel.equipos.collectAsStateWithLifecycle()

    var solicitante by remember {

        mutableStateOf("")

    }

    val disponibles = equipos.filter {

        it.disponible

    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement =
            Arrangement.spacedBy(10.dp)

    ) {

        OutlinedTextField(

            value = solicitante,

            onValueChange = {

                solicitante = it

            },

            modifier = Modifier.fillMaxWidth(),

            label = {

                Text("Solicitante")

            }

        )

        LazyColumn {

            items(disponibles) { equipo ->

                Card(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)

                ) {

                    Column(

                        modifier = Modifier
                            .padding(12.dp)

                    ) {

                        Text(

                            text = equipo.nombre

                        )

                        Text(

                            text = equipo.numeroSerie

                        )

                        Button(

                            onClick = {

                                val fechaActual =
                                    SimpleDateFormat(
                                        "dd/MM/yyyy",
                                        Locale.getDefault()
                                    ).format(
                                        Date()
                                    )

                                val prestamo = Prestamo(

                                    equipoId =
                                        equipo.id,

                                    solicitante =
                                        solicitante,

                                    fechaPrestamo =
                                        fechaActual,

                                    fechaDevolucion =
                                        null

                                )

                                prestamoViewModel
                                    .registrarPrestamo(
                                        prestamo
                                    )

                            }

                        ) {

                            Text(
                                "Prestar"
                            )

                        }

                    }

                }

            }

        }

    }

}