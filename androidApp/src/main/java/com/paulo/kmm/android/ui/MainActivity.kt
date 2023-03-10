package com.paulo.kmm.android.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.ExperimentalUnitApi
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.paulo.kmm.android.demos.FullScreenMessageDialog
import com.paulo.kmm.models.Story
import com.paulo.kmm.viewmodel.SampleViewModel
import com.paulo.kmm.viewmodel.ShimmerViewModel

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalUnitApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = SampleViewModel()

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                   /* val stories by viewModel.stories.collectAsState()
                    sqldDelight(viewModel, stories)*/
                    val shimmerViewModel = ShimmerViewModel()
                    ShimmerDemo(shimmerViewModel = shimmerViewModel)


                }
            }
        }
    }

    @Composable
    private fun ShimmerDemo(shimmerViewModel: ShimmerViewModel) {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background
        ) {

            FullScreenMessageDialog(
                icon = com.paulo.kmm.android.android.R.drawable.ic_android_black_24dp,
                iconTint = android.R.color.holo_red_light,
                title = "My Dialog",
                message = "This is my fancy body message!",
                bottomButtonText = "Toggle Shimmer",
                bottomButtonAction = { shimmerViewModel.toggle() },
                loadingState = shimmerViewModel.loading
            )
        }
    }

    @Composable
    @OptIn(ExperimentalUnitApi::class)
    private fun sqldDelight(viewModel: SampleViewModel, stories: List<Story>) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text(
                text = "SqldDelight KMM", style = LocalTextStyle.current.copy(
                    fontSize = TextUnit(24f, TextUnitType.Sp)
                )
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(onClick = { viewModel.loadStories() }) {
                    Text(
                        text = "Load", style = LocalTextStyle.current.copy(
                            fontSize = TextUnit(14f, TextUnitType.Sp)
                        )
                    )
                }
                Button(onClick = { viewModel.clear() }) {
                    Text(
                        text = "Clear", style = LocalTextStyle.current.copy(
                            fontSize = TextUnit(14f, TextUnitType.Sp)
                        )
                    )
                }
            }
            LazyColumn {
                items(stories) { item ->
                    Text(
                        text = item.name, style = LocalTextStyle.current.copy(
                            fontSize = TextUnit(24f, TextUnitType.Sp)
                        )
                    )

                }
            }
        }
    }
}

