package com.paulo.kmm.android.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TopButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    OutlinedButton(modifier = modifier, onClick = onClick) {
        Text(text = text)
    }
}

@Composable
fun BottomButton(modifier: Modifier = Modifier, text: String, onClick: () -> Unit = {}) {
    Button(modifier = modifier, onClick = onClick) {
        Text(text = text)
    }
}

@Preview
@Composable
fun DialogButtonsPreview() {
    MyApplicationTheme {
        Column {
            TopButton(text = "Botão superior")
            Spacer(modifier = Modifier.height(12.dp))
            BottomButton(text = "Botão inferior")
        }
    }
}