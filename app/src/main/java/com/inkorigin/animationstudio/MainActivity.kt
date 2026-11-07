
package com.inkorigin.animationstudio
import coil.compose.AsyncImage
import androidx.documentfile.provider.DocumentFile
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

                                          var imageNames by remember {
                                               mutableStateOf<List<String>>(emptyList())
}

var imageUris by remember {
        mutableStateOf<List<Uri>>(emptyList())
}
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

val files = DocumentFile.fromTreeUri(this@MainActivity, uri)
    ?.listFiles()
        ?.filter {
                    it.isFile && it.name?.substringAfterLast(".")?.lowercase()
                                in listOf("png", "jpg", "jpeg", "webp")
        }
            ?: emptyList()

            imageUris = files.map { it.uri }
                                                                                                                                                    imageNames = DocumentFile.fromTreeUri(this@MainActivity, uri)
                                                                                                                                                        ?.listFiles()
                                                                                                                                                            ?.filter {
                                                                                                                                                                        it.isFile && it.name?.substringAfterLast(".")?.lowercase()
                                                                                                                                                                                    in listOf("png", "jpg", "jpeg", "webp")
                                                                                                                                                            }
                                                                                                                                                                ?.mapNotNull { it.name }

                                                                                                                                                                ?.sortedBy { name ->
                                                                                                                                                                    val base = name.substringBeforeLast(".")
                                                                                                                                                                        if (base.all { it.isDigit() }) {
                                                                                                                                                                                        "0${base.padStart(10, '0')}"
                                                                                                                                                                        } else {
                                                                                                                                                                                        "1${base.uppercase()}"
                                                                                                                                                                        }
                                                                                                                                                                }
                                                                                                                                                                        }
                                                                                                                                                                    ?: emptyList()
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

if (imageNames.isNotEmpty()) {
            Text(
                        "Imported Images: ${imageNames.size}",
                                style = MaterialTheme.typography.titleMedium
            )

                imageUris.forEach { imageUri ->
                        AsyncImage(
                                model = imageUri,
                                    contentDescription = "Scene image",
                                        modifier = Modifier.size(120.dp)
                        )
                            }
}
            )
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