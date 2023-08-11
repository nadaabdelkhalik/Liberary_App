package com.example.example

import java.io.Serializable


data class SaleInfo (
 var country     : String?           = null,
  var saleability : String?           = null,
 var isEbook     : Boolean?          = null,
 var listPrice   : ListPrice?        = ListPrice(),
   var retailPrice : RetailPrice?      = RetailPrice(),
   var buyLink     : String?           = null,
   var offers      : ArrayList<Offers> = arrayListOf()

):Serializable