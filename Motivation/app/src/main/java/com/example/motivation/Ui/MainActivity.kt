package com.example.motivation.Ui

import android.graphics.ColorFilter
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.motivation.Infra.MotivationConstants
import com.example.motivation.R
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.Infra.securityPreferences
import com.example.motivation.data.Mock

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstants.FILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        enableEdgeToEdge()

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        handleUserName()
        handleFilter(R.id.image_all)
        handleNextPhrase()

// EVENTOS de CLICK
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imagemSunny.setOnClickListener(this)
        binding.imageEmojiEmotions.setOnClickListener(this)


    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_newPhrase) {
            handleNextPhrase()
        } else if (view.id in listOf(
                R.id.image_all,
                R.id.imagem_sunny,
                R.id.image_emoji_emotions
            )
        )
        {
            handleFilter(view.id)
        }
    }

    private fun handleUserName() {
        val name = securityPreferences(this).getString("USER_NAME")
        binding.textUserName.text = "Ola,$name!"

    }

    private fun msg() {
        Toast.makeText(this, "Testando", Toast.LENGTH_SHORT).show()
    }

    private fun handleFilter(id: Int) {
        binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imagemSunny.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))
        binding.imageEmojiEmotions.setColorFilter(ContextCompat.getColor(this, R.color.dark_purple))


        //A linha acima "Pega a imagem (ImageALL) e define uma Cor
        when (id) {
            R.id.image_all -> {
                binding.imageAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId  = MotivationConstants.FILTER.ALL
            }
            R.id.imagem_sunny -> {
                binding.imagemSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.SUNNY
            }
            else -> {
                binding.imageEmojiEmotions.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstants.FILTER.EMOJIEMOTIONS

            }
        }

    }

    private fun handleNextPhrase(){
        binding.textPhrase.text = Mock().getPhrase(categoryId)

    }

}