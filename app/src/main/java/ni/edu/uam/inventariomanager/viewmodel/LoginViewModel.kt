package ni.edu.uam.inventariomanager.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ni.edu.uam.inventariomanager.repository.AdministradorRepository

class LoginViewModel(
    private val repository: AdministradorRepository
) : ViewModel() {

    private val _loginExitoso =
        MutableStateFlow(false)

    val loginExitoso: StateFlow<Boolean> =
        _loginExitoso.asStateFlow()

    fun login(
        usuario: String,
        password: String
    ) {

        viewModelScope.launch {

            val administrador =
                repository.login(
                    usuario,
                    password
                )

            _loginExitoso.value =
                administrador != null

        }

    }

}