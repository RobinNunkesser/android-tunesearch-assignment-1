package de.hshl.isd.tunesearchassignment1.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.hshl.isd.explicitarchitecture.tunesearch.core.MockSearchTracksCommand
import de.hshl.isd.explicitarchitecture.tunesearch.core.ports.CollectionEntity
import de.hshl.isd.explicitarchitecture.tunesearch.core.ports.SearchTracksDTO
import de.hshl.isd.tunesearchassignment1.R

class MainFragment : Fragment() {

    private val service = MockSearchTracksCommand()

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        service.execute(
                SearchTracksDTO("Search term"),
                ::success,
                ::failure
        )

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun success(collections: List<CollectionEntity>) {
        Log.d("MainFragment",collections.toString())
    }

    private fun failure(error: Throwable) {
        Log.e("MainFragment", error.localizedMessage)
    }
}