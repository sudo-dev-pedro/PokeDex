package com.example.pokedex.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pokedex.fragment.AbilitiesFragment
import com.example.pokedex.fragment.EvolutionFragment
import com.example.pokedex.fragment.StatsFragment

class TabsAdapter(
    fragmentManager: FragmentManager,
    var bundle: Bundle
) : FragmentPagerAdapter(fragmentManager) {

    private var fragments = mutableListOf<Fragment>()
    private var tituloAbas = mutableListOf<String>()
    private var data = mutableListOf<Bundle>()

    fun addFragment(fragment: Fragment, titulo: String, bundle: Bundle) {
        fragments.add(fragment)
        tituloAbas.add(titulo)
        data.add(bundle)
    }

    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {

        return when (position) {
            0 -> {
                val fragmentStats = StatsFragment()
                fragmentStats.arguments = data[0]
                return fragmentStats
            }

            1 -> {
                val fragmentEvolutions = EvolutionFragment()
                fragmentEvolutions.arguments = data[1]
                return fragmentEvolutions
            }

            2 -> {
                val fragmentAbilities = AbilitiesFragment()
                fragmentAbilities.arguments = data[2]
                return fragmentAbilities
            }

            else -> fragments[position]
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return tituloAbas[position]
    }
}