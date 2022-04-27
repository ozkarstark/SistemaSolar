package com.example.example

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Root (
  @Expose  @SerializedName("data" ) var data : List<Data>
)

data class Data (
  @SerializedName("name"    ) var name    : String? = "hechicero",
  @SerializedName("summary" ) var summary : String? = "hechicero",
  @SerializedName("text"    ) var text    : String? = "hechicero",
  @SerializedName("image"   ) var image   : String? = "hechicero"

)