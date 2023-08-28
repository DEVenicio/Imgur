package com.venicio.imgur.data.di

import com.venicio.imgur.data.repository.Repository
import com.venicio.imgur.viewmodel.ImgurViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    factory { Repository() }
    viewModel { ImgurViewModel(get()) }
}
