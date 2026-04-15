// Define o pacote do tema (onde ficam estilos visuais do app)
package com.example.logcatbutton.ui.theme

// Importa o sistema de tipografia do Material 3
import androidx.compose.material3.Typography

// Importa estilo de texto (fonte, tamanho, espaçamento etc.)
import androidx.compose.ui.text.TextStyle

// Importa família de fontes (ex: padrão, serif, sans-serif)
import androidx.compose.ui.text.font.FontFamily

// Importa peso da fonte (normal, bold, medium etc.)
import androidx.compose.ui.text.font.FontWeight

// Importa unidade de tamanho de fonte em SP
import androidx.compose.ui.unit.sp

/*
 =========================================
   TIPOGRAFIA PADRÃO DO MATERIAL 3
 =========================================
*/

// Cria o conjunto de estilos de texto do app
val Typography = Typography(

    /*
     =========================
     TEXTO PRINCIPAL (body)
     =========================
    */
    bodyLarge = TextStyle(

        // Fonte padrão do sistema
        fontFamily = FontFamily.Default,

        // Peso normal (sem negrito)
        fontWeight = FontWeight.Normal,

        // Tamanho da fonte
        fontSize = 16.sp,

        // Espaço entre linhas
        lineHeight = 24.sp,

        // Espaço entre letras
        letterSpacing = 0.5.sp
    )

    /*
     =========================================
     OUTROS ESTILOS (comentados no código base)
     =========================================

     Esses estilos são opcionais e podem ser
     personalizados quando quiser.
    */

    /*
    titleLarge = TextStyle(

        // Fonte padrão
        fontFamily = FontFamily.Default,

        // Peso normal (poderia ser Bold)
        fontWeight = FontWeight.Normal,

        // Título maior
        fontSize = 22.sp,

        // Altura da linha maior para títulos
        lineHeight = 28.sp,

        // Sem espaçamento extra entre letras
        letterSpacing = 0.sp
    ),

    labelSmall = TextStyle(

        // Fonte padrão
        fontFamily = FontFamily.Default,

        // Peso médio (mais destacado que normal)
        fontWeight = FontWeight.Medium,

        // Texto pequeno (labels)
        fontSize = 11.sp,

        // Linha compacta
        lineHeight = 16.sp,

        // Pequeno espaçamento entre letras
        letterSpacing = 0.5.sp
    )
    */
)
