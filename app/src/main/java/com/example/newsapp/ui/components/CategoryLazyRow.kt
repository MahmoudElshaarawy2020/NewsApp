package com.example.newsapp.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import com.example.domain.dto.SourceItem


@Composable
fun CategoryLazyRow(
    listOfSources: List<SourceItem>?,
    onClick: (String) -> Unit
) {
    // State to track the currently selected card
    var selectedSourceId by remember { mutableStateOf<String?>(null) }

    LazyRow(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        if (listOfSources != null) {
            items(listOfSources) { source ->
                val isSelected = source.id == selectedSourceId
                SourceCard(
                    sourceName = source.name ?: "Unknown Category",
                    isSelected = isSelected,
                    onClick = {
                        selectedSourceId = if (isSelected) null else source.id
                        onClick(source.id ?: "")
                    }
                )
            }
        }
    }
}
