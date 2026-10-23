package me.alejandropradilla.myapplication.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.MoreHoriz
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun PostHeader(
    modifier: Modifier = Modifier,
    userName: String = "Usuario de Facebook",
    postTime: String = "Hace 2 h",
    userIcon: ImageVector = Icons.Default.AccountCircle,
    onMoreClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Ícono de perfil / avatar a la izquierda
        Icon(
            imageVector = userIcon,
            contentDescription = "Foto de perfil",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape),
            tint = MaterialTheme.colorScheme.primary
        )

        Spacer(modifier = Modifier.width(10.dp))

        // Nombre y hora de activación/publicación en forma de columna
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = userName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = postTime,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Ícono de los 3 puntos a la derecha
        IconButton(onClick = onMoreClick) {
            Icon(
                imageVector = Icons.Default.MoreHoriz,
                contentDescription = "Más opciones"
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostHeaderPreview() {
    PostHeader()
}
