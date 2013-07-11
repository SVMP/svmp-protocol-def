# Copyright 2008 The Android Open Source Project
#
LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-subdir-java-files)
LOCAL_STATIC_JAVA_LIBRARIES := protobuf-2.5.0
LOCAL_MODULE := SVMPProtocol

include $(BUILD_STATIC_JAVA_LIBRARY)

include $(CLEAR_VARS)
LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := protobuf-2.5.0:protobuf-2.5.0/protobuf-java-2.5.0.jar
include $(BUILD_MULTI_PREBUILT)

# Include this library in the build server's output directory
$(call dist-for-goals, dist_files, $(LOCAL_BUILT_MODULE):SVMPProtocol.jar)
