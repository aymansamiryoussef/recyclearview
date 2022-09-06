package model

import com.google.gson.annotations.SerializedName

data class heddermodel  (
    @SerializedName(  "Accept")
    val accept: String,

    @SerializedName("Accept-Encoding")
    val acceptEncoding: String,

    @SerializedName("Accept-Language")
    val acceptLanguage: String,


)
