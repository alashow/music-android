/*
 * Copyright (C) 2021, Alashov Berkeli
 * All rights reserved.
 */
package tm.alashow.datmusic.domain.entities

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import tm.alashow.domain.models.BasePaginatedEntity

@Parcelize
@Serializable
@Entity(tableName = "audios")
data class Audio(
    @SerialName("id")
    @ColumnInfo(name = "id")
    override val id: String = "",

    @SerialName("key")
    @ColumnInfo(name = "key")
    val searchKey: String = "",

    @SerialName("source_id")
    @ColumnInfo(name = "source_id")
    val sourceId: String = "",

    @SerialName("artist")
    @ColumnInfo(name = "artist")
    val artist: String = "Unknown",

    @SerialName("title")
    @ColumnInfo(name = "title")
    val title: String = "Untitled Song",

    @SerialName("duration")
    @ColumnInfo(name = "duration")
    val duration: Int = 0,

    @SerialName("date")
    @ColumnInfo(name = "date")
    val date: Long = 0L,

    @SerialName("album")
    @ColumnInfo(name = "album")
    val album: String? = null,

    @SerialName("cover_url")
    @ColumnInfo(name = "cover_url")
    val coverUrl: String? = null,

    @SerialName("cover_url_medium")
    @ColumnInfo(name = "cover_url_medium")
    val coverUrlMedium: String? = null,

    @SerialName("cover_url_small")
    @ColumnInfo(name = "cover_url_small")
    val coverUrlSmall: String? = null,

    @SerialName("cover")
    @ColumnInfo(name = "cover")
    val coverAlternate: String = "",

    @SerialName("download")
    @ColumnInfo(name = "download")
    val downloadUrl: String? = null,

    @SerialName("stream")
    @ColumnInfo(name = "stream")
    val streamUrl: String? = null,

    @Transient
    @ColumnInfo(name = "params")
    override var params: String = defaultParams,

    @Transient
    @ColumnInfo(name = "page")
    override var page: Int = defaultPage,

    @PrimaryKey
    val primaryKey: String = "",

    @Transient
    @ColumnInfo(name = "search_index")
    val searchIndex: Int = 0,
) : BasePaginatedEntity(), Parcelable {

    fun buildFileDisplayName() = "$artist - $title"
    fun buildFileMimeType() = "audio/mpeg"
}
