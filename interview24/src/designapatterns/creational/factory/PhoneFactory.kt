package designapatterns.creational.factory

class PhoneFactory {

    fun getInstance(osType: String): OperatingSystem {
        return when(osType) {
            OSTypes.APPLE.name -> AppleOS()
            OSTypes.ANDROID.name -> AndroidOs()
            else -> WindowsOS()
        }
    }
}

