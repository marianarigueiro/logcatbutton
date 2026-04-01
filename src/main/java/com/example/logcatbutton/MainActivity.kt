package com.example.logcatbutton

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.material3.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.logcatbutton.ui.theme.*

const val TAG = "TesteAndroid"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogcatButtonTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    var nome by remember { mutableStateOf("") }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundLight // cor mais clean
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // LOGO
            Image(
                painter = painterResource(R.drawable.eteclogo),
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(180.dp)
                    .height(120.dp)
            )

            // TÍTULO
            Text(
                text = "Sistema de Notas",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            // INPUT
            TextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Digite seu nome") },
                modifier = Modifier.fillMaxWidth(0.85f)
            )

            // BOTÕES
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                ActionButton("Insuficiente", ErrorButtonColors()) {
                    Log.e(TAG, "$nome tirou I")
                }

                ActionButton("Regular", WarningButtonColors()) {
                    Log.w(TAG, "$nome tirou R")
                }

                ActionButton("Bom", DebugButtonColors()) {
                    Log.d(TAG, "$nome tirou B")
                }

                ActionButton("Muito Bom", InfoButtonColors()) {
                    Log.i(TAG, "$nome tirou MB")
                }
            }
        }
    }
}

@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    ElevatedButton(
        onClick = onClick,
        shape = RoundedCornerShape(12.dp),
        colors = buttonColors,
        modifier = modifier
            .fillMaxWidth(0.6f)
            .height(55.dp)
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    LogcatButtonTheme {
        App()
    }
}