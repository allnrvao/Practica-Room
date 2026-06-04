package ni.edu.uam.inventariomanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ni.edu.uam.inventariomanager.viewmodel.LoginViewModel

@Composable
fun LoginScreen(

    loginViewModel: LoginViewModel,

    onLoginExitoso: () -> Unit

) {

    var usuario by remember {

        mutableStateOf("")

    }

    var password by remember {

        mutableStateOf("")

    }

    val loginExitoso by
    loginViewModel.loginExitoso.collectAsStateWithLifecycle()

    LaunchedEffect(loginExitoso) {

        if (loginExitoso) {

            onLoginExitoso()

        }

    }

    Column(

        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),

        verticalArrangement = Arrangement.Center,

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Card(

            modifier = Modifier.fillMaxWidth()

        ) {

            Column(

                modifier = Modifier.padding(20.dp),

                verticalArrangement = Arrangement.spacedBy(15.dp)

            ) {

                Text(

                    text = "Inicio de sesión",

                    style = MaterialTheme.typography.headlineSmall

                )

                OutlinedTextField(

                    value = usuario,

                    onValueChange = {

                        usuario = it

                    },

                    modifier = Modifier.fillMaxWidth(),

                    label = {

                        Text("Usuario")

                    }

                )

                OutlinedTextField(

                    value = password,

                    onValueChange = {

                        password = it

                    },

                    modifier = Modifier.fillMaxWidth(),

                    label = {

                        Text("Contraseña")

                    }

                )

                Button(

                    onClick = {

                        loginViewModel.login(

                            usuario,

                            password

                        )

                    },

                    modifier = Modifier.fillMaxWidth()

                ) {

                    Text("Ingresar")

                }

            }

        }

    }

}