package com.example.motivation.data

import com.example.motivation.Infra.MotivationConstants
import kotlin.random.Random

class Mock {
    data class Phrase(val description: String, val category: Int)
        private val all = MotivationConstants.FILTER.ALL
        private val happy = MotivationConstants.FILTER.SUNNY
        private val emoji = MotivationConstants.FILTER.EMOJIEMOTIONS

        private val listPhrases: List<Phrase> = listOf(
            Phrase("Não sabendo que era impossível, foi lá e fez.", happy),
            Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", happy),
            Phrase("Quando está mais escuro, vemos mais estrelas!", happy),
            Phrase(
                "Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.",
                happy
            ),
            Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", happy),
            Phrase(
                "O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?",
                happy
            ),
            Phrase("A melhor maneira de prever o futuro é inventá-lo.", emoji),
            Phrase("Você perde todas as chances que você não aproveita.", emoji),
            Phrase("Fracasso é o condimento que dá sabor ao sucesso.", emoji),
            Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", emoji),
            Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", emoji),
            Phrase("Se você acredita, faz toda a diferença.", emoji),
            Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", emoji)
        )

        // Obtém frase aleatória de acordo com o filtro
        fun getPhrase(value: Int): String {
            val filtered = listPhrases.filter { (it.category == value || value == all) }

            // Número aleatório de 0 ao tamanho da lista retornada do filtro
            val rand = Random.nextInt(filtered.size)

            // Retorna string
            return filtered[rand].description
        }
    }
