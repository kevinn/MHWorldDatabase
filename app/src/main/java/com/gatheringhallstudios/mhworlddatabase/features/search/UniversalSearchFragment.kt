package com.gatheringhallstudios.mhworlddatabase.features.search

import android.arch.lifecycle.*
import android.os.Bundle
import android.view.View
import com.gatheringhallstudios.mhworlddatabase.MainActivity
import com.gatheringhallstudios.mhworlddatabase.MainActivityViewModel
import com.gatheringhallstudios.mhworlddatabase.adapters.common.BasicListDelegationAdapter
import com.gatheringhallstudios.mhworlddatabase.adapters.SimpleUniversalBinderAdapterDelegate
import com.gatheringhallstudios.mhworlddatabase.common.RecyclerViewFragment
import com.gatheringhallstudios.mhworlddatabase.components.DashedDividerDrawable
import com.gatheringhallstudios.mhworlddatabase.components.StandardDivider


/**
 * The main fragment used to display search results
 */
class UniversalSearchFragment : RecyclerViewFragment() {

    private val activityViewModel by lazy {
        ViewModelProviders.of(activity!!).get(MainActivityViewModel::class.java)
    }

    private val searchViewModel by lazy {
        ViewModelProviders.of(this).get(UniversalSearchViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val adapter = SearchResultAdapter()
        setAdapter(adapter)

        // add decorator
        recyclerView.addItemDecoration(StandardDivider(DashedDividerDrawable(context!!)))

        // open up the search menu (if not open) if we're on this page
        // If the user hit back and returned to this page, we need to open it again
        activityViewModel.searchActive.value = true
        (activity as MainActivity).updateSearchView(searchViewModel.lastSearchFilter)

        activityViewModel.filter.observe(this, Observer {
            searchViewModel.searchData(it)
        })

        searchViewModel.searchResults.observe(this, Observer {
            if (it != null) adapter.bindSearchResults(it)
        })
    }

    override fun onDetach() {
        super.onDetach()

        activityViewModel.searchActive.value = false
    }

    override fun onDestroyView() {
        super.onDestroyView()

        activityViewModel.searchActive.value = false
    }
}