package com.mymenu

import android.app.Activity

class WorldCupDataModel {
     var countryName: String = ""
     var cupWins: String = ""
     var flagImage: Int = 0

    constructor(countryName: String, cupWins: String, flagImage: Int) {
        this.countryName = countryName
        this.cupWins = cupWins
        this.flagImage = flagImage
    }
}