package com.example.baidusdktest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.baidu.idl.main.facesdk.FaceAuth
import com.example.baidusdktest.ui.theme.BaiduSDKTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BaiduSDKTestTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
        getData()
    }

    fun getData() {
        val faceAuth = FaceAuth()
        var initStatus = 1;
        Log.d("WCJ", "before:" + initStatus)
        var DeviceID=faceAuth.getDeviceId(this)


        Log.d("WCJ", "DeviceID:" + DeviceID)
        if(true){
            var licenseOnlineKey = "CAXV-HXLF-X3XM-UGCR"
            faceAuth.initLicenseOnLine(this,licenseOnlineKey) { code, response ->
                if (code == 0) {
                    initStatus = 6
                    Log.d("WCJ", "after:" + initStatus)
                    Log.d("WCJ", DeviceID)
                    Log.d("WCJ","licenseKey:"+faceAuth.getAuthInfo(this).licenseKey)
                    Log.d("WCJ","algorithmId:"+faceAuth.getAuthInfo(this).algorithmId)
                    Log.d("WCJ","packageName:"+faceAuth.getAuthInfo(this).packageName)
                    Log.d("WCJ","md5:"+faceAuth.getAuthInfo(this).md5)
                    Log.d("WCJ","deviceId:"+faceAuth.getAuthInfo(this).deviceId)
                    Log.d("WCJ","expireTime:"+faceAuth.getAuthInfo(this).expireTime)
                    Log.d("WCJ","functionList:"+faceAuth.getAuthInfo(this).functionList)
                } else {
                    initStatus = 2
                    Log.d("WCJ", "after:" + initStatus)
                }
            }
        }

        if(false){
            faceAuth.initLicenseOffLine(this) { code, response ->
                if (code == 0) {
                    initStatus = 6
                    Log.d("WCJ", "after:" + initStatus)
                    Log.d("WCJ", DeviceID)
                    Log.d("WCJ","licenseKey:"+faceAuth.getAuthInfo(this).licenseKey)
                    Log.d("WCJ","algorithmId:"+faceAuth.getAuthInfo(this).algorithmId)
                    Log.d("WCJ","packageName:"+faceAuth.getAuthInfo(this).packageName)
                    Log.d("WCJ","md5:"+faceAuth.getAuthInfo(this).md5)
                    Log.d("WCJ","deviceId:"+faceAuth.getAuthInfo(this).deviceId)
                    Log.d("WCJ","expireTime:"+faceAuth.getAuthInfo(this).expireTime)
                    Log.d("WCJ","functionList:"+faceAuth.getAuthInfo(this).functionList)
                } else {
                    if (code == 7) {
                        Log.d("WCJ", "code:" + "激活失败，设备硬件指纹与License.zip不符")
                    } else if (code == 11) {
                        Log.d("WCJ", "code:" + "激活失败，License.zip文件对应的序列号不在有效期范围内")
                    } else if (code == -1) {
                        Log.d("WCJ", "code:" + "未检测到License.zip文件")
                    } else if (code == 14) {
                        Log.d("WCJ", "code:" + "激活失败，License.zip文件对应的序列号不在有效期范围内")
                    } else if (code == 4) {
                        Log.d("WCJ", "code:" + "激活失败，设备硬件指纹与License.zip不符")
                    } else {
                        Log.d("WCJ", "code:" + code)
                    }
                }
            }
        }
        }

}



@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BaiduSDKTestTheme {
        Greeting("Android")
    }
}