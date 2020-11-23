package com.example.pokedex.model

import android.os.Parcel
import android.os.Parcelable

class PokemonAbilities(
        val tituloHabilidade: String?,
        val descricaoHabilidade: String?
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(tituloHabilidade)
        parcel.writeString(descricaoHabilidade)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PokemonAbilities> {
        override fun createFromParcel(parcel: Parcel): PokemonAbilities {
            return PokemonAbilities(parcel)
        }

        override fun newArray(size: Int): Array<PokemonAbilities?> {
            return arrayOfNulls(size)
        }
    }
}