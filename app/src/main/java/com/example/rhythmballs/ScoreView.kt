package com.example.rhythmballs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ScoreView(
    score: Int, // Pontuação final do usuário
) {
    // Layout principal
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Fundo da tela
        Image(
            painter = painterResource(id = R.drawable.bg_list), // Fundo SVG
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop // Ajusta para cobrir toda a tela
        )

        // Conteúdo principal (pontuação e botão)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Texto que exibe a pontuação
            Text(
                text = "Pontuação: $score",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 40.dp)
            )

            // Botão invisível com SVG para confirmar
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent), // Fundo transparente
                shape = RoundedCornerShape(8.dp),
                modifier = Modifier.size(150.dp) // Tamanho do botão pode ser ajustado
            ) {
                // Ícone de confirmar (SVG)
                Image(
                    painter = painterResource(id = R.drawable.confirmar_login), // Substitua pelo seu SVG
                    contentDescription = "Confirmar",
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
