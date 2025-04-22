package com.himag09.composearticleejercicio3a

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.himag09.composearticleejercicio3a.ui.theme.ComposeArticleEjercicio3aTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeArticleEjercicio3aTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArticlePage(
                        title = stringResource(R.string.title_article),
                        firstDescription = stringResource(R.string.first_text_article),
                        secondDescription = stringResource(R.string.second_text_article),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ArticlePage(
    title: String,
    firstDescription: String,
    secondDescription: String,
    modifier: Modifier = Modifier
) {
    val imageCard = painterResource(R.drawable.bg_compose_background)
    Column(modifier = modifier) {
        Image(
            painter = imageCard, contentDescription = null
        )
        ArticleHeader(title = title, modifier = Modifier.padding(16.dp))
        ArticleContent(
            content = firstDescription, modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        ArticleContent(
            content = secondDescription,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)
        )
    }
}

@Composable
fun ArticleHeader(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title, fontSize = 24.sp, modifier = modifier
    )
}

@Composable
fun ArticleContent(content: String, modifier: Modifier = Modifier) {
    Text(
        text = content, textAlign = TextAlign.Justify, modifier = modifier
    )
}


@Preview(showBackground = true)
@Composable
fun ComposeArticlePreview() {
    ComposeArticleEjercicio3aTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            ArticlePage(
                title = stringResource(R.string.title_article),
                firstDescription = stringResource(R.string.first_text_article),
                secondDescription = stringResource(R.string.second_text_article),
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}