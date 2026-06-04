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
import ni.edu.uam.inventariomanager.model.Equipo
import ni.edu.uam.inventariomanager.viewmodel.EquipoViewModel

@Composable
fun AgregarEquipoScreen(

    equipoViewModel: EquipoViewModel,

    onGuardar: () -> Unit

) {

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

                Text("Número de serie")

            }

        )

        Button(

            onClick = {

                val equipo = Equipo(

                    nombre = nombre,

                    categoria = categoria,

                    marca = marca,

                    numeroSerie = numeroSerie,

                    disponible = true

                )

                equipoViewModel.guardar(
                    equipo
                )

                onGuardar()

            },

            modifier = Modifier.fillMaxWidth()

        ) {

            Text("Guardar")

        }

    }

}