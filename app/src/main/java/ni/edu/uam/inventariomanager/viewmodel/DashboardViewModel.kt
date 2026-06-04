package ni.edu.uam.inventariomanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ni.edu.uam.inventariomanager.model.Dashboard
import ni.edu.uam.inventariomanager.repository.DashboardRepository

class DashboardViewModel(
    private val repository: DashboardRepository
) : ViewModel() {

    private val _dashboard =
        MutableStateFlow(Dashboard())

    val dashboard: StateFlow<Dashboard> =
        _dashboard.asStateFlow()

    init {

        cargarDashboard()

    }

    fun cargarDashboard() {

        viewModelScope.launch {

            _dashboard.value =
                repository.obtenerDashboard()

        }

    }

}