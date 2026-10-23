package me.alejandropradilla.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun PostCard(
    modifier: Modifier = Modifier,
    imageUrl: String = "https://avatars.githubusercontent.com/u/143735803?s=96&v=4",
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        PostHeader()

        Text(
            text = "Por fin termine esta cosa",
            modifier = Modifier.padding(horizontal = 12.dp),
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Imagen cargada desde Internet usando Coil (AsyncImage)
        AsyncImage(
            model = imageUrl,
            contentDescription = "Imagen de la publicación",
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(8.dp))

        PostStats()

        PostAction()
    }
}

@Preview(showBackground = true)
@Composable
fun PostCardPreview() {
    PostCard()
}
