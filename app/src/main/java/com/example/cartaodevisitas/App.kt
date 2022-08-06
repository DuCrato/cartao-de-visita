package com.example.cartaodevisitas

import android.app.Application
import com.example.cartaodevisitas.data.AppDataBase
import com.example.cartaodevisitas.data.BusinessCardRepository

class App : Application() {
    val dataBase by lazy { AppDataBase.getDataBase(this) }
    val repository by lazy { BusinessCardRepository(dataBase.businessDao()) }
}