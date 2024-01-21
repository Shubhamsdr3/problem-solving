package designapatterns.creational.factory


fun main() {
    val androidOs = PhoneFactory().getInstance(OSTypes.ANDROID.name)
    val windowsOS = PhoneFactory().getInstance(OSTypes.ANDROID.name)
    windowsOS.specification()
}