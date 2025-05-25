cmake_minimum_required(VERSION 3.22.1)

# Step 1: Create your native C++ library
add_library(
        edgeviewer
        SHARED
        native-lib.cpp)

# Step 2: Include the OpenCV header directory (full path)
include_directories("D:/EdgeViewerApp/app/openCV/include")

# Step 3: Import the OpenCV .so library
add_library(opencv_java4 SHARED IMPORTED)

set_target_properties(opencv_java4 PROPERTIES
        IMPORTED_LOCATION
        "D:/EdgeViewerApp/app/openCV/libs/${ANDROID_ABI}/libopencv_java4.so")

# Step 4: Link your native lib with OpenCV + required Android libs
target_link_libraries(
        edgeviewer
        opencv_java4
        log
        android
        jnigraphics
        c++_shared
)
