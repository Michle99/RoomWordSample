package com.maridev.roomwordsample

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {
    // No need to cancel this scope as it'll be torn down w/ the process
    val applicationScope = CoroutineScope(SupervisorJob())
    /***
     * Using by lazy so the database & the repository are only created
     * when they are needed rather than when the application starts
     */
    val database by lazy {  WordRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { WordRepository(database.wordDao()) }
}