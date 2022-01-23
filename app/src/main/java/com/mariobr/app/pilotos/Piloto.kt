package com.mariobr.app.pilotos

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tb_piloto")
data class Piloto (
var nome:String,
var categoria:String,
var cidade:String,
var numero:Int
){
    @PrimaryKey(autoGenerate = true)
    var id:Long = 0;
}



