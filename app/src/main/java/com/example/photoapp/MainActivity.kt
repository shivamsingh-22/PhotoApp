package com.example.photoapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.photoapp.ui.theme.PhotoAppTheme

class MainActivity : ComponentActivity() {

    private var currentimage=0
    lateinit var image: ImageView
    var place=arrayOf("Prayagraj Junction","Airport","New Bridge","Anand Bhavan","Allahabad High Court","Allahabad University","Allahabad Museum","Allahabad Clock Tower","Allahabad Library","Allahabad Fort","Minto Park","khusrobagh","Sangam Vihar","Akshayavat","HanumanJi Temple","Kalyani Devi Temple","Nagvasuki Mandir","ShivJi Temple 'Naulakha Mandir' ")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val pre=findViewById<ImageButton>(R.id.btnpre)
        val next=findViewById<ImageButton>(R.id.btnnext)
        var placeName=findViewById<TextView>(R.id.textView1)

        pre.setOnClickListener {
            // i want to get pre image
            var idcurretimagestring="pic$currentimage"

            // i want to get int address associated with each pic
            var idcurrentimageint=this.resources.getIdentifier(idcurretimagestring,"id",packageName)
            image=findViewById<ImageButton>(idcurrentimageint)
            image.alpha=0f
            currentimage=(18+currentimage-1)%18

            var idToShowimage="pic$currentimage"
            var idToShowimageint=this.resources.getIdentifier(idToShowimage,"id",packageName)
            image=findViewById<ImageButton>(idToShowimageint)
             //Finds the new image and makes it visible (alpha = 1f = fully visible).
            image.alpha=1f

            placeName.text=place[currentimage]
        }

        next.setOnClickListener {
            // i want to get next image
            var idcurretimagestring="pic$currentimage"

            // i want to get int address associated with each pic
            var idcurrentimageint=this.resources.getIdentifier(idcurretimagestring,"id",packageName)
            image=findViewById<ImageButton>(idcurrentimageint)
            //Makes the current image invisible (alpha = 0 means fully transparent).
            image.alpha=0f

            currentimage=(18+currentimage+1)%18
            var idToShowimage="pic$currentimage"
            var idToShowimageint=this.resources.getIdentifier(idToShowimage,"id",packageName)
            image=findViewById<ImageButton>(idToShowimageint)
            image.alpha=1f

            placeName.text=place[currentimage]

        }

    }
}
