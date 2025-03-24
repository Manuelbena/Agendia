package com.example.agendia.authentication.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.agendia.ui.theme.TextColor
import com.example.agendia.ui.theme.esmerald


@Composable
fun LoginWithGoogleButton(
    onClick: () -> Unit,
    text: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(70.dp))
            .clickable { onClick() }
            .background(color = esmerald)
            .padding(6.dp),

        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center){
        Text(text = text, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = TextColor)

    }
}

@Preview
@Composable
fun LoginWithGoogleButtonPreview() {
    LoginWithGoogleButton({}, "Continue with Google",
        modifier = Modifier.fillMaxWidth(),)
}