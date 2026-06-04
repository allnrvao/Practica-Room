package ni.edu.uam.inventariomanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ni.edu.uam.inventariomanager.model.Prestamo
import ni.edu.uam.inventariomanager.repository.PrestamoRepository

class PrestamoViewModel(
    private val repository: PrestamoRepository
) : ViewModel() {

    private val _historial =
        MutableStateFlow<List<Prestamo>>(emptyList())

    val historial: StateFlow<List<Prestamo>> =
        _historial.asStateFlow()

    init {

        viewModelScope.launch {

            repository.historial.collect {

                _historial.value = it

            }

        }

    }

    fun registrarPrestamo(
        prestamo: Prestamo
    ) {

        viewModelScope.launch {

            repository.registrarPrestamo(prestamo)

        }

    }

    fun registrarDevolucion(
        prestamo: Prestamo
    ) {

        viewModelScope.launch {

            repository.registrarDevolucion(prestamo)

        }

    }

    fun eliminar(
        prestamo: Prestamo
    ) {

        viewModelScope.launch {

            repository.eliminar(prestamo)

        }

    }

}