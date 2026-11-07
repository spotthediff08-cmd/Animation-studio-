package com.inkorigin.animationstudio

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { AnimationStudioApp() }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimationStudioApp() {
    var selected by remember { mutableStateOf("Home") }
    val tabs = listOf("Home", "Scenes", "Export")
    MaterialTheme(colorScheme = darkColorScheme()) {
        Scaffold(
            topBar = { TopAppBar(title = { Text("Animation Studio") }) },
            bottomBar = {
                NavigationBar {
                    tabs.forEach { tab ->
                        NavigationBarItem(
                            selected = selected == tab,
                            onClick = { selected = tab },
                            icon = {},
                            label = { Text(tab) }
                        )
                    }
                }
            }
        ) { padding ->
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(padding).padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                item { Text(selected, style = MaterialTheme.typography.headlineMedium) }
                item {
                    Text(
                        when (selected) {
                            "Scenes" -> "Scene import, filename sequence sorting, per-scene duration and camera motion controls will be added here."
                            "Export" -> "Video resolution, preview and export controls will be added here."
                            else -> "Your offline image + voice + SRT video studio. This is the starter interface."
                        }
                    )
                }
                item { ElevatedCard { Text("Starter project scaffold — features are not implemented yet.", Modifier.padding(16.dp)) } }
            }
        }
    }
}
