# AdbRecovery
- THINKLET開発者向けのAdbを起動時に自動有効化するアプリです．
 
> [!CAUTION]
> 確実にAdb有効化を保証するものではありません．
> また，開発時のみご利用ください．

## 使い方
1. リリースからAPKを取得します．
2. 次のコマンドでTHINKLET（開発機）にインストールします．
   ```
   adb install -g thinklet.app.adbRecovety.apk
   ```
3. [scrcpy](https://github.com/Genymobile/scrcpy) で画面を表示しながら，下記のコマンドを実行し，Activityが立ち上がることを確認します．
   ```
   adb shell am start -n com.example.fd.adbrecovery/.MainActivity
   ```
4. **電源ボタンを操作して**，THINKLETを再起動してください．
5. 再起動直後に，次のコマンドで自動有効化の機能が動いていることを確認します．
    ```
    $ adb logcat | grep AdbRecoveryReceiver
    ```
    - 次のようなログが出力されていれば，正しく動作しています．
    ```
    09-26 19:27:29.658  1417  1460 I ActivityManager: Start proc 3125:com.example.fd.adbrecovery/u0a77 for broadcast com.example.fd.adbrecovery/.AdbRecoveryReceiver
    09-26 19:27:29.756  3125  3125 D AdbRecoveryReceiver: onReceived ACTION_BOOT_COMPLETED
    09-26 19:27:30.809  3125  3139 D AdbRecoveryReceiver: adbRepository.enable() ret=true
    ```

## ビルド
1. トークン発行
   - このアプリは，[thinklet.app.sdk](https://github.com/FairyDevicesRD/thinklet.app.sdk) を使用します．
   - [ここ](https://github.com/FairyDevicesRD/thinklet.app.sdk?tab=readme-ov-file#%E3%83%97%E3%83%AD%E3%82%B8%E3%82%A7%E3%82%AF%E3%83%88%E3%81%A7%E3%81%AE%E5%88%A9%E7%94%A8%E6%96%B9%E6%B3%95) に従い，Githubから，GitHub Packagesにあるライブラリを取得するためのトークンを発行します．
2. `local.properties` ファイルに追記します．
    ```
    TOKEN=ghp_***************
    USERNAME=your-github-account-name
    ```
3. AndroidStudioでビルドあるいは，`./gradlew assembleRelease` でビルドできます．
