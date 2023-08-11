

import com.example.example.SaleInfo
import com.example.example.SearchInfo
import com.example.example.VolumeInfo
import java.io.Serializable

data class Items(
 var kind: String? = null,
 var id: String? = null,
 var etag: String? = null,
 var selfLink: String? = null,
 var volumeInfo: VolumeInfo? = VolumeInfo(),
 var saleInfo: SaleInfo? = SaleInfo(),
 var searchInfo: SearchInfo? = SearchInfo()
) : Serializable
