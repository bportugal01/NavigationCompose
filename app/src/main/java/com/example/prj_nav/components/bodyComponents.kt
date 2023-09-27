package com.example.prj_nav.components


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleView(
    name: String,
) {
    Text(
        text = name, fontSize = 40.sp, fontWeight = FontWeight.Bold, color = Color(0xFFab3e60)
    )
}

@Composable
fun Space() {
    Spacer(
        modifier = Modifier.height(10.dp)
    )
}

@Composable
fun MainButton(name: String, backColor: Color, color: Color, onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp), onClick = onClick,

        shape = RoundedCornerShape(12.dp), // Define cantos quadrados
        colors = ButtonDefaults.buttonColors(
            contentColor = color,
            containerColor = backColor,
        )
    ) {
        Text(text = name, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)

    }

}

@Composable
fun ActionButton(
    text: String,
    icon: ImageVector,
    modifier: Modifier = Modifier,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(),
    block: () -> Unit,
) {
    ElevatedButton(
        onClick = block, shape = RoundedCornerShape(12.dp), colors = buttonColors,

        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Icon(
            imageVector = icon,
            tint = Color.White,
            contentDescription = "Executar",
            modifier = Modifier.size(ButtonDefaults.IconSize)
        )
        Spacer(Modifier.size(ButtonDefaults.IconSpacing))
        Text(text = text, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}