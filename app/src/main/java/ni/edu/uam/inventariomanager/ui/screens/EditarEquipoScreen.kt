package ni.edu.uam.inventariomanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import ni.edu.uam.inventariomanager.model.Equipo
import ni.edu.uam.inventariomanager.viewmodel.EquipoViewModel

@Composable
fun EditarEquipoScreen(

    equipoId: Int,

    equipoViewModel: EquipoViewModel,

    onGuardar: () -> Unit

) {

    val scope = rememberCoroutineScope()

    var equipo by remember {

        mutableStateOf<Equipo?>(null)

    }

    var nombre by remember {

        mutableStateOf("")

    }

    var categoria by remember {

        mutableStateOf("")

    }

    var marca by remember {

        mutableStateOf("")

    }

    var numeroSerie by remember {

        mutableStateOf("")

    }

    LaunchedEffect(Unit) {

        val resultado =
            equipoViewModel.obtenerEquipo(
                equipoId
            )

        resultado?.let {

            equipo = it

            nombre = it.nombre
            categoria = it.categoria
            marca = it.marca
            numeroSerie = it.numeroSerie

        }

    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement =
            Arrangement.spacedBy(12.dp)

    ) {

        OutlinedTextField(

            value = nombre,

            onValueChange = {

                nombre = it

            },

            modifier = Modifier.fillMaxWidth(),

            label = {

                Text("Nombre")

            }

        )

        OutlinedTextField(

            value = categoria,

            onValueChange = {

                categoria = it

            },

            modifier = Modifier.fillMaxWidth(),

            label = {

                Text("Categoría")

            }

        )

        OutlinedTextField(

            value = marca,

            onValueChange = {

                marca = it

            },

            modifier = Modifier.fillMaxWidth(),

            label = {

                Text("Marca")

            }

        )

        OutlinedTextField(

            value = numeroSerie,

            onValueChange = {

                numeroSerie = it

            },

            modifier = Modifier.fillMaxWidth(),

            label = {

                Text("Número de Serie")

            }

        )

        Button(

            onClick = {

                equipo?.let {

                    val actualizado = it.copy(

                        nombre = nombre,

                        categoria = categoria,

                        marca = marca,

                        numeroSerie = numeroSerie

                    )

                    scope.launch {

                        equipoViewModel.actualizar(
                            actualizado
                        )

                        onGuardar()

                    }

                }

            },

            modifier = Modifier.fillMaxWidth()

        ) {

            Text("Actualizar")

        }

    }

}