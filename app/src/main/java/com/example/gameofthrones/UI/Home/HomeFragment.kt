package com.example.gameofthrones.UI.Home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gameofthrones.Adapter.HomeAdapter
import com.example.gameofthrones.DataCharacterItem
import com.example.gameofthrones.Detaildata.DataStatis
import com.example.gameofthrones.R
import com.example.gameofthrones.UI.Home.Detail.DetailCharacterFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HomeFragment", "onCreate Called")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d("HomeFragment", "onCreateView Called")
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("HomeFragment", "onViewCreated Called")

        recyclerview_home.setHasFixedSize(true)
        recyclerview_home.layoutManager = GridLayoutManager(context, 2, LinearLayoutManager.VERTICAL, false)
        viewModel.getDataFromAPI(recyclerview_home, object : HomeViewModel.onClickListener{
            override fun onClick(character: DataCharacterItem) {
                DataStatis.fill(character)
                val fragment: Fragment = DetailCharacterFragment()
                val fragmentManager: FragmentManager = activity!!.supportFragmentManager
                val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
                fragmentTransaction.replace(R.id.container_fragment, fragment)
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeFragment", "onDestroy Called")
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) = HomeFragment()
    }
}