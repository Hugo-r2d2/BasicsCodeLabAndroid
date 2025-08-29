package dominando.android.basicscodelab

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dominando.android.basicscodelab.ui.theme.BasicsCodelabTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BasicsCodelabTheme {
                // Escolha aqui qual tela mostrar
                SurveyScreen()
                // GreetingCard() // só se quiser testar
            }
        }
    }
}

// ----------- GreetingCard (exemplo simples) -----------

@Composable
fun GreetingCard(modifier: Modifier = Modifier) {
    Surface(
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.surfaceVariant),
        shadowElevation = 8.dp,
        tonalElevation = 8.dp,
        modifier = modifier.padding(16.dp)
    ) {
        Text(
            text = "Hello Compose",
            modifier = Modifier.padding(24.dp),
            color = MaterialTheme.colorScheme.onPrimary,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}

// ----------- SurveyAnswer -----------

data class Answer(
    @DrawableRes val imageRes: Int,
    val text: String,
    val selected: Boolean
)

@Composable
fun SurveyAnswer(
    answer: Answer,
    modifier: Modifier = Modifier
) {
    Surface(
        border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline),
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp, horizontal = 8.dp)
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = answer.imageRes),
                contentDescription = answer.text,
                modifier = Modifier.size(40.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(Modifier.width(12.dp))

            Text(
                text = answer.text,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.weight(1f)
            )

            RadioButton(
                selected = answer.selected,
                onClick = { /* TODO: delegar clique para o pai */ }
            )
        }
    }
}

@Composable
fun SurveyScreen() {
    Column(modifier = Modifier.fillMaxWidth()) {
        SurveyAnswer(
            Answer(
                imageRes = R.drawable.thi_1749,
                text = "Opção A",
                selected = false
            )
        )
        SurveyAnswer(
            Answer(
                imageRes = android.R.drawable.ic_menu_call,
                text = "Opção B",
                selected = true
            )
        )
    }
}

// ----------- Previews -----------

@Preview(showBackground = true, widthDp = 320, name = "Greeting Light")
@Preview(showBackground = true, widthDp = 320, uiMode = UI_MODE_NIGHT_YES, name = "Greeting Dark")
@Composable
fun Greeting2Preview() {
    BasicsCodelabTheme {
        GreetingCard()
    }
}

@Preview(showBackground = true, widthDp = 360, name = "Survey Light")
@Preview(showBackground = true, widthDp = 360, uiMode = UI_MODE_NIGHT_YES, name = "Survey Dark")
@Composable
fun SurveyPreview() {
    BasicsCodelabTheme {
        SurveyScreen()
    }
}
