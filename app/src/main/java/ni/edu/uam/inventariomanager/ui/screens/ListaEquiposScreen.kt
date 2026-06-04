package ni.edu.uam.inventariomanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ni.edu.uam.inventariomanager.model.Equipo
import ni.edu.uam.inventariomanager.ui.components.EquipoCard
import ni.edu.uam.inventariomanager.viewmodel.EquipoViewModel

@Composable
fun ListaEquiposScreen(

    equipoViewModel: EquipoViewModel,

    onAgregarEquipo: () -> Unit,

    onEditarEquipo: (Int) -> Unit

) {

    val equipos by
    equipoViewModel.equipos.collectAsStateWithLifecycle()

    var busqueda by remember {

        mutableStateOf("")

    }

    val listaFiltrada = equipos.filter {

        it.nombre.contains(
            busqueda,
            ignoreCase = true
        ) ||

                it.numeroSerie.contains(
                    busqueda,
                    ignoreCase = true
                )

    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),

        verticalArrangement = Arrangement.spacedBy(10.dp)

    ) {

        OutlinedTextField(

            value = busqueda,

            onValueChange = {

                busqueda = it

            },

            modifier = Modifier.fillMaxWidth(),

            label = {

                Text("Buscar por nombre o serie")

            }

        )

        Button(

            onClick = onAgregarEquipo,

            modifier = Modifier.fillMaxWidth()

        ) {

            Text("Agregar equipo")

        }

        LazyColumn(

            verticalArrangement =
                Arrangement.spacedBy(8.dp)

        ) {

            items(listaFiltrada) { equipo ->

                EquipoCard(

                    equipo = equipo,

                    onEditar = {

                        onEditarEquipo(
                            equipo.id
                        )

                    },

                    onEliminar = {

                        equipoViewModel.eliminar(
                            equipo
                        )

                    }

                )

            }

        }

    }

}