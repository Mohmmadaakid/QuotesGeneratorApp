package com.example.quoteappaakid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.quoteappaakid.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomePage : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var quoteTxt: TextView
    lateinit var quoteAth: TextView
    lateinit var progressBar: ProgressBar
    lateinit var nxtBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setContentView(R.layout.activity_home_page)
        quoteTxt=findViewById(R.id.quote_txt)
        quoteAth=findViewById(R.id.quotAuthr)
        nxtBtn=findViewById(R.id.nextBtn)
        progressBar=findViewById(R.id.prgrsBar)

        getQuote()
        nxtBtn.setOnClickListener(View.OnClickListener { getQuote() })

    }

    private fun getQuote() {
        setInProgress(true)

        GlobalScope.launch {
            try {
                val response = RetrofitInstance.quoteApi.getRandomQuote()
                runOnUiThread {
                    setInProgress(false)
                    response.body()?.first()?.let { setUI(it) }
                }
            } catch (e: Exception){

            }
        }

    }

    private fun setUI(quote : QuoteModel){
        quoteTxt.text=quote.q
        quoteAth.text=quote.a
    }


    private fun setInProgress(inProgress : Boolean)
    {
        if (inProgress)
        {
            progressBar.visibility=View.VISIBLE
            nxtBtn.visibility=View.GONE


        }
        else
        {
            progressBar.visibility=View.GONE
            nxtBtn.visibility=View.VISIBLE
        }
    }

}