package com.example.prj_nav.components


import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun TitleBar(
    name: String,
) {
    Text(
        text = name,
        fontSize = 16.sp,
        color = Color(0xFFEDF2FA),
        fontWeight = FontWeight.Bold
    )
}

@Composable
fun MainIconButton(
    icon: ImageVector,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick, // Recebendo uma função de clique como parâmetro
        modifier = Modifier.padding(8.dp), // Adicionando margens ao ícone
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color.White // Alterando a cor do ícone
        )
    }
}

