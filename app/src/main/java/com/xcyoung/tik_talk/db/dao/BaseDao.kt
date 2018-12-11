package com.xcyoung.tik_talk.db.dao

import androidx.room.*

/**
 * @author ChorYeung
 * @since 2018/12/11
 */
@Dao
abstract class BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)    //OnConflictStrategy.REPLACE表示如果已经有数据，那么就覆盖掉，按照主键判断
    abstract fun Insert(vararg items:T)

    @Delete
    abstract fun Delete(vararg items:T):Int

    @Update
    abstract fun Update(vararg items:T):Int
}