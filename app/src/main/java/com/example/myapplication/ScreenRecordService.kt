package com.example.myapplication

import android.accessibilityservice.AccessibilityService
import android.util.Log
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityNodeInfo

class ScreenRecordService: AccessibilityService() {
    override fun onAccessibilityEvent(event: AccessibilityEvent?) {
        Log.d("yanshuang", "onAccessibilityEvent ${event?.toString()}")
        Log.d("yanshuang","----------------start-------------------")
//        findNode(rootInActiveWindow,1)
        findPicNode(rootInActiveWindow)
        Log.d("yanshuang", "-----------------end------------------")
    }

    override fun onInterrupt() {
        Log.d("yanshuang", "onInterrupt")
    }

    private fun findNode(nodeInfo: AccessibilityNodeInfo?, level: Int) {
        if (nodeInfo == null || nodeInfo.childCount == 0) {
            return
        }
        for (index in 0 until nodeInfo.childCount) {
            val root = nodeInfo.getChild(index) ?: continue
            Log.d("yanshuang", "${"--".repeat(level)}$root")

            if ("android.widget.ImageView".equals(root.className.toString())
                    && ("com.tencent.mm:id/b4e").equals(root.viewIdResourceName)) {
                root.performAction(AccessibilityNodeInfo.ACTION_CLICK)
                return
            }

            findNode(root,level + 1)
        }
    }

    private fun findPicNode(nodeInfo: AccessibilityNodeInfo?) {
        if (nodeInfo == null || nodeInfo.childCount == 0) {
            return
        }
        val recyclerViewNode = nodeInfo.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/b79")
        if (recyclerViewNode == null || recyclerViewNode.isEmpty()) {
            Log.d("yanshuang", "can not find recycler")
            return
        }
        for (index in 0 until recyclerViewNode.first().childCount) {
            val itemNode = recyclerViewNode.first().getChild(index)
            if (itemNode.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/b4e").isNullOrEmpty()) {
                continue
            }
            val clickNode = itemNode.findAccessibilityNodeInfosByViewId("com.tencent.mm:id/b47")
            if (!clickNode.isNullOrEmpty()) {
                clickNode.first().performAction(AccessibilityNodeInfo.ACTION_CLICK)
            }
        }
    }
}