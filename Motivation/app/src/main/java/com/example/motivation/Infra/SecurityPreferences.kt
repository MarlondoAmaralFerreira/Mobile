package com.example.motivation.Infra

import android.content.Context
import android.content.SharedPreferences

class securityPreferences(context: Context) {
    // Cria a instancia
    private val security: SharedPreferences =
        context.getSharedPreferences("motivation", Context.MODE_PRIVATE)

    // Salva os Dados
    fun storeString(key: String, str: String) {
        security.edit().putString(key, str).apply()
    }

    // Pega dos dados
    fun getString(key: String): String {
       return security.getString(key, "")?: ""
    }
}