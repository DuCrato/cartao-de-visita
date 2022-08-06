package com.example.cartaodevisitas.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.example.cartaodevisitas.App
import com.example.cartaodevisitas.data.BusinessCard
import com.example.cartaodevisitas.databinding.ActivityAddBusinessCardBinding

class AddBusinessCard : AppCompatActivity() {

    private lateinit var binding: ActivityAddBusinessCardBinding

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBusinessCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        insertListeners()
    }

    private fun insertListeners() {
        binding.imgBtnClose.setOnClickListener {
            finish()
        }

        binding.btnSave.setOnClickListener {
            val businessCard = BusinessCard(
                name = binding.tilName.editText?.text.toString(),
                telefone = binding.tilPhone.editText?.text.toString(),
                email = binding.tilEmail.editText?.text.toString(),
                company = binding.tilCompany.editText?.text.toString()
            )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, "Salvo com sucesso", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}