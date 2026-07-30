import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent

class AutoClickService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        // Olayları dinlemek gerekmiyorsa boş bırakılabilir
    }

    override fun onInterrupt() {
        // Servis kesintiye uğradığında yapılacak işlemler
    }

    // Belirtilen (x, y) koordinatına dokunma hareketi gönderir
    fun clickAt(x: Float, y: Float) {
        val path = Path().apply {
            moveTo(x, y)
        }

        // 1 ms süren dokunma hareketi oluşturulur
        val builder = GestureDescription.Builder()
        val stroke = GestureDescription.StrokeDescription(path, 0, 1)
        builder.addStroke(stroke)

        // Hareketi ekrana gönder
        dispatchGesture(builder.build(), null, null)
    }
}
