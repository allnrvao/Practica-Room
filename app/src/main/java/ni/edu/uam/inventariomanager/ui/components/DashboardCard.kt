package ni.edu.uam.inventariomanager.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DashboardCard(

    titulo: String,

    valor: Int

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),

        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp
        )

    ) {

        Column(

            modifier = Modifier.padding(
                20.dp
            ),

            verticalArrangement =
                Arrangement.spacedBy(
                    10.dp
                )

        ) {

            Text(

                text = titulo,

                style =
                    MaterialTheme.typography.titleMedium

            )

            Text(

                text = valor.toString(),

                style =
                    MaterialTheme.typography.headlineMedium

            )

        }

    }

}