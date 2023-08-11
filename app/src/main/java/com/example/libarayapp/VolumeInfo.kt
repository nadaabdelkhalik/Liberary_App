package com.example.example

import java.io.Serializable


data class VolumeInfo (
var title: String? = null,
   var authors             : ArrayList<String>              = arrayListOf(),
   var publisher           : String?                        = null,
  var publishedDate       : String?                        = null,
var description         : String?                        = null,
 var pageCount           : Int?                           = null,
var printType : String?                        = null,
var categories          : ArrayList<String>              = arrayListOf(),
var averageRating       : Double?                        = null,
var ratingsCount        : Int?                           = null,
 var maturityRating      : String?                        = null,
  var allowAnonLogging    : Boolean?                       = null,
   var contentVersion      : String?                        = null,
  var imageLinks          : ImageLinks?                    = ImageLinks(),
  var language            : String?                        = null,
  var previewLink         : String?                        = null,
   var infoLink            : String?                        = null,
  var canonicalVolumeLink : String?                        = null

): Serializable