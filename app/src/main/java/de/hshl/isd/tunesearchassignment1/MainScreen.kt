package de.hshl.isd.tunesearchassignment1

import android.util.Log
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import de.hshl.isd.explicitarchitecture.tunesearch.core.MockSearchTracksCommand
import de.hshl.isd.explicitarchitecture.tunesearch.core.ports.CollectionEntity
import de.hshl.isd.explicitarchitecture.tunesearch.core.ports.SearchTracksDTO

@Composable
fun MainScreen(navController: NavController) {
    val service = MockSearchTracksCommand()

    fun success(collections: List<CollectionEntity>) {
        Log.d("MainScreen",collections.toString())
    }

    fun failure(error: Throwable) {
        Log.e("MainScreen", error.localizedMessage!!)
    }

    service.execute(
        SearchTracksDTO("Search term"),
        ::success,
        ::failure
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Tune Search") })
        })
    {
        Text("Hello World")
    }

}