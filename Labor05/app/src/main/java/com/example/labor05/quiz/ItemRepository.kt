import androidx.compose.ui.res.stringArrayResource
import androidx.compose.ui.res.stringResource
import com.example.labor05.R
import java.io.File
import java.util.*

class ItemRepository {
    private val items = mutableListOf<Item>()

    fun randomItem(): Item {
        return items[(0..5).random()]
    }

    fun saveItem(item: Item) {
        items.add(item)
    }

    fun size(): Int {
        return items.size
    }
}