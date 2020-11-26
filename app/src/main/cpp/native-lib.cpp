#include <jni.h>
#include <string>
#include "android/bitmap.h"
#include "libyuv.h"
extern "C" JNIEXPORT void JNICALL
Java_com_example_libyuv_MainActivity_RGBAToBGAR(JNIEnv* env,
                                                jobject obj,
                                                jobject bitmap,
                                                int width,
                                                int height)
{
    unsigned char* pixels = NULL;
    if (AndroidBitmap_lockPixels(env, bitmap, (void**)&pixels) < 0) {
        return;
    }
    for (int i = 0; i < width * height * 4; i += 4){
        pixels[i] = 255;
        pixels[i + 1] = 0;
        pixels[i + 2] = 0;
        pixels[i + 3] = 255;
    }
    pixels += 10 * 4;
    libyuv::ARGBToABGR(pixels, width * 4, pixels, width * 4, 30, 30);
    AndroidBitmap_unlockPixels(env, bitmap);
}
