package com.mariobr.app.pilotos

import androidx.room.*

@Dao
interface PilotoDao {
    @Insert
    fun inserir(piloto: Piloto): Long

    @Insert
    fun insereDois(p1:Piloto, p2:Piloto)

    @Delete
    fun delete(piloto: Piloto): Int

    @Delete
    fun deletarVarios(vararg piloto: Piloto)

    @Query("DELETE FROM tb_piloto")
    fun deletaTodos()

    @Update
    fun atualizar(piloto: Piloto):Int

    @Query("SELECT * FROM tb_piloto")
    fun listAll(): Array<Piloto>

    @Query("SELECT * FROM tb_piloto")
    fun listAllAdapter(): MutableList<Piloto>

    @Query("SELECT * FROM tb_piloto WHERE id=:id")
    fun findById(id:Long):Piloto

    @Query("SELECT * FROM tb_piloto WHERE nome=:nome")
    fun findByName(nome:String):Piloto


}