package com.example.gantestapplication.Activities

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.gantestapplication.R
import com.example.gantestapplication.models.BreakingCharacters
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)



        supportActionBar?.apply {
            title = "Detail"
            // show back button on toolbar
            // on back button press, it will navigate to parent activity
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val bundle: Bundle? = intent.extras
        val breakingCharacters: BreakingCharacters = intent.getParcelableExtra("detail")


        var tvName = findViewById<TextView>(R.id.tv_name)
        var tvOccupation = findViewById<TextView>(R.id.et_tv_occupation)
        var tvStatus = findViewById<TextView>(R.id.tv_status)
        var tvNickName = findViewById<TextView>(R.id.tv_nick_name)
        var tvAppearance = findViewById<TextView>(R.id.tv_appearance)
        var image = findViewById<ImageView>(R.id._detail_image_view)


        val occupationList: List<String>
        occupationList = breakingCharacters.occupation
        val appearanceList: List<Int>
        appearanceList = breakingCharacters.appearance
        tvName.text = breakingCharacters.name
        tvOccupation.text = occupationList.joinToString(",")
        tvNickName.text = breakingCharacters.nickname
        tvStatus.text = breakingCharacters.status
        tvAppearance.text =
            breakingCharacters.appearance.toString().replace("[", "").replace("]", "")
        Picasso.get().load(breakingCharacters.img).into(image)


    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}