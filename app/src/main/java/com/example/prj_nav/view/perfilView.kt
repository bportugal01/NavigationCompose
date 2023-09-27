package com.example.prj_navegacao.views

import android.content.ContentValues.TAG
import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.prj_nav.R
import com.example.prj_nav.components.ActionButton
import com.example.prj_nav.components.TitleView
import com.example.prj_nav.ui.theme.DebugButtonCollors
import com.example.prj_nav.ui.theme.darkGreen
import kotlinx.coroutines.delay


@Composable
fun PerfilView() {
    var name by remember { mutableStateOf(TextFieldValue("Bruno Santos Portugal")) }
    var email by remember { mutableStateOf(TextFieldValue("bruno.portugal01@etec.sp.gov.br")) }
    var phoneNumber by remember { mutableStateOf(TextFieldValue("RM : 22295")) }
    var isButtonClicked by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFFf8e3e7),
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(30.dp))
                TitleView(name = "Perfil")
                Spacer(modifier = Modifier.height(16.dp))
                Box(
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(70.dp))
                        .background(Color.Gray), contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.bruno),
                        contentDescription = null,
                        modifier = Modifier

                            .fillMaxSize() // Para fazer a imagem preencher o círculo inteiro
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                BasicTextField(
                    value = name,
                    onValueChange = { name = it },

                    textStyle = androidx.compose.material.MaterialTheme.typography.h6,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Text
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                BasicTextField(
                    value = email,
                    onValueChange = { email = it },
                    textStyle = androidx.compose.material.MaterialTheme.typography.body1,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Email, imeAction = ImeAction.Next
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                )

                BasicTextField(
                    value = phoneNumber,
                    onValueChange = { phoneNumber = it },
                    textStyle = androidx.compose.material.MaterialTheme.typography.body1,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Phone, imeAction = ImeAction.Done
                    ),
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        ActionButton(
            text = "Salvar",
            icon = Icons.Filled.Check,
            buttonColors = DebugButtonCollors(),
            modifier = Modifier

                .padding(8.dp)
        ) {
            isButtonClicked = true
            //   Toast.makeText(context, "Clicou no Botão!", Toast.LENGTH_SHORT).show()
            Log.d(TAG, "App: Você clicou no Botão...")
        }
        AnimatedVisibility(
            visible = isButtonClicked, // Controla a visibilidade da tela de erro
            enter = fadeIn(), exit = fadeOut()
        ) {
            // Conteúdo da tela de erro
            Text(
                text = "Salvo com Sucesso",
                fontSize = 20.sp,
                color = darkGreen,
                fontWeight = FontWeight.Bold,

                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
                    .wrapContentWidth(Alignment.CenterHorizontally)
            )
        }
    }

    LaunchedEffect(
        isButtonClicked
    ) {
        if (isButtonClicked) {
            delay(1000) // Tempo em milissegundos para a tela de erro ficar visível
            isButtonClicked =
                false // Define a variável isErrorClicked como false para esconder a tela de erro
        }
    }
}
