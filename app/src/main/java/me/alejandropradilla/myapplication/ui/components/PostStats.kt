package me.alejandropradilla.myapplication.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PostStats(
    modifier: Modifier = Modifier,
    likesCount: String = "125",
    commentsCount: String = "45 comentarios",
    sharesCount: String = "12 compartidos",
    onLikesClick: () -> Unit = {},
    onCommentsClick: () -> Unit = {},
    onSharesClick: () -> Unit = {},
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        // Lado izquierdo: Reacción de Me gusta + número de likes
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.clickable(onClick = onLikesClick),
        ) {
            Box(
                modifier = Modifier
                    .size(18.dp)
                    .background(Color(0xFF1877F2), shape = CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    imageVector = Icons.Default.ThumbUp,
                    contentDescription = "Me gusta",
                    tint = Color.White,
                    modifier = Modifier.size(11.dp),
                )
            }

            Spacer(modifier = Modifier.width(6.dp))

            Text(
                text = likesCount,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
            )
        }

        // Lado derecho: Comentarios y compartidos
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            if (commentsCount.isNotEmpty()) {
                Text(
                    text = commentsCount,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.clickable(onClick = onCommentsClick),
                )
            }

            if (commentsCount.isNotEmpty() && sharesCount.isNotEmpty()) {
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "•",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                )
                Spacer(modifier = Modifier.width(6.dp))
            }

            if (sharesCount.isNotEmpty()) {
                Text(
                    text = sharesCount,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.clickable(onClick = onSharesClick),
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostStatsPreview() {
    PostStats()
}
