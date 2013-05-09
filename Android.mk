# Copyright 2008 The Android Open Source Project
#
LOCAL_PATH:= $(call my-dir)
include $(CLEAR_VARS)

LOCAL_MODULE_TAGS := optional
LOCAL_SRC_FILES := $(call all-subdir-java-files)
LOCAL_MODULE := SVMPProtocol

include $(BUILD_STATIC_JAVA_LIBRARY)

# Include this library in the build server's output directory
$(call dist-for-goals, dist_files, $(LOCAL_BUILT_MODULE):SVMPProtocol.jar)
