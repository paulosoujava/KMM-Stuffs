package com.paulo.kmm.android.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paulo.kmm.android.R
import com.paulo.kmm.android.ui.theme.AndroidAppTheme
import com.paulo.kmm.android.utils.DependencyInjectionForPreview
import com.paulo.kmm.resources.Resources
import com.paulo.kmm.resources.getPreviewImageResource
import com.paulo.kmm.resources.getTextResource
import com.paulo.kmm.viewmodels.OnBoardingImages
import com.paulo.kmm.viewmodels.OnBoardingTexts
import com.paulo.kmm.viewmodels.OnBoardingViewModel

@Composable
fun OnBoardingScreen(
    viewModel: OnBoardingViewModel
) {
    Surface {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxHeight(),
        ) {
            Column(
                modifier = Modifier
                    .verticalScroll(state = rememberScrollState())
                    .weight(weight = 1f, fill = true)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = viewModel.images.topImage.id),
                    contentDescription = ""
                )
                // DIMENSÃO COMPARTILHADA
                Spacer(modifier = Modifier.height(Resources.Dimen.button.height))
                Text(viewModel.texts.topImageText.localized)
                Image(
                    painter = painterResource(id = viewModel.images.middleImage.id),
                    contentDescription = ""
                )
                Text(
                    text = viewModel.texts.middleImageText.localized,
                    fontSize = Resources.FontSizing.large.size // FONTE COMPARTILHADA
                )
                Image(
                    painter = painterResource(id = viewModel.images.bottomImage.id),
                    contentDescription = ""
                )
                Text(viewModel.texts.bottomImageText.localized)
            }
        }
    }
}

@Preview
@Composable
fun OnBoardingPreview() {
    DependencyInjectionForPreview()
    AndroidAppTheme {
        Column {
            OnBoardingScreen(
                viewModel = OnBoardingViewModel(
                    images = OnBoardingImages(
                        topImage = getPreviewImageResource(R.drawable.ic_warning),
                        middleImage = getPreviewImageResource(R.drawable.ic_warning),
                        bottomImage = getPreviewImageResource(R.drawable.ic_warning)
                    ),
                    texts = OnBoardingTexts(
                        topImageText = getTextResource("Titulo: Hello Compose"),
                        middleImageText = getTextResource("Titulo: Eu consigo me"),
                        bottomImageText = getTextResource("Titulo: renderizar assim!")
                    )
                )
            )
        }
    }
}