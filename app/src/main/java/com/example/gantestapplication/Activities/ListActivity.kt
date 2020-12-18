package com.example.gantestapplication

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.GridLayoutManager
import com.example.gantestapplication.helpers.BreakingCharacterAdapter
import com.example.gantestapplication.models.BreakingCharacters
import com.example.gantestapplication.services.BreakingCharacterServices
import com.example.gantestapplication.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ListActivity : AppCompatActivity() {
  //  private lateinit var toolbar : Toolbar
    lateinit var adapter: BreakingCharacterAdapter
    lateinit var list : List<BreakingCharacters>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        //  toolbar = findViewById(R.id.toolbar)
        loadBreakingBadCharacters()


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        val search = menu?.findItem(R.id.appSearchBar)
        val searchView = search?.actionView as SearchView
        searchView.queryHint = "Search"
        supportActionBar?.apply {
            title = "Breaking Characters"

        }

        searchView.setOnCloseListener {
            searchView.onActionViewCollapsed()
            recycler_view.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(this@ListActivity, 2)
                adapter = BreakingCharacterAdapter(list, this@ListActivity )
            }
            true
        }

        /* val closeButton: View? = searchView.findViewById(androidx.appcompat.R.id.search_close_btn)
         closeButton?.setOnClickListener {
             searchView.onActionViewCollapsed()
             true
             recycler_view.apply {
                 setHasFixedSize(true)
                 layoutManager = GridLayoutManager(this@ListActivity, 2)
                 adapter = BreakingCharacterAdapter(list)
             }
         }*/
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                //lateinit  var newlist : List<BreakingCharacters>
                val status : Boolean
                val anyMutableList = mutableListOf<BreakingCharacters>()

                list!!.forEach { event ->
                    if (event.name.contains(query.toString(), ignoreCase = true)) {

                        //  var   newlist = arrayListOf(event)
                        anyMutableList.add(event)
                        println("$anyMutableList")

                    }
                }
                if(anyMutableList.size==0){
                    status=false
                    Toast.makeText(this@ListActivity,"No Result Found",Toast.LENGTH_SHORT).show()
                }
                else{
                    status=true
                    recycler_view.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@ListActivity, 2)
                        adapter = BreakingCharacterAdapter(anyMutableList, this@ListActivity, )

                    }
                }


                return status
            }

            override fun onQueryTextChange(newText: String?): Boolean {
               // adapter.notifyDataSetChanged(newText)

                return false
            }
        })

        return super.onCreateOptionsMenu(menu)
    }


    private fun loadBreakingBadCharacters() {
        //initiate the service
        val destinationService = ServiceBuilder.buildService(BreakingCharacterServices::class.java)
        val requestCall = destinationService.getBreakingBadCharacterList()
        //make network call asynchronously
        requestCall.enqueue(object : Callback<List<BreakingCharacters>> {
            override fun onResponse(
                call: Call<List<BreakingCharacters>>,
                response: Response<List<BreakingCharacters>>
            ) {
                Log.d("Response", "onResponse: ${response.body()}")
                if (response.isSuccessful) {
                    list = response.body()!!
                    Log.d("Response", "list size : ${list.size}")
                    recycler_view.apply {
                        setHasFixedSize(true)
                        layoutManager = GridLayoutManager(this@ListActivity, 2)
                        adapter = BreakingCharacterAdapter(response.body()!!,this@ListActivity,)

                    }


                } else {
                    Toast.makeText(
                        this@ListActivity,
                        "Something went wrong ${response.message()}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            override fun onFailure(call: Call<List<BreakingCharacters>>, t: Throwable) {
                Toast.makeText(this@ListActivity, "Something went wrong Please try after some time", Toast.LENGTH_SHORT)
                    .show()
            }
        })

    }

  /*  override fun onCellClickListener(data: BreakingCharacters) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("detail", data.toString())
        startActivity(intent)
    }

    override fun onCellClickListener() {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("detail", list.toString())
        startActivity(intent)    }*/
}





