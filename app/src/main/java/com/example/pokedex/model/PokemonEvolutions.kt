package com.example.pokedex.model

import android.os.Parcel
import android.os.Parcelable

class PokemonEvolutions(
    val evolutions: String?,
    val secondEvolution: String?
    //val imagemEvolucoes : String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(evolutions)
        parcel.writeString(secondEvolution)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonEvolutions> {
        override fun createFromParcel(parcel: Parcel): PokemonEvolutions {
            return PokemonEvolutions(parcel)
        }

        override fun newArray(size: Int): Array<PokemonEvolutions?> {
            return arrayOfNulls(size)
        }
    }
}