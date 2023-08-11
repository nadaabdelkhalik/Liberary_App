import java.io.Serializable


data class JsonResult (

   var kind       : String?          = null,
  var totalItems : Int?             = null,
   var items      : ArrayList<Items> = arrayListOf()

): Serializable