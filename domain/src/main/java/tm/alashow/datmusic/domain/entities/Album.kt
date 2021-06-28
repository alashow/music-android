/*
 * Copyright (C) 2021, Alashov Berkeli
 * All rights reserved.
 */
package tm.alashow.datmusic.domain.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import tm.alashow.domain.models.BasePaginatedEntity

@Parcelize
@Serializable
@Entity(tableName = "albums")
data class Album(
    @SerialName("id")
    val _id: Long = 0L,

    @Transient
    @ColumnInfo(name = "id")
    override val id: String = _id.toString(),

    @SerialName("access_key")
    @ColumnInfo(name = "access_key")
    val accessKey: String = "",

    @SerialName("owner_id")
    @ColumnInfo(name = "owner_id")
    val ownerId: Long = 0L,

    @SerialName("title")
    @ColumnInfo(name = "title")
    val title: String = "",

    @SerialName("subtitle")
    @ColumnInfo(name = "subtitle")
    val subtitle: String? = null,

    @SerialName("year")
    @ColumnInfo(name = "year")
    val year: Int = 0,

    @SerialName("count")
    @ColumnInfo(name = "count")
    val songCount: Int = 0,

    @SerialName("plays")
    @ColumnInfo(name = "plays")
    val playCount: Long = 0L,

    @SerialName("followers")
    @ColumnInfo(name = "followers")
    val followers: Int = 0,

    @SerialName("create_time")
    @ColumnInfo(name = "create_time")
    val createdAt: Long = 0L,

    @SerialName("update_time")
    @ColumnInfo(name = "update_time")
    val updatedAt: Long = 0L,

    @SerialName("is_explicit")
    @ColumnInfo(name = "is_explicit")
    val isExplicit: Boolean = false,

    @SerialName("main_artists")
    @ColumnInfo(name = "main_artists")
    val artists: List<Artist> = listOf(),

    @SerialName("genres")
    @ColumnInfo(name = "genres")
    val genres: List<Genre> = listOf(),

    @SerialName("photo")
    @ColumnInfo(name = "photo")
    val photo: Photo = Photo(),

    override var params: String = defaultParams,
    override var page: Int = defaultPage,
) : BasePaginatedEntity(), Parcelable {

    @Serializable
    @Parcelize
    data class Photo(
        @SerialName("photo_1200")
        val largeUrl: String = "",

        @SerialName("photo_600")
        val largeMedium: String = "",

        @SerialName("photo_300")
        val largeSmall: String = "",
    ) : Parcelable
}