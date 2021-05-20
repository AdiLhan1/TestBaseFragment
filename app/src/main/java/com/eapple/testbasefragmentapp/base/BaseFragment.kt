package com.eapple.testbasefragmentapp.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

/*через private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> T здесь используется для привязки
layout к фрагменту
*/
abstract class BaseFragment<T : ViewBinding>(
    private val inflate: (LayoutInflater, ViewGroup?, Boolean) -> T
) : Fragment() {

    private var _binding: T? = null
    val binding get() = _binding!!

   //Инициализация через view binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = inflate.invoke(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        /*Здесь чисто вызван метод чтобы не было лишнего кода,
        потом можно будет вызывать метод setupView и переиспользовать */
        setupView()
    }

    open fun setupView() {}
    //можно создать другие методы например для кликов, запросов и т.д также как и setupView()
}