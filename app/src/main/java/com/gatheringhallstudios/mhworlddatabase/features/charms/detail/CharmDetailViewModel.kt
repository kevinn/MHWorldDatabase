package com.gatheringhallstudios.mhworlddatabase.features.charms.detail

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.Transformations
import com.gatheringhallstudios.mhworlddatabase.AppSettings
import com.gatheringhallstudios.mhworlddatabase.data.MHWDatabase
import com.gatheringhallstudios.mhworlddatabase.data.dao.CharmDao
import com.gatheringhallstudios.mhworlddatabase.data.models.CharmFull

class CharmDetailViewModel(application: Application) : AndroidViewModel(application) {
    private val charmDao: CharmDao = MHWDatabase.getDatabase(application).charmDao()

    private var id: Int = -1
    private var previousId: Int? = -1
    lateinit var charmFullData: LiveData<CharmFull>
    lateinit var previousCharm: LiveData<CharmFull>

    fun setCharm(charmId: Int) {
        if (this.id == charmId) {
            return
        }

        this.id = charmId
        charmFullData = charmDao.loadCharmFull(AppSettings.dataLocale, charmId)
        previousCharm = Transformations.switchMap(charmFullData, ::setPreviousItem)
    }

    private fun setPreviousItem(charmFullData: CharmFull): LiveData<CharmFull>? {
        val previousId = charmFullData.charm.previous_id
        if (previousId == null || this.previousId == previousId) {
            return null
        }

        this.previousId = previousId
        return charmDao.loadCharmFull(AppSettings.dataLocale, previousId)
    }
}