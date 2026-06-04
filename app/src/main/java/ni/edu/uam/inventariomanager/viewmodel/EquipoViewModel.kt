package ni.edu.uam.inventariomanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ni.edu.uam.inventariomanager.model.Equipo
import ni.edu.uam.inventariomanager.repository.EquipoRepository

class EquipoViewModel(
    private val repository: EquipoRepository
) : ViewModel() {

    private val _equipos = MutableStateFlow<List<Equipo>>(emptyList())
    val equipos: StateFlow<List<Equipo>> = _equipos.asStateFlow()

    init {

        viewModelScope.launch {

            repository.equipos.collect {

                _equipos.value = it

            }

        }

    }

    fun guardar(equipo: Equipo) {

        viewModelScope.launch {

            repository.insertar(equipo)

        }

    }

    suspend fun obtenerEquipo(
        id: Int
    ): Equipo? {

        return repository.obtenerPorId(id)

    }

    fun actualizar(equipo: Equipo) {

        viewModelScope.launch {

            repository.actualizar(equipo)

        }

    }

    fun eliminar(equipo: Equipo) {

        viewModelScope.launch {

            repository.eliminar(equipo)

        }

    }

}