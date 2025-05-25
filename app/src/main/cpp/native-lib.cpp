#include <jni.h>
#include <string>
#include <opencv2/core.hpp> // Required for cv::Mat

extern "C"
JNIEXPORT jstring JNICALL
Java_com_main_edgeviewer_MainActivity_testOpenCV(JNIEnv* env, jobject) {
    try {
        cv::Mat mat = cv::Mat::eye(3, 3, CV_8UC1);
        uchar val = mat.at<uchar>(0, 0);
        std::string msg = "OpenCV Works! Value = " + std::to_string(val);
        return env->NewStringUTF(msg.c_str());
    } catch (...) {
        return env->NewStringUTF("OpenCV failed.");
    }
}
