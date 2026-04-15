// Define o pacote do app (organização do projeto)
package com.example.logcatbutton

// Importa classes do Android
import android.content.Context // acesso a armazenamento local (SharedPreferences)
import android.os.Bundle // ciclo de vida da Activity
import android.util.Log // ferramenta de depuração (Logcat)

// Importa Jetpack Compose base
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// Componentes visuais do Compose
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape

// Estado reativo (Compose)
import androidx.compose.runtime.*

// Material Design 3
import androidx.compose.material3.*

// Ferramentas de UI
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Tema do projeto
import com.example.logcatbutton.ui.theme.*

/*
TAG usada no Logcat
Serve para identificar mensagens no console
*/
const val TAG = "TesteAndroid"

// Activity principal do app
class MainActivity : ComponentActivity() {

    // Função chamada quando o app inicia
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Define o conteúdo da tela usando Compose
        setContent {
            LogcatButtonTheme {
                App() // chama a interface principal
            }
        }
    }
}

// Função principal da interface (Compose)
@Composable
fun App() {

    // Pega o contexto do Android (necessário para SharedPreferences)
    val context = LocalContext.current

    // Cria ou acessa armazenamento interno do app
    val prefs = context.getSharedPreferences("dados", Context.MODE_PRIVATE)

    // Estado da variável nome (reativo na tela)
    var nome by remember {
        mutableStateOf(prefs.getString("nome", "") ?: "")
    }

    // Container principal da tela
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = BackgroundLight
    ) {

        // Layout em coluna (vertical)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // LOGO DO APP
            Image(
                painter = painterResource(R.drawable.eteclogo2),
                contentDescription = "Logo",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .width(180.dp)
                    .height(120.dp)
            )

            // TÍTULO DO APP
            Text(
                text = "Sistema de Notas",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )

            // AUTOR DO APP
            Text(
                text = "por Mariana Rigueiro",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.secondary
            )

            // CAMPO DE TEXTO (INPUT)
            TextField(
                value = nome, // valor atual
                onValueChange = { novoNome ->

                    // atualiza estado
                    nome = novoNome

                    // salva automaticamente no armazenamento interno
                    prefs.edit().putString("nome", nome).apply()
                },
                label = { Text("Digite seu nome") },
                modifier = Modifier.fillMaxWidth(0.85f)
            )

            // COLUNA DOS BOTÕES
            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // BOTÃO: INSUFICIENTE
                ActionButton("Insuficiente", ErrorButtonColors()) {
                    prefs.edit().putString("nome", nome).apply()
                    Log.e(TAG, "$nome tirou I") // erro no Logcat
                }

                // BOTÃO: REGULAR
                ActionButton("Regular", WarningButtonColors()) {
                    prefs.edit().putString("nome", nome).apply()
                    Log.w(TAG, "$nome tirou R") // warning
                }

                // BOTÃO: BOM
                ActionButton("Bom", DebugButtonColors()) {
                    prefs.edit().putString("nome", nome).apply()
                    Log.d(TAG, "$nome tirou B") // debug
                }

                // BOTÃO: MUITO BOM
                ActionButton("Muito Bom", InfoButtonColors()) {
                    prefs.edit().putString("nome", nome).apply()
                    Log.i(TAG, "$nome tirou MB") // info
                }
            }
        }
    }
}

// FUNÇÃO REUTILIZÁVEL DE BOTÃO PERSONALIZADO
@Composable
fun ActionButton(
    text: String,
    buttonColors: ButtonColors,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {

    ElevatedButton(
        onClick = onClick,
        shape = RoundedCornerShape(16.dp),
        colors = buttonColors,
        modifier = modifier
            .fillMaxWidth(0.7f)
            .height(55.dp)
    ) {

        Text(
            text = text,
            fontWeight = FontWeight.SemiBold
        )
    }
}

// PREVIEW (SÓ PARA VISUALIZAR NO ANDROID STUDIO)
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    LogcatButtonTheme {
        App()
    }
}
