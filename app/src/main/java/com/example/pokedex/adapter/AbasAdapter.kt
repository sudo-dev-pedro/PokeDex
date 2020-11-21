package com.example.pokedex.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pokedex.fragment.StatsFragment
import com.example.pokedex.model.Pokemon

class AbasAdapter(
        fragmentManager: FragmentManager,
        var bundle: Bundle
)
    : FragmentPagerAdapter(fragmentManager)
{

    private var fragments = mutableListOf<Fragment>()
    private var tituloAbas = mutableListOf<String>()
    private var data = mutableListOf<Bundle>()

    fun addFragment (fragment: Fragment, titulo: String, bundle: Bundle){
        fragments.add(fragment)
        tituloAbas.add(titulo)
        data.add(bundle)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {

        return when(position){
            0 -> {
                val fragmentStats = StatsFragment()
                fragmentStats.arguments = data[0]
                return fragmentStats
            }
            else -> fragments[position]
        }

        //return fragments[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tituloAbas[position]
    }
}