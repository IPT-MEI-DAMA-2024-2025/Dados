package pt.ipt.dama.dados

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random

class MainActivity : AppCompatActivity() {
    // esta é a primeira função a ser executada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // identificar o botão e capturar o evento 'on click'
        findViewById<Button>(R.id.button).setOnClickListener {
            rodaDado()
        }

    }

    /**
     * função que vai gerar um nº aleatório entre 1 e 6
     * para simular a rotação do dado
     */
    private fun rodaDado() {
        /* Algoritmo
         * 1 - gerar nº aleatório
         * 2 - com este nº, escolher a imagem a apresentar
         * 3 - mostrar a imagem + nº gerado no ecrã
         */

        // 1-
        val numero = Random().nextInt(6) + 1 // [1..6]

        // 2-
        val idImagemAMostrar = when (numero) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else -> R.drawable.empty_dice
        }

        // 3-
        val auxTxt = findViewById<TextView>(R.id.text_view)
        val auxImage: ImageView = findViewById(R.id.image_view)

        auxTxt.text = "$numero" // <=>   auxTxt.text = numero.toString()
        auxImage.setImageResource(idImagemAMostrar)
    }
}