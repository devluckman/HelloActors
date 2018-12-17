package com.man.helloactors.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ActorsItem(
    @SerializedName("id") var id: Int?,
	@SerializedName("country") var country: String?,
	@SerializedName("image") var image: String?,
	@SerializedName("children") var children: String? ,
	@SerializedName("dob") var dob: String?,
    @SerializedName("name") var name: String?,
	@SerializedName("description") var description: String?,
	@SerializedName("spouse") var spouse: String?,
	@SerializedName("height") var height: Int?
) : Parcelable