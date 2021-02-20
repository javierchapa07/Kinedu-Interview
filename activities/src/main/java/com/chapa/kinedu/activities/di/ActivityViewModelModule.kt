package com.chapa.kinedu.activities.di

import com.chapa.kinedu.activities.viewModel.ActivityViewModel
import com.chapa.kinedu.api.repository.ActivityRepository
import dagger.Module
import dagger.Provides

@Module
class ActivityViewModelModule {
    @Provides
    fun provideActivityViewModel(activityRepository: ActivityRepository):
            ActivityViewModel = ActivityViewModel(activityRepository)
}