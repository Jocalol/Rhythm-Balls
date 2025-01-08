package com.example.rhythmballs

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
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

import com.example.rhythmballs.R
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlin.system.exitProcess

@Composable
fun MenuScreen(navController: NavController = rememberNavController()) {
    // Estrutura principal com fundo
    Box(
        modifier = Modifier.fillMaxSize() // Preenche toda a tela
    ) {
        // SVG como fundo da tela
        Image(
            painter = painterResource(id = R.drawable.bg_menu), // Substitua pelo ID do recurso SVG
            contentDescription = null, // Descrição para acessibilidade
            modifier = Modifier.fillMaxSize(), // Preenche toda a tela
            contentScale = ContentScale.Crop // Ajusta para cobrir a tela
        )

        // Conteúdo sobreposto ao fundo
        Column(
            modifier = Modifier
                .fillMaxSize() // Preenche a tela
                .padding(16.dp), // Adiciona espaço interno
            horizontalAlignment = Alignment.CenterHorizontally, // Alinha horizontalmente os itens ao centro
            verticalArrangement = Arrangement.Center // Centraliza os itens verticalmente
        ) {
            // Substituir o título por SVG
            Image(
                painter = painterResource(id = R.drawable.titulo_game), // Substitua pelo ID do recurso SVG do título
                contentDescription = "Título Rhythm Balls", // Descrição para acessibilidade
                modifier = Modifier
                    .height(150.dp) // Ajuste o tamanho do título
                    .padding(bottom = 70.dp), // Espaçamento inferior
                contentScale = ContentScale.Fit // Ajusta o tamanho do SVG
            )

            // Botão "Entrar no Jogo"
            Button(
                onClick = { navController.navigate("in_game") }, // Ação ao clicar no botão
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp), // Arredondamento dos cantos
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent // Remover a cor do botão
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Ícone do botão
                    Image(
                        painter = painterResource(id = R.drawable.play_menu),
                        contentDescription = null, // Descrição para acessibilidade
                        modifier = Modifier
                            .height(100.dp), // Tamanho do ícone
                        contentScale = ContentScale.Fit
                    )
                }
            }

            // Botão "Sair"
            Button(
                onClick = { exitProcess(-1) }, // Ação ao clicar no botão
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                shape = RoundedCornerShape(8.dp), // Arredondamento dos cantos
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent // Remover a cor do botão
                )
            ) {
                // Ícone do botão
                Image(
                    painter = painterResource(id = R.drawable.exit_menu),
                    contentDescription = null, // Descrição para acessibilidade
                    modifier = Modifier
                        .height(100.dp), // Tamanho do ícone
                    contentScale = ContentScale.Fit
                )
            }

            // Botão "Login"
            Button(
                onClick = { navController.navigate("login") }, // Ação ao clicar no botão
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 50.dp),
                shape = RoundedCornerShape(8.dp), // Arredondamento dos cantos
                colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent // Remover a cor do botão
                )
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Ícone do botão
                    Image(
                        painter = painterResource(id = R.drawable.login_menu),
                        contentDescription = null, // Descrição para acessibilidade
                        modifier = Modifier
                            .height(100.dp), // Tamanho do ícone
                        contentScale = ContentScale.Fit
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMenuScreen() {
    MenuScreen() // Chama a função principal com valores padrão
}
