package ni.edu.uam.inventariomanager.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun CampoTexto(

    valor: String,

    onValueChange: (String) -> Unit,

    label: String

) {

    OutlinedTextField(

        value = valor,

        onValueChange = onValueChange,

        label = {

            Text(label)

        },

        modifier = Modifier.fillMaxWidth()

    )

}