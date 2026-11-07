
package com.inkorigin.animationstudio

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
                    super.onCreate(savedInstanceState)

                            setContent {
                                            var folderUri by remember {
                                                                mutableStateOf<Uri?>(null)
                                            }

                                                        val folderPicker = rememberLauncherForActivityResult(
                                                                            contract = ActivityResultContracts.OpenDocumentTree()
                                                        ) { uri ->
                                                                        if (uri != null) {
                                                                                                try {
                                                                                                                            contentResolver.takePersistableUriPermission(
                                                                                                                                                            uri,
                                                                                                                                                                                        Intent.FLAG_GRANT_READ_URI_PERMISSION
                                                                                                                            )
                                                                                                                                                    folderUri = uri
                                                                                                } catch (e: Exception) {
                                                                                                                            folderUri = uri
                                                                                                }
                                                                        }
                                                        }

                                                                    MaterialTheme {
                                                                                        Surface(
                                                                                                                modifier = Modifier.fillMaxSize(),
                                                                                                                                    color = MaterialTheme.colorScheme.background
                                                                                        ) {
                                                                                                                Column(
                                                                                                                                            modifier = Modifier
                                                                                                                                                                        .fillMaxSize()
                                                                                                                                                                                                    .verticalScroll(rememberScrollState())
                                                                                                                                                                                                                                .padding(20.dp),
                                                                                                                                                                                                                                                        verticalArrangement = Arrangement.spacedBy(18.dp)
                                                                                                                ) {
                                                                                                                                            Text(
                                                                                                                                                                            "ANIMATION STUDIO",
                                                                                                                                                                                                        style = MaterialTheme.typography.headlineMedium
                                                                                                                                            )

                                                                                                                                                                    Text(
                                                                                                                                                                                                    "Create cinematic videos from your images, voice and subtitles."
                                                                                                                                                                    )

                                                                                                                                                                                            HorizontalDivider()

                                                                                                                                                                                                                    Text(
                                                                                                                                                                                                                                                    "01 — IMAGE IMPORT",
                                                                                                                                                                                                                                                                                style = MaterialTheme.typography.titleLarge
                                                                                                                                                                                                                    )

                                                                                                                                                                                                                                            Button(
                                                                                                                                                                                                                                                                            onClick = { folderPicker.launch(null) },
                                                                                                                                                                                                                                                                                                        modifier = Modifier.fillMaxWidth()
                                                                                                                                                                                                                                            ) {
                                                                                                                                                                                                                                                                            Text("Select Image Folder")
                                                                                                                                                                                                                                            }

                                                                                                                                                                                                                                                                    if (folderUri != null) {
                                                                                                                                                                                                                                                                                                    Text("Folder selected successfully!")
                                                                                                                                                                                                                                                                                                                                Text(
                                                                                                                                                                                                                                                                                                                                                                    folderUri.toString(),
                                                                                                                                                                                                                                                                                                                                                                                                    style = MaterialTheme.typography.bodySmall
                                                                                                                                                                                                                                                                                                                                )
                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                                                    Text("No folder selected yet.")
                                                                                                                                                                                                                                                                    }

                                                                                                                                                                                                                                                                                            HorizontalDivider()

                                                                                                                                                                                                                                                                                                                    Text(
                                                                                                                                                                                                                                                                                                                                                    "02 — SCENES",
                                                                                                                                                                                                                                                                                                                                                                                style = MaterialTheme.typography.titleLarge
                                                                                                                                                                                                                                                                                                                    )
                                                                                                                                                                                                                                                                                                                                            Text("Your imported scenes will appear here.")

                                                                                                                                                                                                                                                                                                                                                                    HorizontalDivider()

                                                                                                                                                                                                                                                                                                                                                                                            Text(
                                                                                                                                                                                                                                                                                                                                                                                                                            "03 — EXPORT",
                                                                                                                                                                                                                                                                                                                                                                                                                                                        style = MaterialTheme.typography.titleLarge
                                                                                                                                                                                                                                                                                                                                                                                            )
                                                                                                                                                                                                                                                                                                                                                                                                                    Text("Video export settings will appear here.")
                                                                                                                }
                                                                                        }
                                                                    }
                            }
        }
}