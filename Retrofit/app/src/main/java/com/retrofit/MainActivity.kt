package com.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.text)
        val retrofitService = RetrofitInstance.getRetrofitInstence()
            .create(AlbumService::class.java)

        val responseLiveData: LiveData<Response<Album>> =
        liveData {
//            val response = retrofitService.getAlbum()
//            emit(response)
            val specificAlbum = retrofitService.getSpecificAlbum(2)
            emit(specificAlbum)



        }
        responseLiveData.observe(this, Observer {
            val albumsList = it.body()?.listIterator()

            if(albumsList != null){
                while (albumsList.hasNext()){
                    var albumItem = albumsList.next().title
//                    Log.v("tagy", albumItem)

                    val result = "Album item: $albumItem \n"
                    textView.append(result)

                }
            }
        })
    }
}