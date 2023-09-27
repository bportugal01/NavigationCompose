package com.example.prj_nav.view


import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.prj_nav.components.MainButton
import com.example.prj_nav.components.TitleView



@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeView(navController: NavController) {

    val id = 123
    var opcional by remember { mutableStateOf("") }
    val logTag = "ContentHomeView"

    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFf8e3e7),
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            TitleView(name = "Navegação")
            Spacer(modifier = Modifier.height(16.dp))

            TextField(
                value = opcional,
                onValueChange = {
                    opcional = it
                    Log.d(logTag, "Texto digitado: $it")
                },
                label = {
                    Text(
                        text = "Opcional",
                        color = Color(0xE8CFA4AE)
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black
                ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    cursorColor = Color.DarkGray,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                ),
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = "Ícone"
                    )
                }
            )

            Spacer(modifier = Modifier.height(10.dp))

            MainButton(
                name = "Visualizar Detalhes",
                backColor = Color(0xFFab3e60),
                color = Color.White,
            ) {
                navController.navigate("Detail/${id}/?$opcional")
            }
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Bottom,
                horizontalAlignment = Alignment.End
            ) {
                // Adicione o FloatingActionButton aqui
                FloatingActionButton(
                    onClick = {
                        // Implemente a ação desejada ao clicar no botão "Adicionar" aqui
                    },
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(16.dp), // Adicione o padding desejado
                    containerColor = Color(0xFFd1738b), // Cor de fundo do botão
                    contentColor = Color.White // Cor do ícone do botão
                ) {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = "",
                        modifier = Modifier.size(30.dp)
                    )
                }
            }
        }
    }
}