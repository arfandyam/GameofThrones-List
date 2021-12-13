package com.example.gameofthrones.UI.Home.Detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.gameofthrones.Detaildata.DataStatis
import com.example.gameofthrones.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_detail_character.*

class DetailCharacterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail_character, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Picasso.get()
            .load(DataStatis.imageUrl)
            .into(character_detail_img)
        character_firstname.text = DataStatis.firstName
        character_lastname.text = DataStatis.lastName
        character_fullname.text = DataStatis.fullName
        character_family.text = DataStatis.family
        character_title.text = DataStatis.title
        character_img_name.text = DataStatis.image
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) = DetailCharacterFragment()
    }
}