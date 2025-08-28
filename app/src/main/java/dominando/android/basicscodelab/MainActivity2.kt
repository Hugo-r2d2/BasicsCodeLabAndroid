package dominando.android.basicscodelab

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.view.Surface
import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dominando.android.basicscodelab.ui.theme.BasicsCodelabTheme

// Modelo simples para a resposta
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
//        color = MaterialTheme.colorScheme.primary,
        border = BorderStroke(
            1.dp,
            MaterialTheme.colorScheme.outline
        ),
        shape = MaterialTheme.shapes.small
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = answer.imageRes),
                contentDescription = answer.text,
                modifier = Modifier
                    .size(40.dp),
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
                onClick = { /* TODO: tratar clique no nível da lista/pai */ }
            )
        }
    }
}

/** Preview: duas opções, uma marcada, outra não */
@Preview(showBackground = true, widthDp = 360, name = "SurveyAnswer Preview (Light)")
@Preview(showBackground = true, widthDp = 360, uiMode = UI_MODE_NIGHT_YES, name = "SurveyAnswer Preview (Dark)")
@Composable
fun SurveyAnswerPreview() {
    BasicsCodelabTheme {
        Column(Modifier.fillMaxWidth()) {
            SurveyAnswer(
                Answer(
                    imageRes = R.drawable.thi_1749,
                    text = "Spark",
                    selected = true
                )
            )
        }
    }
}
