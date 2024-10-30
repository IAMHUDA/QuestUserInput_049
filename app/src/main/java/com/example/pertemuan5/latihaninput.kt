package com.example.pertemuan5

import android.graphics.drawable.shapes.Shape
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun latihaninput(modifier: Modifier) {
    var nama by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var notelpon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var memilihjk by remember { mutableStateOf("") }

    val listjk = listOf("laki-laki", "perempuan")

    var simpannama by remember { mutableStateOf("") }
    var simpanemail by remember { mutableStateOf("") }
    var simpannotelpon by remember { mutableStateOf("") }
    var simpanalamat by remember { mutableStateOf("") }
    var simpanmemilihjk by remember { mutableStateOf("") }

    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        Text("Biodata", fontSize = 30.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.padding(16.dp))
        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = nama,
            onValueChange = {nama = it},
            label = {
                Text("nama")
            },
            placeholder = {
                Text("isi nama anda")
            }
        )
        Row {
            listjk.forEach { item ->
                Row (verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = memilihjk == item,
                        onClick = {
                            memilihjk = item
                        }
                    )
                    Text(
                        text = item
                    )
                }
            }
        }
        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = email,
            onValueChange = {email = it},
            label = {
                Text("email")
            },
            placeholder = {
                Text("isi email anda")
            }
        )
        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = notelpon,
            onValueChange = {notelpon = it},
            label = {
                Text("notelpon")
            },
            placeholder = {
                Text("isi notelpon anda")
            }
        )
        OutlinedTextField(
            shape = RoundedCornerShape(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            value = alamat,
            onValueChange = {alamat = it},
            label = {
                Text("alamat")
            },
            placeholder = {
                Text("isi alamat anda")
            }
        )
        Button (
            onClick = {
                simpannama = nama
                simpanemail = email
                simpannotelpon = notelpon
                simpanalamat = alamat
                simpanmemilihjk = memilihjk
            }
        ) {
            Text(text = "submit")
        }
        ElevatedCard(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray),
            colors = CardDefaults.elevatedCardColors(
                containerColor = Color.Red,
                contentColor = Color.Black //
            )

        ) {
            Detail(judul = "nama", isinya = simpannama)
            Detail(judul = "jenis kelamin", isinya = simpanmemilihjk)
            Detail(judul = "email", isinya = simpanemail)
            Detail(judul = "no telpon", isinya = simpannotelpon)
            Detail(judul = "alamat", isinya = simpanalamat)
        }

    }
}

@Composable
fun Detail(judul:String,isinya:String) {
    Row (modifier = Modifier.fillMaxWidth()
        .padding(top = 20.dp)){
        Text(
            text = judul,
            modifier = Modifier.weight(0.8f)
        )
        Text(
            text = ":",
            modifier = Modifier.weight(0.2f)
        )
        Text(
            text = isinya,
            modifier = Modifier.weight(2f)
        )
    }
}

