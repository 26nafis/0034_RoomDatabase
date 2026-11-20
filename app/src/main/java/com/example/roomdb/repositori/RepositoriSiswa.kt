package com.example.roomdb.repositori

import com.example.roomdb.room.Siswa
import com.example.roomdb.room.SiswaDao
import kotlinx.coroutines.flow.Flow

interface RepositoriSiswa {
    fun getAllSiswaStream(): Flow<List<Siswa>>
    suspend fun insertSiswa(siswa: Siswa)

    //edit : tambah 3 fungsi di bawah ini
    fun GetSiswaStream(id: Int): Flow<Siswa?>
    suspend fun deleteSiswa(siswa: Siswa)
    suspend fun updateSiswa(siswa: Siswa)
}

class OfflineRepositoriSiswa(
    private val siswaDao: SiswaDao
) : RepositoriSiswa {

    override fun getAllSiswaStream(): Flow<List<Siswa>> =
        siswaDao.getAllSiswa()

    override suspend fun insertSiswa(siswa: Siswa) =
        siswaDao.insert(siswa)

    //edit : tambah 3 fungsi di bawah ini
    override fun GetSiswaStream(id: Int): Flow<Siswa?> =
        siswaDao.getSiswa(id)

}
