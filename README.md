# MetaMask Android SDK
[Metamask Android SDK](https://github.com/MetaMask/metamask-mobile/tree/main/android) 에서 
`org.jetbrains.kotlin.android`, `gradle` version을 낮추고 일부 dependency를 제거한 버전

* 사용 dependency
```
implementation 'com.squareup.okhttp3:okhttp:4.9.2'
implementation 'androidx.security:security-crypto:1.1.0-alpha06'
implementation 'com.google.code.gson:gson:2.9.0'
implementation 'org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2'
```

* 제거한 dependency
```
implementation "com.google.dagger:hilt-android:$hilt_version"
kapt "com.google.dagger:hilt-compiler:$hilt_version"
implementation 'androidx.core:core-ktx:1.9.0'
implementation 'androidx.appcompat:appcompat:1.6.1'
implementation 'com.google.android.material:material:1.9.0'
implementation 'androidx.constraintlayout:constraintlayout:2.1.4'
```
