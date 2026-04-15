// Pacote onde ficam os arquivos de tema do app
package com.example.logcatbutton.ui.theme

// Importa versão do Android para checar recursos (ex: Material You)
import android.os.Build

// Detecta se o sistema está no modo escuro
import androidx.compose.foundation.isSystemInDarkTheme

// Componentes do Material 3 (tema visual do app)
import androidx.compose.material3.*

// Permite usar funções Compose
import androidx.compose.runtime.Composable

// Permite acessar contexto do Android (necessário para cores dinâmicas)
import androidx.compose.ui.platform.LocalContext

// Classe de cores do Compose
import androidx.compose.ui.graphics.Color

/*
 ===========================
   PALETA MODO ESCURO
 ===========================
*/
private val DarkColorScheme = darkColorScheme(

    // Cor principal no modo escuro
    primary = PrimaryPurple,

    // Cor secundária no modo escuro
    secondary = DarkPurple,

    // Fundo da tela no modo escuro
    background = Color(0xFF1E1B2E)
)

/*
 ===========================
   PALETA MODO CLARO
 ===========================
*/
private val LightColorScheme = lightColorScheme(

    // Cor principal no modo claro
    primary = PrimaryPurple,

    // Cor secundária no modo claro
    secondary = DarkPurple,

    // Fundo da tela no modo claro
    background = BackgroundLight
)

/*
 ===========================
   TEMA PRINCIPAL DO APP
 ===========================
*/
@Composable
fun LogcatButtonTheme(

    // Detecta automaticamente se o sistema está em modo escuro
    darkTheme: Boolean = isSystemInDarkTheme(),

    // Permite usar cores automáticas do Android 12+ (Material You)
    dynamicColor: Boolean = true,

    // Conteúdo da tela (interface do app)
    content: @Composable () -> Unit
) {

    // Variável que escolhe qual paleta usar
    val colorScheme = when {

        // Se cores dinâmicas estiverem ativadas e Android for 12+
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {

            // Pega o contexto do Android
            val context = LocalContext.current

            // Se estiver no modo escuro usa paleta escura dinâmica
            if (darkTheme)
                dynamicDarkColorScheme(context)
            else
                dynamicLightColorScheme(context)
        }

        // Se não usar cores dinâmicas e estiver no modo escuro
        darkTheme -> DarkColorScheme

        // Caso contrário usa modo claro
        else -> LightColorScheme
    }

    // Aplica o tema em todo o app
    MaterialTheme(

        // Define cores do app
        colorScheme = colorScheme,

        // Define fontes do app (vem de Typography.kt)
        typography = Typography,

        // Conteúdo da tela
        content = content
    )
}

/*
 ===========================
   CORES DOS BOTÕES
 ===========================
*/

// Botão verde (ex: "Bom")
@Composable
fun DebugButtonColors() =
    ButtonDefaults.buttonColors(containerColor = SuccessGreen)

// Botão laranja (ex: "Regular")
@Composable
fun WarningButtonColors() =
    ButtonDefaults.buttonColors(containerColor = WarningOrange)

// Botão vermelho (ex: "Insuficiente")
@Composable
fun ErrorButtonColors() =
    ButtonDefaults.buttonColors(containerColor = ErrorRed)

// Botão roxo informativo (ex: "Muito Bom")
@Composable
fun InfoButtonColors() =
    ButtonDefaults.buttonColors(containerColor = InfoPurple)
