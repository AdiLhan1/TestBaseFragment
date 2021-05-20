package com.eapple.testbasefragmentapp.ui

import android.widget.Toast
import com.eapple.testbasefragmentapp.base.BaseFragment
import com.eapple.testbasefragmentapp.databinding.FragmentHomeBinding

//Здесь идет передача view в base fragment чтобы он понимал какой у него будет xml layout
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    //здесь имплементируется метод который находится в base fragment он вызван в onViewCreated()
    override fun setupView() {
        //можно работать с view в этом методе типо как инициализация
        Toast.makeText(requireContext(), "Hello world!", Toast.LENGTH_LONG).show()
    }
}